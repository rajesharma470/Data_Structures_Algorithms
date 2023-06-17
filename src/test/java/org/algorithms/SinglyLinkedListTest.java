package org.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTest {
    private SinglyLinkedList<String> arrayList;

    @BeforeEach
    private void setUp(){
        arrayList = new SinglyLinkedList<>();
    }

    //write tests here
    @Test
    void testAddToFrontNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayList.addToFront(null);
        });
    }

    @Test
    void testAddToFront() {
        arrayList.addToFront("1");
        arrayList.addToFront("2");
        arrayList.addToFront("3");
        arrayList.addToFront("4");
        arrayList.addToFront("5");
        arrayList.addToFront("6");
        arrayList.addToFront("7");
        arrayList.addToFront("8");
        arrayList.addToFront("9");
        arrayList.addToFront("0");
        assertEquals(arrayList.size(), 10);
        assertEquals(arrayList.getHead().getData(), "0");
        assertEquals(arrayList.getTail().getData(), "1");
    }

    @Test
    void testAddToBackNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayList.addToBack(null);
        });
    }

    @Test
    void testAddToBack() {
        arrayList.addToBack("1");
        arrayList.addToBack("2");
        arrayList.addToBack("3");
        arrayList.addToBack("4");
        arrayList.addToBack("5");
        arrayList.addToBack("6");
        arrayList.addToBack("7");
        arrayList.addToBack("8");
        arrayList.addToBack("9");
        arrayList.addToBack("0");
        assertEquals(arrayList.size(), 10);
        assertEquals(arrayList.getHead().getData(), "1");
        assertEquals(arrayList.getTail().getData(), "0");
    }

    @Test
    void testRemoveFromFrontNull() {
        assertThrows(NoSuchElementException.class, () -> {
            arrayList.removeFromFront();
        });
    }

    @Test
    void testRemoveFromFront() {
        arrayList.addToFront("1");
        arrayList.addToFront("2");
        arrayList.addToFront("3");
        arrayList.addToFront("4");
        arrayList.addToFront("5");
        arrayList.addToFront("6");
        arrayList.addToFront("7");
        arrayList.addToFront("8");
        arrayList.addToFront("9");
        arrayList.addToFront("0");
        assertEquals(arrayList.removeFromFront(), "0");
        assertEquals(arrayList.removeFromFront(), "9");
        assertEquals(arrayList.removeFromFront(), "8");
        assertEquals(arrayList.removeFromFront(), "7");
        assertEquals(arrayList.removeFromFront(), "6");
        assertEquals(arrayList.removeFromFront(), "5");
        assertEquals(arrayList.removeFromFront(), "4");
        assertEquals(arrayList.removeFromFront(), "3");
        assertEquals(arrayList.removeFromFront(), "2");
        assertEquals(arrayList.removeFromFront(), "1");
        assertEquals(arrayList.size(), 0);
    }

    @Test
    void testRemoveFromBackNull() {
        assertThrows(NoSuchElementException.class, () -> {
            arrayList.removeFromBack();
        });
    }

    @Test
    void testRemoveFromBack() {
        arrayList.addToFront("1");
        arrayList.addToFront("2");
        arrayList.addToFront("3");
        arrayList.addToFront("4");
        arrayList.addToFront("5");
        arrayList.addToFront("6");
        arrayList.addToFront("7");
        arrayList.addToFront("8");
        arrayList.addToFront("9");
        arrayList.addToFront("0");
        assertEquals(arrayList.removeFromBack(), "1");
        assertEquals(arrayList.removeFromBack(), "2");
        assertEquals(arrayList.removeFromBack(), "3");
        assertEquals(arrayList.removeFromBack(), "4");
        assertEquals(arrayList.removeFromBack(), "5");
        assertEquals(arrayList.removeFromBack(), "6");
        assertEquals(arrayList.removeFromBack(), "7");
        assertEquals(arrayList.removeFromBack(), "8");
        assertEquals(arrayList.removeFromBack(), "9");
        assertEquals(arrayList.removeFromBack(), "0");
        assertEquals(arrayList.size(), 0);
    }

}
