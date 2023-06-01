package src;

import java.io.*;

public class RemoveLineFromFile {

    public void removeLineMethod(String removableString, String filename){
        // имя файла
        String fileName = filename;
        // строка, которую нужно удалить
        String lineToRemove = removableString;

        try {
            // создаем временный файл
            File tempFile = new File("temp.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            // читаем исходный файл
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // если текущая строка не равна удаляемой
                // записываем ее во временный файл
                if (!currentLine.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            // закрываем ридер и писатель
            reader.close();
            writer.close();

            // удаляем исходный файл
            File oldFile = new File(fileName);
            oldFile.delete();

            // переименовываем временный файл в исходное имя файла
            tempFile.renameTo(oldFile);

            System.out.println("Строка " + lineToRemove + " удалена из файла " + fileName);

        } catch (IOException ex) {
            System.out.println("Ошибка при удалении строки из файла " + fileName);
            ex.printStackTrace();
        }
    }

}