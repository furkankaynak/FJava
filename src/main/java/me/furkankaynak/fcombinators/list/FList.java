package me.furkankaynak.fcombinators.list;

import me.furkankaynak.fcombinators.F;
import me.furkankaynak.fcombinators.M;
import me.furkankaynak.fcombinators.Pair;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by furkan on 4/23/14.
 */
public class FList {

    public static <T,R> List<R> map(final List<T> collection, final M<T, R> m) {
        Iterator<T> itr = collection.iterator();
        List<R> newList = null;

        try {
            newList = collection.getClass().newInstance();

            while (itr.hasNext()) {
                T nextItem = itr.next();
                newList.add(m.process(nextItem));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return newList;
    }

    public static <T> List<T> filter(final List<T> collection, final F<T> f) {
        Iterator<T> itr = collection.iterator();
        List<T> newList = null;

        try {
            newList = collection.getClass().newInstance();

            while (itr.hasNext()) {
                T nextItem = itr.next();
                if (f.process(nextItem)) {
                    newList.add(nextItem);
                }
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return newList;
    }

    public static <X extends List,T,E> List<Pair<T, E>> zip(final List<T> first, final List<E> second, Class<X> clazz) {
        List<Pair<T,E>> returnVal = null;
        try {
            returnVal = clazz.newInstance();
            final int size = first.size() <= second.size() ? first.size() : second.size();

            for (int i = 0 ; i < size ; i++ ) {
                returnVal.add(new Pair<T, E>(first.get(i), second.get(i)));
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return returnVal;
    }

    public static <X extends List,T,E> List<Pair<T, E>> zip(final List<T> first, final List<E> second) {
        return zip(first, second, LinkedList.class);
    }

    public static <T> Pair<List<T>, List<T>> partition(List<T> list, F<T> f) {
        Pair<List<T>, List<T>> returnVal = new Pair<List<T>, List<T>>();
        Iterator<T> itr = list.iterator();
        try {
            List<T> first = list.getClass().newInstance();
            List<T> second = list.getClass().newInstance();

            while (itr.hasNext()) {
                T nextItem = itr.next();
                if (f.process(nextItem)) {
                    first.add(nextItem);
                } else {
                    second.add(nextItem);
                }
            }

            returnVal.set_0(first);
            returnVal.set_1(second);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return returnVal;
    }

}
