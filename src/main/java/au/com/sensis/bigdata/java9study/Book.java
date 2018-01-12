package au.com.sensis.bigdata.java9study;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;
import java.util.stream.Stream;

public class Book {

    public final String title;
    public final Set<String> authors;
    public final double price;

    public Book(String title, Set<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public Book getBook() {
        return this;
    }

    public Stream<Book> getBooks() {
        return Stream.ofNullable(this);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("authors", authors)
                .append("price", price)
                .toString();
    }

    public static void main(String[] args) {

    }
}
