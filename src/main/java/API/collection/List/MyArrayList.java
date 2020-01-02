package API.collection.List;

import java.util.*;

public class MyArrayList<AnyType>  {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        MyArrayList myArrayList = new MyArrayList();

    }

    private static final int DEFAULT_CAPACITY = 10; // 数组默认大小
    private int size;
    private Object[] items;

    public MyArrayList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int size) {
        if (size > 0) {
            items = new Object[size];
        } else if (size == 0) {
            items = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("CAPACITY IS WRONG WITH:" + size);
        }
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<AnyType> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public void add(AnyType anyType) {
        // 判断数组长度
        if(size >= items.length){ // 扩容
            Object[]expandedArray = new Object[items.length*2];
            for (int i = 0; i < items.length; i++) {
                expandedArray[i] = items[i];
            }
        }
        items[size] = anyType;
        size++;
    }

    public String toString(){
        if(items.length == 0){
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        str.append(items[0]);
        for (int i = 1; i < size; i++) {
            str.append(" , ");
            str.append(items[i].toString());
        }
        str.append("]");
        return str.toString();
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends AnyType> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends AnyType> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public AnyType get(int index) {
        return null;
    }

    public AnyType set(int index, AnyType element) {
        return null;
    }

    public void add(int index, AnyType element) {

    }

    public AnyType remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<AnyType> listIterator() {
        return null;
    }

    public ListIterator<AnyType> listIterator(int index) {
        return null;
    }

    public List<AnyType> subList(int fromIndex, int toIndex) {
        return null;
    }
}
