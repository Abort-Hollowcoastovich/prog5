package Controller.Commands;

import Controller.CollectionManager;

public class Info extends AbstractCommand {
    public Info(CollectionManager collectionManager) {
        super(collectionManager, "info", "print information about the collection " +
                "(type, initialization date, number of elements)");
    }
    @Override
    public void execute(String ... args) {
        System.out.println("Collection is stored in " + collectionManager.getCollection().getClass());
        System.out.println("It was initialized on" + collectionManager.getInitalizationTime());
        System.out.println("it contains " + collectionManager.getCollection().size() + " products");
    }

}
