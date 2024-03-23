package com.techfios.fileprocessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryReader {

    // Method to check if the file exists at the given path
    public static boolean doesFileExist(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            fileReader.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Method to read and print words and their meanings
    public static void readDictionary(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - ");
                System.out.println(parts[0]); // Word
                String[] meanings = parts[1].split(", ");
                for (String meaning : meanings) {
                    System.out.println("  " + meaning); // Meaning
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt"; // Replace with your file path
        boolean fileExists = doesFileExist(filePath);
        if (fileExists) {
            System.out.println("File exists at the specified path.");
            readDictionary(filePath);
        } else {
            System.out.println("File does not exist at the specified path.");
        }
    }
}
