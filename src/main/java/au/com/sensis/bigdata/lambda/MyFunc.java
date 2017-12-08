package au.com.sensis.bigdata.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * http://www.baeldung.com/java-8-functional-interfaces
 */
public class MyFunc {

    public static void main(String[] args) {

        // 1
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John Smith", s -> s.length());
        System.out.println(value);


        // 2
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        System.out.println(quoteIntToString.apply(555));

        // 3
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);

        System.out.println(salaries);

    }
}
