package Controller.Commands;

import Controller.CollectionManager;
import Model.Organization;
import Model.Product;
import util.ManufacturerComparator;
import java.util.LinkedList;

import static View.ProductCreator.setManufacturer;

public class CountLessThanManufacturer extends AbstractCommand {
    public CountLessThanManufacturer(CollectionManager collectionManager) {
        super(collectionManager, "count_less_than_manufacturer", "display the number of elements whose " +
                "manufacturer annual turnover is less than the given one");
    }
    @Override
    public void execute(String ... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        collection.sort(new ManufacturerComparator());
        Organization manufacturer = setManufacturer();
        int count = 0;
        for (Product product :collection) {
            if (product.getManufacturer().getAnnualTurnover() < manufacturer.getAnnualTurnover()) {
                count ++;
            }
        }
        System.out.println(count);
    }

}