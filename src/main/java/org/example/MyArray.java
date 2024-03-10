package org.example;

import java.util.Comparator;

public interface MyArray<T> extends Iterable<T> {
    boolean add(T element);
    void add(int index, T element);
    T get(int index);
    void remove(int index);
    void clear();
    void sort(Comparator<T> comparator);
}
