package org.nursery.data;

import java.util.ArrayList;

public class TestData {
    ArrayList<ClassAnimal> classList;
    ArrayList<SpecieAnimal> specieList;

    public TestData() {
        classList = new ArrayList<ClassAnimal>();
        specieList =new ArrayList<SpecieAnimal>();

        this.classList.add(0,new ClassAnimal(1, "BeastOfBurden", "Вьючное"));
        this.classList.add(1,new ClassAnimal(2, "Pet", "Домашнее"));

        this.specieList.add(0, new SpecieAnimal(1,1,"Donkey","Осёл"));
        this.specieList.add(1, new SpecieAnimal(1,2,"Camel","Верблюд"));
        this.specieList.add(2, new SpecieAnimal(1,3,"Horse","Лошадка"));
        this.specieList.add(3, new SpecieAnimal(2,1,"Cat","Кошак"));
        this.specieList.add(4, new SpecieAnimal(2,2,"Dog","Собачка"));
        this.specieList.add(5, new SpecieAnimal(2,3,"Hamster","Хомяк"));

    }
    public ArrayList<ClassAnimal> getClassList() {
        return classList;
    }

    public ArrayList<SpecieAnimal> getSpecieList() {
        return specieList;
    }

    public String nameSpecie(int classId, int specieId) throws Exception{
        for (int i = 0; i < specieList.size(); i++) {
            if(this.specieList.get(i).classId == classId &&
                this.specieList.get(i).specieId == specieId){
                return this.specieList.get(i).nameSpecie;
            }
        }
        return null;
    }

    public String printClasses(){
        StringBuilder classesList = new StringBuilder();
        for (ClassAnimal item : classList) {
            classesList.append(item.toString()).append("\n");
        }
        return classesList.toString();
    }

    public String printSpecies(int classId){
        StringBuilder speciesList = new StringBuilder();
        for (SpecieAnimal item : specieList) {
            if (item.classId == classId) {
                speciesList.append(item.toString()).append("\n");
            }
        }
        return speciesList.toString();
    }
}
