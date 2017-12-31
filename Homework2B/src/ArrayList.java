// This class uses inheritance (Chapter 9, not covered in class). The easiest way
// to understand this code is to imagine that its contents are copied to both
// ArrayListV1<E> and ArrayListV2<E>, with the grow() methods being the only difference.
//
// ArrayList.java
public abstract class ArrayList<E> {
    protected int size;
    protected E[] data;

    public ArrayList() {
        reset();
    }

    public void reset() {
        // This cast operation is necessary because of the way Java
        // handles generics. It's ugly, which is why we made an
        // ArrayListOfDouble in class instead...
        data = (E[]) new Object[1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        checkIndex(i);
        return data[i];
    }

    public void set(int i, E element) {
        checkIndex(i);
        data[i] = element;
    }

    public void add(E element) {
        if (size >= data.length) {
            grow();
        }
        data[size] = element;
        size++;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    protected abstract void grow();
}
