package ru.mirea.lab10;

public class MyArray<E> {

    private E [] arr;

    public E get(int index){
        return  arr[index] ;
    }

    public void setArr(E[] array){
        this.arr =  array;
    }

    public int getLength(){
        return  arr.length ;
    }
}
