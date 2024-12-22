import java.util.Scanner;

public class PowerLevelSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];

        // Step 1: Input the Power Levels
        System.out.println("Enter the power levels of 10 creatures:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Power Level " + (i + 1) + ": ");
            powerLevels[i] = scanner.nextInt();
        }

        // Step 2: Bubble Sort Implementation (Ascending Order)
        int[] bubbleSorted = powerLevels.clone();
        bubbleSort(bubbleSorted);
        System.out.println("\nPower levels sorted in ascending order (Bubble Sort):");
        displayArray(bubbleSorted);

        // Step 3: Selection Sort Implementation (Descending Order)
        int[] selectionSorted = powerLevels.clone();
        selectionSort(selectionSorted);
        System.out.println("\nPower levels sorted in descending order (Selection Sort):");
        displayArray(selectionSorted);

        // Step 4: Calculate and Display Analysis
        int sumEven = 0, sumOdd = 0;
        for (int power : powerLevels) {
            if (power % 2 == 0) {
                sumEven += power;
            } else {
                sumOdd += power;
            }
        }

        int minPower = bubbleSorted[0]; // After Bubble Sort, the first element is the minimum
        int maxPower = bubbleSorted[bubbleSorted.length - 1]; // After Bubble Sort, the last element is the maximum

        System.out.println("\nAnalysis:");
        System.out.println("Sum of even power levels: " + sumEven);
        System.out.println("Sum of odd power levels: " + sumOdd);
        System.out.println("Minimum power level: " + minPower);
        System.out.println("Maximum power level: " + maxPower);
    }

    // Bubble Sort Method (Ascending Order)
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort Method (Descending Order)
    private static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap array[i] and array[maxIndex]
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

    // Utility Method to Display an Array
    private static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
