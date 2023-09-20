package org.nursery.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleView implements View{
    Scanner in;
    public ConsoleView(){
        in = new Scanner(System.in);
    }

    public String input(String message){
        System.out.printf(message);
        return in.nextLine();
    }

    public static boolean isNumeric(String strNum, String falseMessage) {
//        if (strNum == null) {
//            return false;
//        }
        try {
            Long.parseLong(strNum);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println(falseMessage);
            return false;
        }

    }

    public static boolean valueTrue(String strNum, int maxLimit, String falseMessage){
        try {
            int value = Integer.parseInt(strNum);
            if(value > 0 && value <= maxLimit) return true;
        } catch (NumberFormatException nfe) {
            System.out.println(falseMessage);
            return false;
        }
        return false;
    }

    public static boolean notNull(String value, String falseMessage){
        if (value == null || value.equals("")) {
            System.out.println(falseMessage);
            return false;
        }
        return true;
    }

    public static boolean isDate(String date, String falseMessage) {
        final String DATE_FORMAT = "yyyy-MM-dd";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println(falseMessage);
            return false;
        }

    }

    @Override
    public Long getId() {
        String value = null;
        String message = "Введите ID животного: ";
        String falseMessage = "Введите корректное число!!!";

        do {
            value = input(message);
        } while (!notNull(value, falseMessage) ||
                !isNumeric(value, falseMessage));
        //in.close();
        return Long.valueOf(value);
    }

    @Override
    public void setId(Long value) {
        System.out.printf("ID животного: %d\n", value);
    }

    @Override
    public String getAnimalClass(String message) {
        String value = null;
        String falseMessage = "Введите корректное число!!!";

        do {
            value = input(message);
        } while (!notNull(value, falseMessage));

        return value;
    }
    @Override
    public String getName() {
        String value = null;
        String message = "Введите имя животного: ";
        String falseMessage = "Поле не может быть пустым!!!";
        do {
            value = input(message);
        } while (!notNull(value, falseMessage));
//        in.close();
        return value;
    }

    @Override
    public void setName(String value) {
        System.out.printf("Имя животного: %s\n", value);
    }

    @Override
    public String getDate() {
        String value = null;
        String message = "Введите дату рождения животного\nв формате ГГГГ-ММ-ДД: ";
        String falseMessage = "Поле не может быть пустым!!!";
        String falseMessage2 = "Дата введена не верно";
        do {
            value = input(message);
        } while (!notNull(value, falseMessage) ||
                !isDate(value, falseMessage2));
//        in.close();
        return value;
    }

    @Override
    public void setDate(String value) {
        System.out.printf("Дата рождения: %s\n", value);
    }

    @Override
    public boolean getConfirm(String text) {
        System.out.println(text);
        String value = null;
        String message = "Вы уверены? (y/n)";
        String falseMessage = "Введите 'y' или 'n'!";
        while (true){
            value = input(message);
            if (notNull(value, "") &&
                    (Objects.equals(value, "y") ||
                     Objects.equals(value, "Y") ||
                     Objects.equals(value, "n") ||
                     Objects.equals(value, "N"))) {
                break;
            }
            System.out.println(falseMessage);
        }
//        in.close();

        return value.equals("y") ||
                value.equals("Y");
    }

    @Override
    public String getCommand() {
        String value = null;
        String message = "Введите название команды: ";
        String falseMessage = "Поле не может быть пустым!!!";
        do {
            value = input(message);
        } while (!notNull(value, falseMessage));
//        in.close();
        return value;
    }
}
