package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                 .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] data = line.split("\\s+");

            String command = data[0];

            switch (command) {
                case "Add":

                    numbers.add(Integer.parseInt(data[1])); //добави число на края на листа
                    break;
                case "Insert":

                    int number = Integer.parseInt(data[1]); //числото, което ще добавим
                    int index = Integer.parseInt(data[2]); //индекса, където ще го сложим
                    insert(number, index, numbers);
                    break;

                case "Remove":
                    index = Integer.parseInt(data[1]);
                    remove(numbers, index);
                    break;

                case "Shift":
                    int count = Integer.parseInt(data[2]); //колко пъти да преместим
                    if (data[1].equals("left")) {

                        for (int i = 0; i < count; i++) {
                            // добави първия елемент на последно място
                            numbers.add(numbers.get(0));
                            // махни елемента на нулева позиция
                            numbers.remove(0);
                        }
                    } else {
                        for (int i = 0; i < count; i++) {
                            // сложи последния елемент на първа позиция
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            // махни последния елемент
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        numbers.forEach(el -> System.out.print(el + " "));
    }

    private static void remove(List<Integer> numbers, int index) {
        if (index < 0 || index >= numbers.size()) { //ако индексът е извън рамките на листа или е отрицателно число, той е невалиден
            System.out.println("Invalid index");
        } else {
            numbers.remove(index);
        }
    }

    public static void insert(int element, int index, List<Integer> nums) {
        if (index < 0 || index >= nums.size()) { //ако индексът е извън рамките на листа или е отрицателно число, той е невалиден
            System.out.println("Invalid index");
        } else {
            nums.add(index, element); //ако е валиден, добави на съответния индекс, даденото число
        }
    }
}
