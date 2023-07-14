package equilibriumIndexofArray;

import java.util.Scanner;

public class EquilibriumIndexOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        System.out.println("Enter the array elements");
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        EquilibriumIndexOfArray equilibriumIndexOfArray = new EquilibriumIndexOfArray();
        System.out.println(equilibriumIndexOfArray.findEquilibriumPoint(array, size));

    }

    public int findEquilibriumPoint(int array[], int size) {
        int prefix[] = new int[size];
        prefix[0] = array[0];
        // int count = 0;
        for (int i = 1; i < size - 1; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        for (int j = 1; j < size; j++) {
            int leftSum = prefix[j] - array[j];
            int rightSum = prefix[size - 1] - prefix[j];
            if (leftSum == rightSum) {
                return j;
            }
        }
        return -1;
    }

}
