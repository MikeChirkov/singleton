package ru.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int size = sc.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = sc.nextInt();

        logger.log("Создаём и наполняем список");
        var list = createRandomArray(maxValue, size);
        System.out.print("Вот случайный список: ");
        list.forEach(v -> System.out.print(v + " "));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int threshold = sc.nextInt();
        Filter filter = new Filter(threshold);
        list = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Вот отфильтрованный список: ");
        list.forEach(v -> System.out.print(v + " "));
    }

    public static List<Integer> createRandomArray(int maxValue, int size) {
        Random rnd = new Random();
        var list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(maxValue));
        }
        return list;
    }
}