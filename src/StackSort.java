import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StackSort<E> {
   public Stack<E> sort(Stack<E> stack) {
      Stack<E> sortedStack = new Stack<E>();
      ArrayList<E> elements = new ArrayList<E>();
      
      while (!stack.isEmpty()) {
         elements.add(stack.pop());
      }
      Collections.sort(elements, Collections.reverseOrder());

      for (E e : elements) {
         sortedStack.push(e);
      }
      return sortedStack;
   }
   
   public static void main(String[] args) {
	   StackSort<Integer> ss = new StackSort<Integer>();
	   Stack<Integer> stack = new Stack<Integer>();
	   stack.push(3);
	   stack.push(1);
	   stack.push(7);
	   stack.push(4);
	   stack.push(10);
	   stack = ss.sort(stack);
	   System.out.println(ss.sort(stack));
	   
   }
}
