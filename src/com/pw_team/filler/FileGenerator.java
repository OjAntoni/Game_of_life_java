package com.pw_team.filler;

import com.pw_team.files.FileSaver;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    public static void generate(String path, int density, int size, int width, int height, int sleepms){
        Random r = new Random();
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(new File(path)));) {
            bf.write(size+"\n");
            bf.write(width+"\n");
            bf.write(height+"\n");
            bf.write(sleepms+"\n");
            for(int x = 0; x < width; x++){
                for (int y = 0; y < height; y++){
                    int status = r.nextInt()%density == 0 ? 1 : 0;
                    bf.write(status+"\n");
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error occured during creating file",
                    "File error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
