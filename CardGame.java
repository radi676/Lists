package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays
                .stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) { //играта продължава докато и двамата все още имат карти
            //запазвам си взетите карти
            int firsPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);
            //след като ги взема, ги премахвам от списъка
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firsPlayerCard > secondPlayerCard) {
                //първият играч си прибира неговата карта, която е хвърлил, както и тази на втория играч
                firstPlayerCards.add(firsPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firsPlayerCard) {  //вторият играч си прибира неговата карта, която е хвърлил, както и тази на първия играч
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firsPlayerCard);
            }

        }
      //ако на първия му свършат картите, вторият печели
        if (firstPlayerCards.size() == 0) {
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
            //ако на вториия му свършат картите, първияъ печели
        } else {
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
        }
    }

    private static int getCardsSum(List<Integer> cards) {
        int sum = 0;
        for (Integer card : cards) {
            sum += card;
        }
        return sum;
    }

}
