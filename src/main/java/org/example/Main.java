package org.example;

import java.util.*;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//Создать множество ноутбуков.
//Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
// отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//Например:
//“Введите цифру, соответствующую необходимому критерию:
//1 - ОЗУ
//2 - Объем ЖД
//3 - Операционная система
//4 - Цвет …
//Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
//Работу сдать как обычно ссылкой на гит репозиторий
//Частые ошибки:
//1. Заставляете пользователя вводить все существующие критерии фильтрации
//2. Невозможно использовать более одного критерия фильтрации одновременно
//3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
//4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики
// ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Lenovo IdealPad 5", 8, 256, "Windows 11", "синий", 15.6);
        Laptop laptop2 = new Laptop("Honor MagicBook 16", 16, 512, "без ОС", "серый", 16.1);
        Laptop laptop3 = new Laptop("Apple MacBook Air 13", 8, 256, "MacOs", "золотистый", 13.3);
        Laptop laptop4 = new Laptop("HP 250 G7", 4, 1024, "без ОС", "черный", 15.6);
        Laptop laptop5 = new Laptop("Xiomi RedmiBook 15", 8, 256, "Windows 11", "серый", 15.6);
        Laptop laptop6 = laptop1;
        Set<Laptop> unicLaptop = new HashSet<Laptop>();
        unicLaptop.add(laptop1);
        unicLaptop.add(laptop2);
        unicLaptop.add(laptop3);
        unicLaptop.add(laptop4);
        unicLaptop.add(laptop5);
        unicLaptop.add(laptop6);
        System.out.printf("Первый ноутбук идентичен шестому: %b \n", laptop1.equals(laptop6));
        System.out.printf("Всего уникалных ноутбуков: %d \n", unicLaptop.size());
        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "объем оперативной памяти");
        mapCrit.put(2, "объем накопителя");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "цвет");
        mapCrit.put(5, "диагональ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики: 1. объем оперативной памяти: ");
        int ramUser = sc.nextInt();
        System.out.println("объем накопителя: ");
        int storUser = sc.nextInt();
        System.out.println("диагональ");
        double digUser = sc.nextDouble();
        for(Laptop lap: unicLaptop) {
            if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser)  && lap.getDiagonal() >= digUser) {
                System.out.println(lap.toString());
            }
        }
        sc.close();
    }
}

