package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;
import util.ProductComparator;
import java.util.LinkedList;

import static View.ProductCreator.setProduct;


public class AddIfMax extends AbstractCommand {

    public AddIfMax(CollectionManager collectionManager) {
        super(collectionManager, "add_if_max",
                "add a new element to the collection if its value is greater than the price of the largest " +
                        "element in this collection");
    }

    @Override
    public void execute(String... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        collection.sort(new ProductComparator());
        Product product = setProduct();
        if (collection.get(collection.size()-1).getPrice() < product.getPrice()){
            collection.add(product);
            collectionManager.setCollection(collection);
            System.out.println("Product was successfully added");
        }
        System.out.println("The product is not the greatest");
    }
}
