package me.furkankaynak.fcombinators.util;

import me.furkankaynak.fcombinators.F;
import me.furkankaynak.fcombinators.M;

import java.util.List;

/**
 * Created by furkan on 4/26/14.
 */
public interface Combinator<T> {

    public <R> FArrayList<R> map(M<T, R> m);

    public FArrayList<T> filter(F<T> f);

    public <E> FArrayList<Pair<T, E>> zip(List<E> secondList);

    public Pair<FArrayList<T>, FArrayList<T>> partition(F<T> f);

    public <E extends List> E collect(Class<E> clazz);
}
