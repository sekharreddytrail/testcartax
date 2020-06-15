package Utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListFiles {

    File folder = new File("src/main/java/resource/Inputfiles");

    public List<String> readalllocalfiles() {
        return (List<String>) listAllFiles(folder);
    }

    public Object listAllFiles(File folder) {
        System.out.println("In listAllfiles(File) method");
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            // if directory call the same method again
            if (file.isDirectory()) {
                listAllFiles(file);
            } else {
                try {
                    return readContent(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        return "No files found";
    }

    // Uses Files.walk method
    public void listAllFiles(String path) {
        System.out.println("In listAllfiles(String path) method");
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        readContent(filePath);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<String> readContent(File file) throws IOException {
        System.out.println("read file " + file.getPath());
        List<String> fileList = Files.readAllLines(Paths.get(file.getPath()));

        return fileList;
    }

    public void readContent(Path filePath) throws IOException {
        System.out.println("read file " + filePath);
        List<String> fileList = Files.readAllLines(filePath);
        System.out.println("" + fileList + "<<<<<<<<");
    }


    public void writeoutputfile(ArrayList<String> str) throws IOException {
        FileOutputStream fos = new FileOutputStream("fileName1");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));


        bw.write(String.valueOf(str));
        bw.newLine();

        bw.close();


    }


}
