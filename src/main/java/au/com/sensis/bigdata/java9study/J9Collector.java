package au.com.sensis.bigdata.java9study;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class J9Collector {

    public static void main(String[] args) {

        List<Integer> ints = Stream.of(1,2,3).map(n->n+1).collect(Collectors.toList());
        System.out.println(ints);

        Map<Integer, List<Integer>> intsMap = Stream.of(1,2,3,3).collect(groupingBy(i->i %2, toList()));
        System.out.println(intsMap);

        //filtering, flatMapping

    }

}
