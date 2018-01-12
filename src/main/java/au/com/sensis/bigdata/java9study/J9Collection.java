package au.com.sensis.bigdata.java9study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J9Collection {

    public static void main(String[] args) {

        List<String> bookList = new ArrayList<>();
        bookList.add("Java 9 Modularity");
        bookList.add("Java 9 - New lambdas??");

        List<String> bookListNew = List.of("Book1", "Book2", "aa");

        System.out.println(bookList);
        System.out.println(bookListNew);

        Set<String> bookSet = new HashSet<>();
        bookSet.add("book1");
        bookSet.add("book2");

        Set<String> bookSetNew = Set.of("book1", "book2", "book3");

        System.out.println(bookSet);
        System.out.println(bookSetNew.getClass());

    }

}
