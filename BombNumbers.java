package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] data = scanner.nextLine().split("\\s+");

        int bomb = Integer.parseInt(data[0]); //бомбата, числото, което заедно със съседните си ще бъде премахнато от листа
        int power = Integer.parseInt(data[1]);//силата-колкото числа отляво и отдясно на бомбата има, толкова ще бъдат премахнати
        int bombIndex = numbers.indexOf(bomb);//индекса на бомбата в листа

        int start = Math.max(bombIndex - power, 0);//ако стартовия индекс е отрицателно число, вземи нулевия индекс и нека той бъде последното премахнато число
        int end = Math.min(bombIndex + power, numbers.size() - 1); //ако крайният индекс излиза от рамките на листа, вземи индекса на последното число и нека той да бъде последното премахнато число
//        int start = bombIndex - power;  //започва отляво на бомбата
//        int end = bombIndex + power; // краят е отдясно на  бомбата

        //премахване на елементи
        for (int i = start; i <= end; i++) {
            numbers.remove(start);  //премахвам само на стартовия индекс, защото листът се преоразмерява

        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.print(sum);
    }

}


