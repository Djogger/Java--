public class ArrayAverage {
    public static void main(String[] args) {
        try {
            // Ошибка NumberFormatException:
            //int[] arr = {1, 2, Integer.parseInt("s"), 4, 5};

            int[] arr = {1, 2, 3, 4, 5};

            int sum = 0;

            int steps = 0;

            /* Ошибка ArrayIndexOutOfBoundsException:
            for (int i = 0; i <= arr.length; i++) {
                sum += arr[i];
                steps += 1;
            }*/

            for (int element : arr) {
                sum += element;
                steps += 1;
            }

            System.out.println((double) sum / (double) steps);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вышел за массив.");
        } catch (NumberFormatException e) {
            System.out.println("Элемент не может быть преобразован в число.");
        }
    }
}
