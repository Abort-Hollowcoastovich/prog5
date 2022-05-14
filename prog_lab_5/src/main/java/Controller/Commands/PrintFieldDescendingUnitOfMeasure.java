package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;
import util.ProductComparator;

import java.util.LinkedList;

public class PrintFieldDescendingUnitOfMeasure extends AbstractCommand{
    public PrintFieldDescendingUnitOfMeasure(CollectionManager collectionManager) {
        super(collectionManager, "print_field_descending_unit_of_measure", "display unit of measure " +
                "of all elements in descending order");
    }
    @Override
    public void execute(String... args){
        LinkedList<Product> collection = collectionManager.getCollection();
        collection.sort(new ProductComparator());
        for (Product product: collection) {
            System.out.println(product.getUnitOfMeasure());
        }
    }
}
