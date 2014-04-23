USAGE
=====

```java
import me.furkankaynak.fcombinators.F;
import me.furkankaynak.fcombinators.M;
import me.furkankaynak.fcombinators.Pair;
import me.furkankaynak.fcombinators.impl.FList;

import java.util.LinkedList;
import java.util.List;

List<Integer> intList = new LinkedList<Integer>();
intList.add(2);
intList.add(3);
intList.add(4);
intList.add(5);
intList.add(6);

List<String> strList = new LinkedList<String>();
strList.add("a");
strList.add("b");
strList.add("c");
strList.add("d");

List<String> map = FList.map(intList, new M<Integer, String>() {
    @Override
    public String process(Integer nextItem) {
        return nextItem + "a";
    }
});

List<Integer> filter = FList.filter(intList, new F<Integer>() {
    @Override
    public boolean process(Integer e) {
        return e / 5 == 1;
    }
});

List<Pair<Integer,String>> zip = FList.zip(intList, strList);

Pair<List<Integer>, List<Integer>> partition = FList.partition(intList, new F<Integer>() {
    @Override
    public boolean process(Integer e) {
        return e % 2 == 0;
    }
});

System.out.println(map);
System.out.println(filter);
System.out.println(zip);
System.out.println(partition);


```
