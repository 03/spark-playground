package au.com.sensis.bigdata.java9study;

import java.util.Set;
import java.util.stream.Stream;

/**
 * https://app.pluralsight.com/player?course=java-9-whats-new&author=sander-mak&name=java-9-whats-new-m3&clip=2&mode=live
 */
public class J9OfNullable {

    public static void main(String[] args) {

        Book book = new Book("Java 9 improvements", Set.of("Dave", "Jacky"), 29.99);
        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(book.getBook()).count();

        System.out.printf("zero: %d, one: %d", zero, one);

    }
}
