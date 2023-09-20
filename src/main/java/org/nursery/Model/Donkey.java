package org.nursery.Model;

import java.util.ArrayList;

public class Donkey extends BeastOfBurden{
    int specieId;
    String animalClassNameRus = "Осёл";

    public Donkey(Long id,String birthdate, String name) {

        super(id,
              birthdate,
              name);
        this.specieId = 1;
        this.command = new ArrayList<String>();
    }

    @Override
    public void getInfo(){
        System.out.println("Инвентарный номер: " + this.id +
                            ";\nТип животного: " + this.animalTypeRus +
                            ";\nКласс животного: " + this.animalClassNameRus +
                            ";\nИмя: " + this.name +
                            ";\nДата рождения:" + dateFormat(this.birthdate) +
                            ";\nКоманды: " + commandList(command));
    };

//    @Override
//    public void addAnimal(Long id) {
//
//    }
//
//    @Override
//    public void deleteAnimal(Animal animal) {
//
//    }
//
//    @Override
//    public void changeAnimal(Animal animal) {
//
//    }
}
