package au.com.sensis.bigdata.retry;

import java.util.function.Supplier;

/**
 * https://myadventuresincoding.wordpress.com/2014/07/30/java-creating-a-simple-retry-command-with-function-passing-in-java-8/
 * * https://stackoverflow.com/questions/11692595/design-pattern-for-retrying-logic-that-failed
 *
 * <p>
 * Java 8 uses Functional Interfaces, which are interfaces with a single abstract method. The package java.util.function defines a number
 * of standard functional interfaces, so most of the time you will be able to use one of these. Some example functional interfaces are
 * Function (function with return value and input param), Supplier (function with return value but no input param), and Consumer
 * (function with input param but no return value). However, if one of these standard functional interfaces does not meet your needs
 * you can always define your own. In the following example I used Supplier.
 *
 * @param <T>
 */

public class RetryCommand<T> {

    private int retryCounter;
    private int maxRetries;
    private int secondsToWait;

    public RetryCommand(int maxRetries, int secondsToWait) {
        this.maxRetries = maxRetries;
        this.secondsToWait = secondsToWait;
    }

    // Takes a function and executes it, if fails, passes the function to the retry command
    public T run(Supplier<T> function) {
        try {
            return function.get();
        } catch (Exception e) {
            return retry(function);
        }
    }

    public int getRetryCounter() {
        return retryCounter;
    }

    private T retry(Supplier<T> function) throws RuntimeException {

        System.out.println("FAILED - Command failed, will be retried " + maxRetries + " times.");
        retryCounter = 0;

        while (retryCounter < maxRetries) {
            try {
                return function.get();
            } catch (Exception ex) {
                retryCounter++;
                System.out.println("FAILED - Command failed on retry " + retryCounter + " of " + maxRetries + " error: " + ex);

                try {
                    System.out.println("Sleeping for " + secondsToWait + " seconds.");
                    Thread.sleep(secondsToWait * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (retryCounter >= maxRetries) {
                    System.out.println("Max retries exceeded.");
                    break;
                }
            }
        }
        throw new RuntimeException("Command failed on all of " + maxRetries + " retries");
    }
}
