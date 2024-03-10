package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyArray<T>{
    private T[] elements;

    public MyArrayList() {
        elements = (T[]) new Object[0];
    }

    @Override
    public boolean add(T element) {
        try {
            T[] temp = elements;
            elements = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, elements, 0, temp.length);
            elements[elements.length - 1] = element;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException("Недопустимое значение индекса");
        }
        elements[index] = element;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Недопустимое значение индекса");
        }
        try {
            T[] temp = elements;
            elements = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, //откуда
                    elements, index,          //куда
                    amountElementsAfterIndex);//сколько
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[0];
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort(elements, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(elements);
    }

    @Override
    public String toString() {
        return "Мой лист{" +
                " с элементами = " + Arrays.toString(elements) +
                '}';
    }
}
