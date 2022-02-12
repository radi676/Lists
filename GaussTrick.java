package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        List<Integer> newNumbers = new ArrayList<>();

        sum(numbers, newNumbers);

        if (numbers.size() % 2 != 0) {//ако размерът на листа е е нечетно число
            newNumbers.add(numbers.get(numbers.size() / 2)); //в новия лист на поселдно място добави средния елемент, който не се събира с никой
        }

        for (Integer newNumber : newNumbers) {
            System.out.print(newNumber + " ");
        }
    }
    private static void sum(List<Integer> numbers, List<Integer> newNumbers) {
        int i = 0;
        while (i < numbers.size() / 2) {
            int sum = numbers.get(i) + numbers.get(numbers.size() - 1 - i);
            newNumbers.add(sum);
            i++;
        }
    }
}

