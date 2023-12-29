import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class thirdExercise {
    public static void main(String[] args) {
        Product product1 = new Product("Ice Cream", 89, 5);
        Product product2 = new Product("Milk", 112, 2);
        Product product3 = new Product("Cheese", 215, 1);
        Product product4 = new Product("Творог", 2399, 4);
        Product product5 = new Product("Energos", 10000, 1);

        Stack stack = new Stack(Product.countOfObject);

        stack.add(product2);
        stack.add(product4);
        stack.add(product4);
        stack.add(product4);
        stack.add(product4);
        stack.add(product4);
        stack.add(product5);
        stack.add(product5);

        System.out.println("Список проданных товаров: " + stack.getList());
        System.out.println("Общая сумма продаж: " + stack.getTotalPrice());
        System.out.println("Наиболее популярный товар: " + stack.getPopular());
    }

    public static class Product {
        private String name;
        private int cost;
        private int quantity;
        private int sold;
        private static int countOfObject;

        public Product(String name, int cost, int quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;

            countOfObject++;
        }

        public int getPrice() {
            return cost;
        }

        public void decreaseQuantity() {
            quantity--;
            sold++;
        }
    }

    public static class Stack {
        public LinkedList<Product>[] data;
        private int index = 0;
        private int cost = 0;
        private int arrayFullness;

        public Stack(int capacity) {
            data = new LinkedList[capacity];
        }

        public void add(Product product) {
            if (product.quantity == 0) {
                return;
            }

            for (int i = 0; i < data.length; i++) {
                if (data[i] != null && data[i].get(0) == product) {
                    product.decreaseQuantity();

                    cost += product.getPrice();
                    return;
                }
            }

            data[index] = new LinkedList<>();
            data[index].add(product);

            product.decreaseQuantity();

            cost += product.getPrice();

            index++;
            arrayFullness++;
        }

        public String getList() {
            String[] list = new String[arrayFullness];

            for (int i = 0; i < arrayFullness; i++) {
                list[i] = data[i].get(0).name;
            }

            return Arrays.toString(list);
        }

        public int getTotalPrice() {
            return cost;
        }

        public String getPopular() {
            String name = null;
            int sold = 0;

            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    break;
                }

                Product product = data[i].get(0);
                if (product.sold > sold) {
                    sold = product.sold;
                    name = product.name;
                }
            }

            return name;
        }

    }
}
