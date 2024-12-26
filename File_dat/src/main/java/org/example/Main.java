package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameProgress progress1 = new GameProgress(100, 3, 10, 250.5);
        GameProgress progress2 = new GameProgress(85, 5, 15, 500.75);
        GameProgress progress3 = new GameProgress(50, 1, 5, 100.0);

        String savePath1 = "D:/Game/Work_Java/save1.dat";
        String savePath2 = "D:/Game/Work_Java/save2.dat";
        String savePath3 = "D:/Game/Work_Java/save3.dat";

        SaveGameManager.saveGame(savePath1, progress1);
        SaveGameManager.saveGame(savePath2, progress2);
        SaveGameManager.saveGame(savePath3, progress3);

        String zipPath = "D:/Game/Work_Java/saves.zip";

        List<String> filesToZip = new ArrayList<>();
        filesToZip.add(savePath1);
        filesToZip.add(savePath2);
        filesToZip.add(savePath3);

        SaveGameManager.zipFiles(zipPath, filesToZip);

        SaveGameManager.deleteFiles(filesToZip);
    }
}