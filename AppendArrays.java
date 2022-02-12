package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> listSeperatedByPipe = Arrays.
                stream(line.split("\\|"))//escape the special symbol |
                .collect(Collectors.toList());
        Collections.reverse(listSeperatedByPipe);
        System.out.println(listSeperatedByPipe.toString() //принтирай листа като стринг
                .replace("[", "")//махни тези скоби
                .replace("]", "")
                .trim()//махни излишните интервали накрая
                .replaceAll(",", "") //махни всички запетаи
                .replaceAll("\\s+", " ")); //замени всички интервали повече от един само с един

    }
}
