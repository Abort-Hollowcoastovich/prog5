package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import static View.ProductCreator.*;


public class UpdateId extends AbstractCommand{
    public UpdateId(CollectionManager collectionManager){
        super(collectionManager, "update_id", "update the value of the collection element " +
                "whose id is equal to the given one");
    }

    @Override
    public void execute(String... args) {
        System.out.println("Enter product`s id");
        Scanner scanner = new Scanner(System.in);
        LinkedList<Product> collection = collectionManager.getCollection();
        int id = scanner.nextInt();
        Product product = getById(id);
        product.setName(setName());
        product.setCoordinates(setCoordinates());
        product.setCreationDate(new Date());
        product.setPrice(setPrice());
        product.setPartNumber(setPartNumber());
        product.setManufactureCost(setManufactureCost());
        product.setUnitOfMeasure(setUnitOfMeasure());
        product.setManufacturer(setManufacturer());
        collection.set(collection.indexOf(getById(id)), product);
        collectionManager.setCollection(collection);
        System.out.println("Collection has been successfully updated");

    }

    public Product getById(int id){
        for (Product product: collectionManager.getCollection()){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }
}