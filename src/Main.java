import java.util.*;

class TwoIndexes {

    int i;
    int j;

    public TwoIndexes(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {

        return i;

    }

    public int getJ() {

        return j;

    }

    @Override
    public String toString() {
        return "{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

}

public class Main {

    static int rows = 7;
    static int columns = 7;
    static int[][] arr = new int[rows][columns];

    public static void fillArr() {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                arr[i][j] = (int) (Math.random() * 7);

            }

        }

    }

    public static void printArr() {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                System.out.print(arr[i][j] + "  ");

            }

            System.out.print("\n");

        }

    }

    public static void findAllSuitableElementsAndIndexes(List<TwoIndexes> twoIndexesList, int maxLengthJump) {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (arr[i][j] <= maxLengthJump) {

                    twoIndexesList.add(new TwoIndexes(i, j));

                }

            }

        }

    }

    public static void recursionPart(List<TwoIndexes> twoIndexesList, TwoIndexes currentPoint, int maxLengthJump) {

        List<TwoIndexes> suitablePoints = new ArrayList<>();

        if ((currentPoint.getI() != 6) && (currentPoint.getJ() != 6)) {

            for (TwoIndexes twoIndexes : twoIndexesList) {

                if (((twoIndexes.getI() - currentPoint.getI() > 0) && (twoIndexes.getI() - currentPoint.getI() < maxLengthJump)) && (twoIndexes.getJ() == currentPoint.getJ())) {

                    suitablePoints.add(twoIndexes);

                }

                if (((twoIndexes.getJ() - currentPoint.getJ() > 0) && (twoIndexes.getJ() - currentPoint.getJ() < maxLengthJump)) && (twoIndexes.getI() == currentPoint.getI())) {

                    suitablePoints.add(twoIndexes);

                }

            }

            if (!suitablePoints.isEmpty()) {

                isPathExists(twoIndexesList, suitablePoints, maxLengthJump);

            } else {

                System.out.println("No such a path");

            }

        } else {

            System.out.println("There is a path");

        }

    }

    public static void isPathExists(List<TwoIndexes> twoIndexesList, List<TwoIndexes> suitablePoints, int maxLengthJump) {

        TwoIndexes currentPoint;

        for (TwoIndexes suitablePoint : suitablePoints) {

            currentPoint = suitablePoint;
            recursionPart(twoIndexesList, currentPoint, maxLengthJump);

        }

    }

    public static void main(String[] args) {

        fillArr();
        printArr();

        List<TwoIndexes> twoIndexesList = new ArrayList<>();

        int maxLengthJump = arr[rows - 1][columns - 1];
        findAllSuitableElementsAndIndexes(twoIndexesList, maxLengthJump);

/*        for (TwoIndexes twoIndexes : twoIndexesList) {
            System.out.println(twoIndexes);
        }*/

        recursionPart(twoIndexesList, new TwoIndexes(0, 0), maxLengthJump);

    }

}
