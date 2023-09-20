package org.nursery.Model;

import org.nursery.data.AnimalsList;

import java.io.*;
import java.util.ArrayList;

public class Model {
    AnimalsList currentList;
    private int currentIndex;
    final protected String pathToModel = "org.nursery.Model.";

    public Model(){
        currentList = new AnimalsList();
        currentIndex = 0;
    }

    public Animal currentAnimal(){
        if(currentIndex >= 0){
            return currentList.getAnimalInfo(currentIndex);
        } else {
            return null;
        }
    }

    public String getPathToModel() {
        return pathToModel;
    }
    public AnimalsList currentList(){
        return this.currentList;
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }
    public void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
    }

    public void saveToFile(){
        try{
            FileOutputStream writeData = new FileOutputStream("animal.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(currentList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        try{
            FileInputStream readData = new FileInputStream("animal.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList newList  = (ArrayList<Animal>) readStream.readObject();
//            currentList.
//            readStream.close();

            System.out.println(newList.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
