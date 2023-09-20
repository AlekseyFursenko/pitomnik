package org.nursery.presenter;

import org.nursery.Exeptions.DataExceptions;
import org.nursery.Model.Dog;
import org.nursery.Model.Model;
import org.nursery.Model.Animal;
import org.nursery.Model.Donkey;
import org.nursery.data.TestData;
import org.nursery.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Presenter {
    private Model model;
    private View view;
    public TestData data;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
        data = new TestData();

        Donkey don = new Donkey(1L,"2020-04-31","Don");
        Donkey don2 = new Donkey(2L,"2020-06-15","Выскочка");
        Dog dog = new Dog(3L,"2021-09-14","Трезор");
        Dog dog2 = new Dog(5L,"2021-09-14","Казбек");

        model.currentList().add(don);
        model.currentList().add(don2);
        model.currentList().add(dog);
        model.currentList().add(dog2);
        don.newCommand("Иа-Иа");
        don.newCommand("Фрр-Брр");
        don.newCommand("Жрать морковь");
        don.newCommand("Тупить");
        dog.newCommand("Дай лапу!!!");
        dog2.newCommand("Фас!!!");
    }

    public void add() throws DataExceptions {

        int classId = Integer.parseInt(view.getAnimalClass("Введите номер соответствующий классу животного:\n" + data.printClasses()));

//        if (!classContain(classId)){
//            throw new DataExeptions("Такого класса животных в списке нет!");
//        }
        try {
            int specieId = Integer.parseInt(view.getAnimalClass("Введите номер соответствующий названию животного:\n" + data.printSpecies(classId)));
            String specieName = null;
            specieName = model.getPathToModel() + data.nameSpecie(classId, specieId);

            Class<?> test = Class.forName(specieName);

            Long newAnimalId = view.getId();
            String newAnimalBirthdate = view.getDate();
            String newAnimalName = view.getName();

            Constructor<?> constructor = test.getConstructor(Long.class, String.class, String.class);
            Object newAnimal = constructor.newInstance(newAnimalId,newAnimalBirthdate,newAnimalName);
//            String className = test.getSimpleName();
//            System.out.println(className);
//            System.out.println(newAnimal);
            model.currentList().add((Animal) newAnimal);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println("Такого животного в списке нет!");
        } catch (Exception e) {
            System.out.println("Такого животного в списке нет!");
        }
    }

    public void edit() {

        if (model.currentList().count() < 1) {
            System.out.println("В списке нет записей о животных.");
        } else {
            System.out.println("Введите инвертарный номер (id) животного для редактирования данных.");
            Long id = view.getId();

            if (index_Id(id) < 0) {
                System.out.println("Животное с таким инвентарным номером не найдено.");
            } else {
                model.setCurrentIndex(index_Id(id));
                Animal temp = model.currentAnimal();
                System.out.println("Введите новые данные для животного " + temp.toString());
                temp.setId(view.getId());
                temp.setName(view.getName());
                temp.setBirthdate(view.getDate());
                model.currentList().editAnimal(model.currentAnimal(), temp);
                System.out.println("Данные изменены.");
            }
        }
    }

    public void editCommands() {

        if (model.currentList().count() < 1) {
            System.out.println("В списке нет записей о животных.");
        } else {
            System.out.println("Введите инвертарный номер (id) животного для редактирования списка команд.");
            Long id = view.getId();

            if (index_Id(id) < 0) {
                System.out.println("Животное с таким инвентарным номером не найдено.");
            } else {
                model.setCurrentIndex(index_Id(id));
                Animal temp = model.currentAnimal();
                System.out.println("Введите новую команду для животного " + temp.toString());
                temp.newCommand(view.getCommand());
                model.currentList().editAnimal(model.currentAnimal(), temp);
                System.out.println("Данные изменены.");
            }
        }
    }

    public void remove() {

        if (model.currentList().count() < 1) {
            System.out.println("В списке нет записей о животных.");
        } else {
            System.out.println("Введите инвертарный номер (id) животного для удаления из списка.");
            Long id = view.getId();

            if (index_Id(id) < 0) {
                System.out.println("Животное с таким инвентарным номером не найдено.");
            } else {
                model.setCurrentIndex(index_Id(id));
                Animal temp = model.currentAnimal();
                String text = "Удалить запись о животном\n" + temp.toString();
                if (view.getConfirm(text)) {
                    model.currentList().remove(model.currentAnimal());
                    System.out.println("Запись о животном " + temp.toString() + "была удалена.");
                }else {
                    System.out.println("Запись не была удалена");
                }
            }
        }
    }

    public void list_of_animals(){
        if (model.currentList().count() < 1) {
            System.out.println("В списке нет записей о животных.");
        }

        if(model.currentList().count() > 0){
            for (int i = 0; i < model.currentList().count(); i++) {
                model.setCurrentIndex(i);
                Animal animal = model.currentAnimal();
                System.out.println(animal.toString());
            }
        }
    }

    public void animalFullInfo(){
        if (!isEmpty()) {
            System.out.println("Введите инвертарный номер (id) животного.");
            Long id = view.getId();

            if (index_Id(id) < 0) {
                System.out.println("Животное с таким инвентарным номером не найдено.");
            } else {
                model.setCurrentIndex(index_Id(id));
                Animal animal = model.currentAnimal();
                animal.getInfo();
            }

        }
    }

    public void  saveAnimalsToFile(){
        model.saveToFile();
    }

    private int index_Id(Long id) {
        for (int i = 0; i < model.currentList().count(); i++) {
            model.setCurrentIndex(i);
            if (model.currentAnimal().getId() == id) {
                return i;
            }
        }
        return -1;
    }
    private boolean isEmpty(){
        boolean flag = false;
        if (model.currentList().count() < 1) {
            flag = true;
            System.out.println("В списке нет записей о животных.");}
        return flag;
    }

    private boolean classContain(int classId){
        for (int i = 0; i < data.getClassList().size(); i++) {
            if (data.getClassList().get(i).getClassId() == classId){
                return true;
            }
        }
        return false;
    }

    private boolean specieContain(int specieId){
        for (int i = 0; i < data.getSpecieList().size(); i++) {
            if (data.getSpecieList().get(i).getClassId() == specieId){
                return true;
            }
        }
        return false;
    }

}

