package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {

    public static void main(String[] args) {
        // Путь к папке Games
        String gamesPath = "D:\\Game\\Work_Java";
        StringBuilder log = new StringBuilder();

        // Создание основных директорий
        File srcDir = FileUtils.createDirectory(gamesPath + "/src", log);
        File resDir = FileUtils.createDirectory(gamesPath + "/res", log);
        File saveGamesDir = FileUtils.createDirectory(gamesPath + "/savegames", log);
        File tempDir = FileUtils.createDirectory(gamesPath + "/temp", log);

        // Создание поддиректорий в src
        File mainDir = FileUtils.createDirectory(srcDir.getPath() + "/main", log);
        File testDir = FileUtils.createDirectory(srcDir.getPath() + "/test", log);

        // Создание файлов в main
        File mainJavaFile = FileUtils.createFile(mainDir.getPath() + "/Main.java", log);
        File utilsJavaFile = FileUtils.createFile(mainDir.getPath() + "/Utils.java", log);

        // Создание поддиректорий в res
        File drawablesDir = FileUtils.createDirectory(resDir.getPath() + "/drawables", log);
        File vectorsDir = FileUtils.createDirectory(resDir.getPath() + "/vectors", log);
        File iconsDir = FileUtils.createDirectory(resDir.getPath() + "/icons", log);

        // Создание файла temp.txt
        File tempFile = FileUtils.createFile(tempDir.getPath() + "/temp.txt", log);

        // Запись лога в файл temp.txt
        if (tempFile != null) {
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(log.toString());
                System.out.println("Лог успешно записан в temp.txt");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл temp.txt: " + e.getMessage());
            }
        }
    }
}