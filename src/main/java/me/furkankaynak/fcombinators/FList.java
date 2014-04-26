package me.furkankaynak.fcombinators;

import me.furkankaynak.fcombinators.util.FArrayList;

import java.util.List;

/**
 * Created by furkan on 4/23/14.
 */
public class FList {

    public static <T> FArrayList<T> init(List<T> list) {
        return new FArrayList<T>(list);
    }

}
