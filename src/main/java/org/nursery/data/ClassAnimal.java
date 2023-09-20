package org.nursery.data;

public class ClassAnimal {
    int classId;
    String nameClass;
    String nameClassRus;

    public ClassAnimal(int classId, String nameClass, String nameClassRus) {
        this.classId = classId;
        this.nameClass = nameClass;
        this.nameClassRus = nameClassRus;
    }

    public ClassAnimal() {

    }

     public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameClassRus() {
        return nameClassRus;
    }

    @Override
    public String toString(){
        return String.format("%d - %s", getClassId(),getNameClassRus());
    }
}
