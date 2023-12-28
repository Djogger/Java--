import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "src/firstFile.txt";
        String destinationFilePath = "src/secondFile.txt";


        try {
            FileInputStream inputFile = new FileInputStream(sourceFilePath);
            FileOutputStream outputFile = new FileOutputStream(destinationFilePath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = inputFile.read(buffer)) != -1) {
                outputFile.write(buffer, 0, bytesRead);
            }

            String endComment = "\nСкопированный текст :3";
            byte[] endCommentBytes = endComment.getBytes();
            outputFile.write(endCommentBytes, 0, endCommentBytes.length);

            System.out.println("Данные файла успешно скопированы.");

            inputFile.close();
            outputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Неправильные пути к файлу.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла.");
        }
    }
}
