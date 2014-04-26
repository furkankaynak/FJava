USAGE (EXAMPLE CLASS)
=====

```java
import me.furkankaynak.fcombinators.F;
import me.furkankaynak.fcombinators.FList;
import me.furkankaynak.fcombinators.M;
import me.furkankaynak.fcombinators.util.FArrayList;
import me.furkankaynak.fcombinators.util.Pair;

import java.util.*;

/**
 * Created by furkan on 4/23/14.
 */
public class Example {

    private static class Hi {
        private int first;
        private String second;

        private Hi(int first, String second) {
            this.first = first;
            this.second = second;
        }

        private Hi() {
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "< " + getFirst() + " - " + getSecond() + " >";
        }
    }


    public static void main(String[] args) {

        List<Integer> intList = new LinkedList<Integer>();
        for (int i = 0 ; i < 5; i ++) {
            intList.add(i);
        }

        List<String> strList = new LinkedList<String>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");

        FArrayList<Integer> fal = FList.init(intList);

        /*
        * map, filter, zip example
        * M<T, R> . R is return type
         */

        ArrayList<Hi> map = fal.map(new M<Integer, Hi>() {
            @Override
            public Hi process(Integer e) {
                return new Hi(e, null);
            }
        }).map(new M<Hi, Hi>() {
            @Override
            public Hi process(Hi e) {
                e.setSecond(e.getFirst() + ".st");
                return e;
            }
        }).filter(new F<Hi>() {
            @Override
            public boolean process(Hi e) {
                return e.getFirst() % 2 == 0;
            }
        }).zip(strList).collect(ArrayList.class);

        /*
        * map, filter, zip example
         */

        Pair<FArrayList<Integer>,FArrayList<Integer>> partition = fal.partition(new F<Integer>() {
            @Override
            public boolean process(Integer e) {
                return e % 2 == 0;
            }
        });

        ArrayList collect1 = partition.get_0().collect(ArrayList.class);
        ArrayList collect2 = partition.get_1().collect(ArrayList.class);

        /*
        * RESULTS
         */
        System.out.println(map);
        //    [(< 0 - 0.st >, a), (< 2 - 2.st >, b), (< 4 - 4.st >, c)]

        System.out.println(partition);
        //        ([0, 2, 4], [1, 3])

        System.out.println(collect1);
        //        [0, 2, 4]

        System.out.println(collect2);
//        [1, 3]

    }
}



```
