package com.pw_team.files;

import java.io.File;

/**
 * Klasa z jedną statyczną metodą, służąca do
 * sprawdzania czy ścieżka nadaję się do tworzenia
 * odpowiednich klas obiektów związanych z niej.
 * Na podstawie tej klasy pracuje GUI
 */
public class FileChecker {
    public static void checkForCurrency(String path) throws Exception{
        File file = new File(path);
        if(file.isDirectory()) throw new Exception("Path "+path+" leads to directory!");
        if(!file.exists()) throw new Exception("File doesn't exist's!");
    }
}
