package org.nursery.Model;

public abstract class Pet extends Animal {

    int animalClassId;
    String animalTypeRus = "Домашнее животное";
    public Pet(Long id, String birthdate, String name) {
        super(id,birthdate,name);
        animalClassId =2;
    }

//    public BeastOfBurden(Long id, int animalClassId, Date birthdate, String name) {
//        super(id, birthdate, name);
//        animalClassId = 1;
//    }

}
