package org.nursery.Model;

import org.nursery.dao.AnimalInterface;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Animal implements AnimalInterface {
    protected Long id;
    protected Date birthdate;
    protected String name;
    protected ArrayList<String> command;

    public Animal() {

    }

    public Animal(Long id, String birthdate, String name) {
        this.id = id;
        this.birthdate = parseDate(birthdate);
        this.name = name;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String dateFormat(Date date){
        Locale russian = new Locale("ru");
        String[] newMonths = {
                "января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(russian);
        dfs.setMonths(newMonths);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, russian);
        SimpleDateFormat sdf = (SimpleDateFormat) df;
        sdf.setDateFormatSymbols(dfs);

        return df.format(date);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = parseDate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCommand() {
        return command;
    }

    public void setCommand(ArrayList<String> command) {
        this.command = command;
    }

    public void newCommand(String command) {
        this.command.add(command);
    }

    public String commandList (ArrayList<String> command){

        StringBuilder commands = new StringBuilder();
        for (String item: command){
            commands.append(item.toString()).append("\n");
        }
        return commands.toString();
    }

    @Override
    public String toString() {
        return String.format("ID (инвентарный номер): %d;    Вид животного: %s;    Имя: %s; Дата рождения: %s ", getId(), getClass().getSimpleName(), name, dateFormat(getBirthdate()));
    }

    @Override
    public void getInfo() {

    }

}
