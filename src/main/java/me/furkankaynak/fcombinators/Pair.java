package me.furkankaynak.fcombinators;

/**
 * Created by furkan on 4/23/14.
 */
public class Pair<T,E> {
    private T _0;
    private E _1;

    public Pair(T _0, E _1) {
        this._0 = _0;
        this._1 = _1;
    }

    public Pair() {
    }

    public T get_0() {
        return _0;
    }

    public void set_0(T _0) {
        this._0 = _0;
    }

    public E get_1() {
        return _1;
    }

    public void set_1(E _1) {
        this._1 = _1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (_0 != null ? !_0.equals(pair._0) : pair._0 != null) return false;
        if (_1 != null ? !_1.equals(pair._1) : pair._1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _0 != null ? _0.hashCode() : 0;
        result = 31 * result + (_1 != null ? _1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(get_0().toString());
        sb.append(", ");
        sb.append(get_1().toString());
        sb.append("}");
        return sb.toString();
    }
}


