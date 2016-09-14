import java.util.Stack;

public class MyQueue<E> {
    Stack<E> stack1 = new Stack<E>();
    Stack<E> stack2 = new Stack<E>();            

    public void enqueue(E e) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(e);

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return;
    }

    public E dequeue() {
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        MyQueue<String> mq = new MyQueue<String>();
        mq.enqueue("1");
        mq.enqueue("2");
        mq.enqueue("3");
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}
