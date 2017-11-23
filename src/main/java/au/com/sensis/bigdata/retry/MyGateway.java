package au.com.sensis.bigdata.retry;

public class MyGateway {

    private RetryCommand retryCommand;

    public MyGateway(int maxRetries, int secondsToWait) {
        retryCommand = new RetryCommand(maxRetries, secondsToWait);
    }

    public RetryCommand getRetryCommand() {
        return retryCommand;
    }

    public static void main(String[] args) {
        MyGateway myGateway = new MyGateway(3, 10);
        myGateway.getRetryCommand().run(() -> {
            System.out.printf("Hello");
            return "Hi there!";

        });
    }

}
