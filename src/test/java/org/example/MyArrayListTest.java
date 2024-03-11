package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    @DisplayName("Добавление элемента в пустой лист")
    public void testAddElementToEmptyList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        assertEquals(1, list.size);
        assertEquals(Integer.valueOf(10), list.get(0));
    }

    @Test
    @DisplayName("Добавление элемента вместе с добавлением по индексу")
    public void testAddElementToListWithElements() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(1, "inserted");

        assertEquals(4, list.size);
        assertEquals("inserted", list.get(1));
        assertEquals("two", list.get(2));
    }

    @Test
    @DisplayName("Добавление элемента за пределы списка")
    void testAddElementOutOfBounds() {
        MyArrayList<Boolean> list = new MyArrayList<>();
        list.add(true);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, false);
        });
    }

    @Test
    @DisplayName("Добавление элемента в начало списка")
    public void testAddElementAtStart() {
        MyArrayList<Character> list = new MyArrayList<>();
        list.add('a');
        list.add('b');
        list.add(0, 'c');

        assertEquals(3, list.size);
        assertEquals('c', list.get(0));
        assertEquals('a', list.get(1));
    }

    @Test
    @DisplayName("Добавление элемента в середину списка")
    public void testAddElementAtMiddle() {
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(1, 1.5);

        assertEquals(4, list.size);
        assertEquals(1.0, list.get(0));
        assertEquals(1.5, list.get(1));
        assertEquals(2.0, list.get(2));
    }

    @Test
    @DisplayName("Получение элемента из пустого списка должно вызвать IndexOutOfBoundsException")
    void testGetElementFromEmptyList() {
        MyArrayList<Long> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    @DisplayName("Получение элемента из списка")
    public void testGetElementFromList() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("orange", list.get(2));
    }

    @Test
    @DisplayName("Получение элемента за пределами списка должно вызвать IndexOutOfBoundsException")
    void testGetElementOutOfBounds() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    @DisplayName("Удаление элемента из пустого списка должно вызвать IndexOutOfBoundsException")
    void testRemoveElementFromEmptyList() {
        MyArrayList<Character> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    @DisplayName("Удаление элемента из списка")
    public void testRemoveElementFromList() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("red");
        list.add("green");
        list.add("blue");

        list.remove(1);

        assertEquals(2, list.size);
        assertEquals("red", list.get(0));
        assertEquals("blue", list.get(1));
    }

    @Test
    @DisplayName("Удаление всех элементов")
    public void testClear() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("У");
        list.add("А");
        list.add("В");

        list.clear();

        assertEquals(0, list.size);
    }

    @Test
    @DisplayName("Сортировка методом sort")
    public void testSorted() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("У");
        list.add("А");
        list.add("В");

        list.sort();

        assertEquals("А", list.get(0));
        assertEquals("В", list.get(1));
        assertEquals("У", list.get(2));
    }

    @Test
    @DisplayName("Сортировка методом quickSort()")
    public void testQuickSorted() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("У");
        list.add("А");
        list.add("В");

        list.quicksort();

        assertEquals("А", list.get(0));
        assertEquals("В", list.get(1));
        assertEquals("У", list.get(2));
    }
}