package Lists;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdjacentSumOfTheSameNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> numbers = Arrays
                .stream(sc.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++)
            if (numbers.get(i).equals(numbers.get(i + 1))) {//проверяваш дали са равни два съседни елемента
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));//ако са, слагаш на и-та позиция сумата им
                numbers.remove(i + 1);//премахваш индекса на второто събираемо
                i = -1;//намаляш индекса с едно и се връщащ една позиция назад
            }

        System.out.println(joinElementsByDelimiter(numbers));
    }
    static String joinElementsByDelimiter(List<Double> numbers) {
        StringBuilder output = new StringBuilder();
        for (Double number : numbers) {
            DecimalFormat df = new DecimalFormat("0.#");
            String numDf = df.format(number) + " ";
            output.append(numDf);
        }
        return output.toString();
    }

}
