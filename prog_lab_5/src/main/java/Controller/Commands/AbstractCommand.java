package Controller.Commands;

import Controller.CollectionManager;

public abstract class AbstractCommand {
    protected CollectionManager collectionManager;
    private String name;
    private String description;
    public AbstractCommand(CollectionManager collectionManager, String name, String description) {
        this.collectionManager = collectionManager;
        this.name = name;
        this.description = description;
    }
    public abstract void execute(String ... args);

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
