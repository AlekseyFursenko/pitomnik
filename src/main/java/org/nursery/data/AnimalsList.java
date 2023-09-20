package org.nursery.data;

import org.nursery.Model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalsList {
    private List<Animal> animals;

    public AnimalsList (){
        animals = new ArrayList<Animal>();
    }

    public boolean add(Animal animal){
        boolean flag = false;
        if (!animals.contains(animal)){
            animals.add(animal);
            flag = true;
        }
        return flag;
    }

    public Animal getAnimalInfo(int index){
        return contains(index) ? animals.get(index) : null;
    }

    public boolean editAnimal(Animal oldData, Animal animal){
        boolean flag = false;
        if (animals.contains(oldData)){
            animals.set(animals.indexOf(oldData),animal);
            flag = true;
        }
        return flag;
    }

    public boolean remove(Animal animal){
        boolean flag = false;
        if(animals.contains(animal)){
            animals.remove(animal);
            flag = true;
        }
        return flag;
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public int count(){
        return animals.size();
    }
    private boolean contains (int index){
        return animals != null && animals.size() > index;
    }
}
