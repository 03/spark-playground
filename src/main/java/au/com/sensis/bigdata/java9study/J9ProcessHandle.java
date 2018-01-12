package au.com.sensis.bigdata.java9study;

import java.time.Instant;
import java.util.Comparator;

/**
 * https://app.pluralsight.com/player?course=java-9-whats-new&author=sander-mak&name=java-9-whats-new-m4&clip=1&mode=live
 */
public class J9ProcessHandle {


    public static void main(String[] args) {

        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
                .forEach(J9ProcessHandle::printInfo);

        ProcessHandle jshellHandle = ProcessHandle.allProcesses()
                .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("jshell")).orElse(false))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(jshellHandle.info());

        jshellHandle.onExit()
                .thenAccept(h -> System.out.println("JShell killed by Java"));

        boolean shutdown = jshellHandle.destroy();
        jshellHandle.onExit().join();

        System.out.println("Shutdown? " + shutdown);

    }

    private static void printInfo(ProcessHandle.Info info) {
        if (info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get() +
                ", Command: " + info.command().get());
        }
    }
}
