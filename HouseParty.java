package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = new ArrayList<>(); //финален списък с гостите

        int n = Integer.parseInt(scanner.nextLine());//брой команди

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] data = line.split("\\s+");
            String name = data[0]; //името на госта
            if (!line.contains("is not going!")) {//ако гостът ще идва
                if (guests.contains(name)) {//ако се опитаме да добавим гост, койт вече е в списъкс
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name); //добави в списъка това име
                }
            } else { //ако няма да идва
                if (guests.contains(name)) {//ако вече е в списъка, го махни
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        guests.forEach(System.out::println);
    }
}
