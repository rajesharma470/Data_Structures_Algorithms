package org.algorithms;

import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Error: data is null");
        if(size == backingArray.length){
            resize();
        }
        T prevVal = backingArray[0];
        backingArray[0] = data;
        for(int i=1;i<backingArray.length;i++) {
            T tempVal = backingArray[i];
            backingArray[i] = prevVal;
            prevVal = tempVal;
        }
        size++;
    }

    private void resize(){
        int newSize = 2 * size;
        T[] oldBackingArray  = backingArray;
        backingArray = (T[]) new Object[newSize];
        for(int i=0;i<oldBackingArray.length;i++){
            backingArray[i]=oldBackingArray[i];
        }
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Error: data is null");
        if(size == backingArray.length){
            resize();
        }
        backingArray[size++] = data;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0) throw new NoSuchElementException("Error: list is empty");
        T frontVal = backingArray[0];
        for(int i=0;i< backingArray.length-1;i++) {
            backingArray[i]=backingArray[i+1];
        }
        backingArray[size-1]=null;
        size--;
        return frontVal;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0) throw new NoSuchElementException("Error: list is empty");
        T backVal = backingArray[size-1];
        backingArray[size-1]= null;
        size--;
        return backVal;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}