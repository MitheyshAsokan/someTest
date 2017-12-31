// ArrayListV1.java
public class ArrayListV1<E> extends ArrayList<E> {

    @Override
    protected void grow() {
        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
