import java.io.*;

public class Program {
    public static void main(String[] args) {
        String path = "src/errorList.txt";

        try {
            age(0, path);
            age(120, path);
            //age(-1, path);
            //age(125, path);
        } catch (CustomAgeException e) {
            System.out.println("Значение не удовлетворяет условию.");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла.");
        }
    }

    public static void age(int ageOfPerson, String path) throws CustomAgeException, IOException {
        if (ageOfPerson < 0) {
            throw new CustomAgeException(ageOfPerson, path);
        } else if (ageOfPerson > 120) {
            throw new CustomAgeException(ageOfPerson, path);
        }
        System.out.println(ageOfPerson);
    }
}

class CustomAgeException extends Exception {
    CustomAgeException(int age, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

        if (age < 0) {
            System.out.println(age + " < " + 0);
            writer.write(age + " < " + 0);
        } else if (age > 120) {
            System.out.println(age + " > " + 0);
            writer.write(age + " > " + 0);
        }

        writer.newLine();
        writer.close();
    }
}