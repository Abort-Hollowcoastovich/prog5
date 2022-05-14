package Controller;

import Model.Coordinates;
import Model.Organization;
import Model.Product;
import Model.UnitOfMeasure;
import util.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class FileManager {
    public static LinkedList<Product> readDataFile(String filePath, CollectionManager collectionManager){

        File file = new File(filePath);
        StringBuilder result = new StringBuilder();
        Parser parser = new Parser(collectionManager.getCollection().getClass(), Product.class);

        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                result.append(sc.nextLine());
            }
            sc.close();
            collectionManager.setInitializationTime(new Date());
            return parser.fromXML(result.toString(), new Class[] {Product.class, Coordinates.class,
                    Organization.class, UnitOfMeasure.class});

        }
        catch (FileNotFoundException e) {
            return null;
        }
    }
    public static void saveToFile(String filePath, LinkedList<Product> collection) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            Parser parser = new Parser(collection.getClass(), Product.class);
            bw.write(parser.toXml(collection, new Class[]{Product.class, Coordinates.class,
                    Organization.class, UnitOfMeasure.class}));
            bw.close();
        } catch (IOException e) {
            System.out.println("No such filepath");
        }
    }
    public static ArrayList<String> readScript(String filepath){
        try {
            ArrayList<String> result = new ArrayList<>();
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine().trim());
            }
            scanner.close();
            return result;

        }
        catch (FileNotFoundException e) {
            return null;
        }
    }
}
