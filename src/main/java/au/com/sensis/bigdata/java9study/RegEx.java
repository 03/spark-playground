package au.com.sensis.bigdata.java9study;

/**
 * https://www.javatpoint.com/java-regex
 */
public class RegEx {

    public static int iCount = 0;

    public static void main(String[] args) throws InterruptedException {
        /*String url1 = "aaa-ddd-vvv-123123-asd";
        String result = url1.replaceAll("\\W", " ");
        System.out.println(result);*/

        while(true) {
            hello();
//            System.out.println("Hello again!!!!!!!!!!!!!!!!");
            Thread.sleep(2000);

        }
    }

    public static void hello() {
        iCount++;
        System.out.println("Hello -> " + iCount);
    }
}
