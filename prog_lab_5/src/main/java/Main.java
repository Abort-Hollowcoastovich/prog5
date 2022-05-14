import Controller.CollectionManager;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Controller.FileManager.readDataFile;
import static View.CommandManager.commandManager;
import static View.CommandQualifier.setMap;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        Scanner scanner = new Scanner(System.in);
        if (args.length == 1) collectionManager.setCollection(readDataFile(args[0], collectionManager));
        if (args.length > 1) System.exit(1);
        setMap(collectionManager);
        while (true) {
            try {
                String line = scanner.nextLine();
                commandManager(line.trim());
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }
    }
}