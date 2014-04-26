package me.furkankaynak.fcombinators.util;

import me.furkankaynak.fcombinators.F;
import me.furkankaynak.fcombinators.M;

import java.util.*;

/**
 * Created by furkan on 4/26/14.
 */
public class FArrayList<T> extends ArrayList<T> implements List<T>, Combinator<T> {

    public FArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public FArrayList() {
    }

    public FArrayList(Collection<? extends T> c) {
        super(c);
    }

    public FArrayList(T[] list) {
        super(Arrays.asList(list));
    }

    @Override
    public <R> FArrayList<R> map(final M<T, R> m) {
        FArrayList<R> newList = new FArrayList<R>();

        for (T item : this) {
            newList.add(m.process(item));
        }

        return newList;
    }

    @Override
    public FArrayList<T> filter(final F<T> f) {
        FArrayList<T> newList = new FArrayList<T>();

        for (T item : this) {
            if (f.process(item)) {
                newList.add(item);
            }
        }

        return newList;
    }

    @Override
    public <E> FArrayList<Pair<T, E>> zip(final List<E> secondList) {
        FArrayList<Pair<T,E>> returnList = new FArrayList<Pair<T, E>>();
        final int size = this.size() <= secondList.size() ? this.size() : secondList.size();

        for (int i = 0 ; i < size ; i++ ) {
            returnList.add(new Pair<T, E>(this.get(i), secondList.get(i)));
        }

        return returnList;
    }

    @Override
    public Pair<FArrayList<T>, FArrayList<T>> partition(final F<T> f) {
        Pair<FArrayList<T>, FArrayList<T>> returnList = new Pair<FArrayList<T>, FArrayList<T>>();
        FArrayList<T> first = new FArrayList<T>();
        FArrayList<T> second = new FArrayList<T>();

        for (T item : this) {
            if (f.process(item)) {
                first.add(item);
            } else {
                second.add(item);
            }
        }

        returnList.set_0(first);
        returnList.set_1(second);

        return returnList;
    }

    @Override
    public <E extends List> E collect(Class<E> clazz) {
        E e = null;

        try {
            e = clazz.newInstance();
            e.addAll(this);

        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }

        return e;
    }
}
