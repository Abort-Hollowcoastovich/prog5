package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;
import View.ProductCreator;

import java.util.LinkedList;


public class Add extends AbstractCommand{
    public Add(CollectionManager collectionManager){
        super(collectionManager, "add", "add a new element to the collection");
    }
    @Override
    public void execute(String... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        Product product = ProductCreator.setProduct();
        try {
            if (checkUniqueId(product)) {
                throw new SecurityException("Product id must be unique");
            }
            collection.add(product);
            collectionManager.setCollection(collection);
            System.out.println("Product was successfully added");
        }
        catch (SecurityException e){
            System.out.println(e.getMessage());
        }
    }
    private boolean checkUniqueId(Product product){
        LinkedList<Product> collection = collectionManager.getCollection();
        for (Product product1: collection){
            if (product1.getId() == (product.getId()))
                return true;
        }
        return false;
    }
}