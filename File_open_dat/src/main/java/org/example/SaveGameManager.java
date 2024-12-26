package org.example;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SaveGameManager {

    public static void openZip(String zipPath, String destDir) {
        try (FileInputStream fis = new FileInputStream(zipPath);
             ZipInputStream zis = new ZipInputStream(fis)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String filePath = destDir + File.separator + entry.getName();
                try (FileOutputStream fos = new FileOutputStream(filePath)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                    System.out.println("Файл распакован: " + filePath);
                } catch (IOException e) {
                    System.out.println("Ошибка при распаковке файла: " + e.getMessage());
                }
                zis.closeEntry();
            }
            System.out.println("Архив успешно распакован: " + zipPath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении архива: " + e.getMessage());
        }
    }

    public static GameProgress openProgress(String filePath) {
        GameProgress progress = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            progress = (GameProgress) ois.readObject();
            System.out.println("Файл успешно десериализован: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации файла: " + e.getMessage());
        }
        return progress;
    }
}