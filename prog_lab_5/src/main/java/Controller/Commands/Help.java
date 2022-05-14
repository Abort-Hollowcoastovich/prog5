package Controller.Commands;

import Controller.CollectionManager;
import View.CommandQualifier;

public class Help extends AbstractCommand {
    public Help(CollectionManager collectionManager) {
        super(collectionManager, "help", "display help on available commands");
    }
    @Override
    public void execute(String ... args) {
        for (AbstractCommand value : CommandQualifier.map.values()) {
            System.out.println(value.getName() + ": " + value.getDescription());
        }
    }

}