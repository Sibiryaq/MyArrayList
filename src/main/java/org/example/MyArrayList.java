package org.example;

import java.util.Arrays;

/**
 * MyArrayList саморасширяющийся список, который может хранить элементы любого типа.
 *
 * @param <T> тип элемента добавляемого в список
 */
public class MyArrayList<T> {

    private Object[] elements;
    public int size;

    public MyArrayList() {
        elements = new Object[3];
        size = 0;
    }

    /**
     * Метод add(T element) добавляет элемент в конец списка. Если список полон, происходит его увеличение в 2 раза
     *
     * @param element добавляемый элемент
     */
    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Добавляет элемент в список по указанному индексу. Если список полон, происходит его увеличение в 2 раза.
     *
     * @param index   индекс
     * @param element элемент
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Указанный индекс должен быть >= 0 и <= длине списка.");
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент из списка по указанному индексу.
     *
     * @param index индекс в списке
     * @return возврат элемента
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент из списка по указанному индексу.
     *
     * @param index индекс в списке
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Указанный индекс должен быть >= 0 и <= длине списка.");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    /**
     * Очищает список от всех элементов.
     */
    public void clear() {
        size = 0;
        elements = new Object[10];
    }

    /**
     * Cортирует список используя Arrays.sort().
     */
    @SuppressWarnings("unchecked")
    public void sort() {
        Arrays.sort((T[]) elements, 0, size);
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * Быстрая сортировка:
     * 1.Выбираем опорный элемент из массива.
     * 2.Делим массив на 2 подмассива. Элементы, которые меньше опорного, и элементы, которые больше опорного.
     * 3.Рекурсивно применяем сортировку к обоим подмассивам.
     */
    public void quicksort() {
        quicksort(0, size - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1);
            quicksort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    @SuppressWarnings("unchecked")
    private int compare(T obj1, T obj2) {
        if (obj1 instanceof Comparable && obj2 instanceof Comparable) {
            return ((Comparable<T>) obj1).compareTo(obj2);
        } else {
            throw new UnsupportedOperationException("Класс T должен реализовывать интерфейс Comparable<T>.");
        }
    }
}
