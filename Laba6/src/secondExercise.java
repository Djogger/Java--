import java.util.Arrays;

public class secondExercise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.view());

        System.out.println("Удалён: " + stack.pop());
        System.out.println(stack.view());

        System.out.println("Верхний элемент: " + stack.peek());

        stack.push(4);
        System.out.println(stack.view());

        System.out.println("Удалён: " + stack.pop());
        System.out.println(stack.view());
    }

    public static class Stack<T> {
        private T[] data;
        private int index = 0;

        public Stack(int capacity) {
            data = (T[]) new Object[capacity];
        }

        public void push(T element) {
            data[index] = element;
            index++;
        }

        public T pop() {
            index--;

            T value = data[index];
            data[index] = null;

            return value;
        }

        public T peek() {
            return data[index - 1];
        }

        public String view() {
            return Arrays.toString(data);
        }
    }
}