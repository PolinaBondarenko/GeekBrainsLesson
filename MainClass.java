import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        //Первое задание
        List<String> list = new ArrayList<>();
        list.add("День");
        list.add("День");
        list.add("квартира");
        list.add("бублик");
        list.add("бублик");
        list.add("игнор");
        list.add("день");
        list.add("иголка");
        list.add("крошка");
        list.add("домашка");
        list.add("работа");
        list.add("Java");
        list.add("GeekBrains");
        list.add("кошка");
        list.add("собака");
        list.add("Java");
        list.add("елка");
        list.add("ёлка");
        list.add("корабль");
        list.add("Java");

        //Stream
        list.stream().distinct().forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        //Set
        HashSet<String> set = new HashSet<>(list);
        for (String str : set){
            System.out.println(str);
        }

        System.out.println("----------------Второе задание--------------------");

        //Второе задание
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(123456, "Ivanov");
        phoneBook.add(989535, "Lebedev");
        phoneBook.add(125658, "Ivanov");
        phoneBook.add(789456, "Sidorov");

        phoneBook.get("Ivanov");
        phoneBook.get("Sidorov");

    }
}
