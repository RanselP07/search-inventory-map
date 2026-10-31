package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class InventoryMap {

    static void main(String[] args) {
        HashMap<Integer, Product> products = InventoryMap.getInventory();

    }

    private static HashMap<Integer, Product> getInventory() {

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            String line = bufReader.readLine();

            while (line != null) {
                String[] characters = line.split("\\|");
                int id = Integer.parseInt(characters[0]);
                String product = characters[1];
                double price = Double.parseDouble(characters[2]);

                Product p = new Product(id, product, price);

                System.out.printf("id: %d - product: %s - Price: $%.2f%n", p.getId(), p.getProduct(), p.getPrice());

                line = bufReader.readLine();
            }

            bufReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
