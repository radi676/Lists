package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> aList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> bList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> mergedList = new ArrayList<>();

        int minSizeOfAList = Math.min(aList.size(), bList.size()); //вземи размера на по-мслкия лист
        for (int i = 0; i < minSizeOfAList; i++) {
            int firstItemFromTheAList = aList.get(i);
            int secondItemFromTheBList = aList.get(i);
            mergedList.add(firstItemFromTheAList);
            mergedList.add(secondItemFromTheBList);

        }
        if (aList.size() > bList.size()) {
            mergedList.addAll(aList.subList(minSizeOfAList, aList.size()));   //индекса, където добавям останалите елементи , започва там, където е последният индекс на по-късия лист и свършва на поселдния индекс, койъо е и дължината
        } else {
            mergedList.addAll(bList.subList(minSizeOfAList, bList.size()));
        }
    }
}

