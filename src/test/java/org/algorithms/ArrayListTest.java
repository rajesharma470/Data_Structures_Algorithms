package org.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {

    private ArrayList<String> arrayList;

    @BeforeEach
    private void setUp(){
        arrayList = new ArrayList<>();
    }

    @Test
    void testAddToFrontNull() {
       assertThrows(IllegalArgumentException.class, () -> {
            arrayList.addToFront(null);
        });
    }

    @ParameterizedTest
    @CsvSource({"1,1", "1:2,2:1", "1:2:3,3:2:1", "1:2:3:4:5:6:7:8:9:0,0:9:8:7:6:5:4:3:2:1"})
    void testAddToFront(String input, String expOutput) {
        for(String v: input.split(":")) {
            arrayList.addToFront(v);
        }
        String[] out = expOutput.split(":");
        assertEquals(arrayList.size(), out.length);
        for(int i=0;i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], out[i]);
        }
        for(int i=arrayList.size();i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], null);
        }
    }

    @Test
    void testAddToBackNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            arrayList.addToBack(null);
        });
    }

    // add more tests her

    @ParameterizedTest
    @CsvSource({"1,1", "1:2,1:2", "1:2:3,1:2:3", "1:2:3:4:5:6:7:8:9:0,1:2:3:4:5:6:7:8:9:0"})
    void testAddToBack(String input, String expOutput) {
        for(String v: input.split(":")) {
            arrayList.addToBack(v);
        }
        String[] out = expOutput.split(":");
        assertEquals(arrayList.size(), out.length);
        for(int i=0;i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], out[i]);
        }
        for(int i=arrayList.size();i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], null);
        }
    }

    @Test
    void testRemoveFromFront() {
        assertThrows(NoSuchElementException.class, () -> {
            arrayList.removeFromFront();
        });
    }

    @ParameterizedTest
    @CsvSource({"1,1:0", "1:2,1:1"})
    void testRemoveFromFront(String input, String expOutput) {
        for(String v: input.split(":")) {
            arrayList.addToBack(v);
        }
        String res = arrayList.removeFromFront();
        String[] out = expOutput.split(":");
        assertEquals(res, out[0]);
        for(int i=arrayList.size();i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], null);
        }
    }

    @Test
    void testRemoveFromBack() {
        assertThrows(NoSuchElementException.class, () -> {
            arrayList.removeFromBack();
        });
    }

    @ParameterizedTest
    @CsvSource({"1,1:0", "1:2,2:1"})
    void testRemoveFromBack(String input, String expOutput) {
        for(String v: input.split(":")) {
            arrayList.addToBack(v);
        }
        String res = arrayList.removeFromBack();
        String[] out = expOutput.split(":");
        assertEquals(res, out[0]);
        for(int i=arrayList.size();i<arrayList.size();i++){
            assertEquals(((Object[])arrayList.getBackingArray())[i], null);
        }
    }
}
