package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;


public class Show extends AbstractCommand{
    public Show(CollectionManager collectionManager){
        super(collectionManager, "show", "print all elements of the collection in string representation");
    }

    @Override
    public void execute(String... args) {
        if (collectionManager.getCollection().size() == 0) System.out.println("Collection is empty");
        else {
            for (Product product : collectionManager.getCollection()) {
                System.out.println(product.asString());
            }
        }
    }
}
