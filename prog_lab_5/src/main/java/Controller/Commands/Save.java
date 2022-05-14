package Controller.Commands;

import Controller.CollectionManager;

import static Controller.FileManager.saveToFile;


public class Save extends AbstractCommand{
    public Save(CollectionManager collectionManager){
        super(collectionManager, "save",
                "save collection to file");
    }

    @Override
    public void execute(String... args) {
        saveToFile("C:/Users/AboHolo/IdeaProjects/prog_lab_5/data.xml", collectionManager.getCollection());
        System.out.println("Collection has been successfully saved");
    }
}
