package testdomequestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Platformer {
    private static Integer currentIndex = 3;
    private static final LinkedList<Integer> floorMap = new LinkedList<>();
    private static Integer oldIndex = 0;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        floorMap.addAll(numbers);


        getSpot();
        printFloorMap();

        jumpLeft();
        getSpot();
        removeSpot();
        printFloorMap();

        jumpRight();
        getSpot();
        removeSpot();
        printFloorMap();

    }



    public static void jumpLeft() {
        oldIndex = currentIndex;
        currentIndex = currentIndex - 2;

    }

    public static void jumpRight() {
        oldIndex = currentIndex;
        currentIndex = currentIndex + 2;

    }

    public static void removeSpot() {
        floorMap.remove(oldIndex);
    }

    public static void getSpot() {
        System.out.println(floorMap.get(currentIndex));
    }

    public static void printFloorMap() {
        System.out.println(floorMap);
    }

}
