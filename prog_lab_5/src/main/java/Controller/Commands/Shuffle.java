package Controller.Commands;

import Controller.CollectionManager;
import Model.Product;

import java.util.Collections;
import java.util.LinkedList;


public class Shuffle extends AbstractCommand{
    public Shuffle(CollectionManager collectionManager){
        super(collectionManager, "shuffle", "shuffle the elements of the collection randomly");
    }

    @Override
    public void execute(String... args) {
        LinkedList<Product> collection = collectionManager.getCollection();
        Collections.shuffle(collection);
        collectionManager.setCollection(collection);
        System.out.println("Collection has been successfully shuffled");
    }
}