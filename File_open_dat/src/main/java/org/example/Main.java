package org.example;

public class Main {
    public static void main(String[] args) {
        // Путь к архиву и папке для распаковки
        String zipPath = "D:/Game/Work_Java/saves.zip";
        String destDir = "D:/Game/Work_Java";

        // Распаковываем архив
        SaveGameManager.openZip(zipPath, destDir);

        // Путь к одному из распакованных файлов
        String saveFilePath = "D:/Game/Work_Java/save2.dat";

        // Десериализуем объект GameProgress
        GameProgress progress = SaveGameManager.openProgress(saveFilePath);

        // Выводим состояние сохраненной игры
        if (progress != null) {
            System.out.println("Состояние сохраненной игры: " + progress);
        }
    }
}