package org.nursery.data;

public class SpecieAnimal extends ClassAnimal{
    int classId;
    int specieId;
    String nameSpecie;
    String nameSpecieRus;

    public SpecieAnimal(int classId, int specieId, String nameSpecie, String nameSpecieRus) {
        this.classId = classId;
        this.specieId = specieId;
        this.nameSpecie = nameSpecie;
        this.nameSpecieRus = nameSpecieRus;
    }

    public SpecieAnimal() {
    }

    public int getSpecieId() {
        return specieId;
    }

    public String getNameSpecie() {
        return nameSpecie;
    }

    public String getNameSpecieRus() {
        return nameSpecieRus;
    }

    @Override
    public String toString(){
        return String.format("%d - %s", getSpecieId(), getNameSpecieRus());
    }

}
