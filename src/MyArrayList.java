import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings("ManualArrayCopy")

public class MyArrayList<T> implements List<String> {

    private String[] myArray;

    /*############################################
            Zu implementierende Methoden
    ############################################*/

    MyArrayList() {
        myArray = new String[0];
    }

    //### GET AND SET
    @Override
    public String get(int index) {
        return myArray[index];
    }

    @Override
    public String set(int index, String element) {
        String oldElement = myArray[index];
        myArray[index] = element;
        return oldElement;
    }

    //### SIZE
    @Override
    public int size() {
        return myArray.length;
    }

    //### ISEMPTY
    @Override
    public boolean isEmpty() {
        return myArray.length == 0;
    }

    //### CONTAINS
    @Override
    public boolean contains(Object o) {
        for (Object s : myArray) {
            if (s.equals(o)) return true;
        }
        return false;
    }

    //### ADD
    @Override
    public boolean add(String s) {
        String[] nextArray = new String[myArray.length+1];
        for(int i = 0; i < myArray.length; i++) {
            nextArray[i] = myArray[i];
        }
        nextArray[nextArray.length-1] = s;
        myArray = nextArray;
        return true;
    }

    @Override
    public void add(int index, String element) {
        String[] nextArray = new String[myArray.length+1];
        for (int i = 0; i < index; i++) {
            nextArray[i] = myArray[i];
        }
        nextArray[index] = element;
        for(int i = index; i < myArray.length; i++) {
            nextArray[i+1] = myArray[i];
        }
        myArray = nextArray;
    }

    //### REMOVE AND CLEAR
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public String remove(int index) {
        String removedString = myArray[index];
        String[] nextArray = new String[myArray.length-1];
        for(int i = 0; i < index; i++) {
            nextArray[i] = myArray[i];
        }
        for(int i = index+1; i < myArray.length; i++) {
            nextArray[i-1] = myArray[i];
        }
        myArray = nextArray;
        return removedString;
    }

    @Override
    public void clear() {
        myArray = new String[0];
    }

    //### INDEX FUNCTIONS
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < myArray.length; i++) {
            if(myArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for(int i = 0; i < myArray.length; i++) {
            if(myArray[i].equals(o)) {
                result = i;
            }
        }
        return result;
    }

    /*############################################
            Ab hier sind die Methoden egal
    ############################################*/

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("TypeParameterHidesVisibleType")
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}
