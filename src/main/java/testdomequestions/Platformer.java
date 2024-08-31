package testdomequestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Gaming algorithm...
when a player uses method jumpLeft(), the player should move 2 spaces to the left,
and also remove the previous index in the array.
When a player uses method jumpRight(), the player should move 2 spaces to the right,
and also remove the previous index.

Example:
given array {0,1,2,3,4,5} with current index = 3;
jumpLeft should produce the following results:
current index = 1 (value is 1)
new array values {0,[1],2,4,5}

then, jumpRight should produce the following results:
current index = 2 (value is 4)
new array values {0,2,[4],5}
 */
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
