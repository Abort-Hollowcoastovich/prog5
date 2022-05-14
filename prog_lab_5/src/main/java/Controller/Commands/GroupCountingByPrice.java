package Controller.Commands;

import Controller.CollectionManager;
import util.ProductComparator;
import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GroupCountingByPrice extends AbstractCommand{
    public GroupCountingByPrice(CollectionManager collectionManager) {
        super(collectionManager, "group_counting_by_price", "group the elements of the collection by" +
                " price, display the number of elements in each group");
    }
    @Override
    public void execute(String... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        collection.sort(new ProductComparator());
        ArrayList<ArrayList<Product>> list = new ArrayList<>();
        Double price;
        HashMap<Double, Integer> groupes = new HashMap<>();
        for (Product product: collection) {
            price = product.getPrice();
            if (groupes.containsKey(price)) {
                groupes.put(price, groupes.get(price) + 1);
            } else {
                groupes.put(price, 1);
            }
        }
        for (Double key: groupes.keySet()) {
            System.out.println("There are " +  groupes.get(key) + " products that costs" + key);
        }
    }
}
