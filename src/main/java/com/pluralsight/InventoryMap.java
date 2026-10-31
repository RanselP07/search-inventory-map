package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InventoryMap {

    static void main(String[] args) {

        HashMap<Integer, String> productHashMap = new HashMap<>();

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            String line = bufReader.readLine();

            while (line != null){
                String productInfo = line;
                String[] character = line.split("\\|");
                int id = Integer.parseInt(character[0]);

                productHashMap.put(id, productInfo);


                line = bufReader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String productInfo : productHashMap.values()){
            System.out.println(productInfo);
        }
    }
}
