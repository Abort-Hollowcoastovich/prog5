package Controller;


import Model.*;

import java.util.*;

public class CollectionManager {
    private LinkedList<Product> collection = new LinkedList<>();
    private Date initializationTime = new Date();

    public void setCollection(LinkedList<Product> collection) {
        this.collection = collection;
    }

    public Date getInitalizationTime() {
        return initializationTime;
    }

    public LinkedList<Product> getCollection(){
        return collection;
    }

    public void setInitializationTime(Date initializationTime) {
        this.initializationTime = initializationTime;
    }

}
