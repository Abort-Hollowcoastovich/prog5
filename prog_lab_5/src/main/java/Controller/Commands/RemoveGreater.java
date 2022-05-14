package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;

import java.util.LinkedList;

import static View.ProductCreator.setProduct;


public class RemoveGreater extends AbstractCommand{
    public RemoveGreater(CollectionManager collectionManager){
        super(collectionManager, "remove_greater", "remove from the collection all elements with" +
                " greater price than the given");
    }

    @Override
    public void execute(String... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        Product product = setProduct();
        try {
            if (collection.contains(product)) {
                collection.removeIf(product1 -> product1.getPrice() < product.getPrice());
                collectionManager.setCollection(collection);
                System.out.println("Products lower than the given were deleted");
            }
            else throw new SecurityException("No such element in collection");
        }
        catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

    }
}