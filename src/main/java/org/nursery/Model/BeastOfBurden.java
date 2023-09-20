package org.nursery.Model;

public abstract class BeastOfBurden extends Animal {

    int animalClassId;
    String animalTypeRus = "Вьючное животное";
    public BeastOfBurden(Long id, String birthdate, String name) {
        super(id,birthdate,name);
        animalClassId =1;
    }

//    public BeastOfBurden(Long id, int animalClassId, Date birthdate, String name) {
//        super(id, birthdate, name);
//        animalClassId = 1;
//    }

}
