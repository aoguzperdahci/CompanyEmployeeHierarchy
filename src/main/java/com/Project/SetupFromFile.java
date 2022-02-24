package com.Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SetupFromFile extends SetupDataTemplate {

    @Override
    protected String[][] readAll() {
        
        Scanner s = null;
        String[][] records = new String[256][4];
        int counter = 0;
        try {
            File file = new File("girdi.txt");
            s = new Scanner(file);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] line = data.split(",");
                records[counter++] = line;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
            System.exit(0);;
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
            System.exit(0);
        } finally {
            if (s != null) {
                s.close();
            }
        }

        return records;
    }
    
}
