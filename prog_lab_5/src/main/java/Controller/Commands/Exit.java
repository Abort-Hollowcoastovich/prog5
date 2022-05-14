package Controller.Commands;

import Controller.CollectionManager;


public class Exit extends AbstractCommand{
    public Exit(CollectionManager collectionManager){
        super(collectionManager, "exit", "terminate program (without saving to file)");
    }

    @Override
    public void execute(String... args) {
        System.exit(0);
    }
}
