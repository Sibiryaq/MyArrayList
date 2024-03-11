package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyArray<T> {
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
            System.arraycopy(temp, index + 1,
                    elements, index,
                    amountElementsAfterIndex);
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
        return "MyArrayList{" +
                "с элементами = " + Arrays.toString(elements) +
                '}';
    }


    public void quickSort(Comparator<T> comparator) {
        quickSort(elements, 0, elements.length - 1, comparator);
    }

    private void quickSort(T[] elements, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int partitionIndex = partition(elements, low, high, comparator);
            quickSort(elements, low, partitionIndex - 1, comparator);
            quickSort(elements, partitionIndex + 1, high, comparator);
        }
    }

    private int partition(T[] elements, int low, int high, Comparator<T> comparator) {
        T median = elements[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (comparator.compare(elements[i], median) < 0);

            do {
                j--;
            } while (comparator.compare(elements[j], median) > 0);

            if (i < j) {
                T temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
            } else {
                return j;
            }
        }
    }

}
