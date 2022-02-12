package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> train = Arrays
                .stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());//максимален брой хора във вагон

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] data = line.split(" ");
            if (data[0].equals("Add")) {//добави нов вагон
                train.add(Integer.parseInt(data[1]));//сложи във влака новия вагон с броя пътници data[1]->пътници
            } else {
                int passangers = Integer.parseInt(data[0]);//броя пънтници
                for (int i = 0; i < train.size(); i++) {
                    if (train.get(i) + passangers <= maxCapacity) {//ако в някой вагона от ляво надясно има място, добави броя пътници
                        train.set(i, train.get(i) + passangers);
                        break;
                    }
                }
            }
            line = scanner.nextLine();
        }
        for (Integer wagon : train) {
            System.out.print(wagon + " ");
        }
    }
}
