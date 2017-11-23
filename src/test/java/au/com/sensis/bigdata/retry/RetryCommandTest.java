package au.com.sensis.bigdata.retry;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RetryCommandTest {

    @BeforeClass
    public static void init() {

    }

    public String SUCCESS = "success";
    public int MAXRETRIES = 3;
    public int SECONDSTOWAIT = 5;

    RetryCommand<String> retryCommand;

    @Test
    public void testRetryCommandShouldNotRetryCommandWhenSuccessful() {
        retryCommand = new RetryCommand<>(MAXRETRIES, SECONDSTOWAIT);

        String result = retryCommand.run(() -> SUCCESS);

        assertEquals(SUCCESS, result);
        assertEquals(0, retryCommand.getRetryCounter());
    }

    @Test
    public void testRetryCommandShouldRetryOnceThenSucceedWhenFailsOnFirstCallButSucceedsOnFirstRetry() {
        retryCommand = new RetryCommand<>(MAXRETRIES, SECONDSTOWAIT);

        String result = retryCommand.run(() -> {
            if (retryCommand.getRetryCounter() == 0) throw new RuntimeException("Command Failed");
            else return SUCCESS;
        });

        assertEquals(SUCCESS, result);
        assertEquals(1, retryCommand.getRetryCounter());
    }

    @Test
    public void testRetryCommandShouldThrowExceptionWhenMaxRetriesIsReached() {
        retryCommand = new RetryCommand<>(MAXRETRIES, SECONDSTOWAIT);

        try {
            retryCommand.run(() -> {throw new RuntimeException("Failed");});
            fail("Should throw exception when max retries is reached");
        } catch (Exception e) { }
    }

}