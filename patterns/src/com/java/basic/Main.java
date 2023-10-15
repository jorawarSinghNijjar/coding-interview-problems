package com.java.basic;

public class Main {

    public static void main(String[] args) {
        // write your code here
        pattern1(5);
        pattern28(5);
    }

    static void pattern1(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row <= n ? row : 2*n - row;

                for (int col = 0; col < totalColsInRow; col++) {
                    System.out.print("* ");
                }

            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row <= n ? row : 2*n - row;
            int numOfSpaces = n - totalColsInRow;
            for (int s = 0; s < numOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

}
