package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveById extends AbstractCommand{
    public RemoveById(CollectionManager collectionManager) {
        super(collectionManager, "remove_by_id", "remove element from collection by its id");
    }

    @Override
    public void execute(String... args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int id = Integer.parseInt(args[0]);
            LinkedList<Product> collection = collectionManager.getCollection();
            collection.removeIf((Product product) -> product.getId() == id);
            if (collection.equals(collectionManager.getCollection())) throw new SecurityException("No such element in collection");
            collectionManager.setCollection(collection);
            System.out.println("Product was successfully removed");
        } catch (NumberFormatException e) {
            System.out.println("Enter an integer");
            int id = Integer.parseInt(scanner.nextLine().trim());
            LinkedList<Product> collection = collectionManager.getCollection();
            collection.removeIf((Product product) -> product.getId() == id);
            collectionManager.setCollection(collection);
            System.out.println("Product was successfully removed");
        } catch (SecurityException e) {System.out.println(e.getMessage());}
    }
}