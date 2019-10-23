public class ArrayQueue implements Queue {

    private Object[] array;
    private int front;
    private int rear;

    public ArrayQueue() {
        this(11);
    }

    public ArrayQueue(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        } else {
            array = new Object[length];
        }
    }

    @Override
    public boolean isEmpty() {
        return (rear == front);
    }

    @Override
    public Object getFrontElement() {
        if (!isEmpty()) {
            return array[front];
        } else {
            return null;
        }
    }

    @Override
    public Object getRearElement() {
        if (!isEmpty()) {
            return array[rear - 1];
        } else {
            return null;
        }
    }

    @Override
    public void put(Object payload) {
        if (array[rear] == null) {
            array[rear] = payload;
            rear += 1;
            rear = rear % array.length;
        }
        else{
            throw new IndexOutOfBoundsException("The queue is full!");
        }
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            array[front] = null;
            front += 1;
            front = front % array.length;
        }
    }
}
