package org.nursery;

import org.nursery.Exeptions.DataExceptions;
import org.nursery.presenter.Presenter;
import org.nursery.view.ConsoleView;
import org.nursery.view.View;

import java.util.Scanner;

public class App {
    public static void ButtonClick() {
        System.out.print("\033[H\033[J");
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.print("""
                        ----------------------------
                        1 - Показать список всех животных в питомнике
                        2 - Показать полную информацию о животном
                        3 - Добавить новое животное в список
                        4 - Обучить животное новой команде
                        5 - Редактировать запись о животном
                        7 - Удалить запись о животном
                        
                        0 - Выход из приложения
                        ------------------------------
                        Выберете нужный пункт меню
                        """);
                String key = in.next();
                System.out.print("\033[H\033[J");

                switch (key) {
                    case "1" -> presenter.list_of_animals();
                    case "2" -> presenter.animalFullInfo();
                    case "3" -> presenter.add();
                    case "4" -> presenter.editCommands();
                    case "5" -> presenter.edit();
                    case "7" -> presenter.remove();
                    case "0" -> System.exit(0);
                    case "9" -> presenter.saveAnimalsToFile();
                    default -> System.out.println("Введите другую команду.");
                }
            }
        } catch (DataExceptions e) {
            throw new RuntimeException(e);

        }
    }
}
