package org.example;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File createDirectory(String path, StringBuilder log) {
        File dir = new File(path);
        if (dir.mkdir()) {
            log.append("Директория создана: ").append(path).append("\n");
        } else {
            log.append("Не удалось создать директорию: ").append(path).append("\n");
        }
        return dir;
    }

    public static File createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл создан: ").append(path).append("\n");
            } else {
                log.append("Не удалось создать файл: ").append(path).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла: ").append(path).append(" - ").append(e.getMessage()).append("\n");
        }
        return file;
    }
}