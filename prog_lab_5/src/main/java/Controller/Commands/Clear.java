package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;

import java.util.LinkedList;

public class Clear extends AbstractCommand{
    public Clear(CollectionManager collectionManager) {
        super(collectionManager, "clear", "clear the collection");
    }

    @Override
    public void execute(String... args) {
        collectionManager.setCollection(new LinkedList<Product>());
        System.out.println("Collection was cleared");
    }
}
