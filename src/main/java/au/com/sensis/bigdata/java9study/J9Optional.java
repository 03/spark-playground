package au.com.sensis.bigdata.java9study;

import java.util.Optional;

public class J9Optional {

    public static void main(String[] args) {

        Optional<String> s = Optional.of("Hi");
        Optional<Integer> i = Optional.empty();

        s.map(String::toUpperCase);
        i.map(n -> n+1);

        String sValue = s.orElse(s.get());

        // ifPresentOrElse, or,
    }

}
