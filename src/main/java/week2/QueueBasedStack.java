package week2;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {

        q1 = new Queue<>();
        q2 = new Queue<>();

    }

    public void push(Data data) {

        q2.enqueue(data);

        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }

        Queue<Data> temp = q1;
        q1=q2;
        q2=temp;
    }

    public Data pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return q1.dequeue();
    }

    public Data peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return q1.peek();
    }

    public int size() {return q1.size();}

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
