package HomeWork3;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Введите число от 1 до 5 для выбора метода");
            System.out.println("1 - Сумма всех положительных чисел двумерного массива");
            System.out.println("2 - Печать квадрата из звездочек");
            System.out.println("3 - Зануление диагоналей двумерного массива ");
            System.out.println("4 - Поиск максимального числа в двумерном масстве");
            System.out.println("5 - Сумма элементов второй строки массива с проверкой наличия второй строки");
            System.out.println("0 - Выход");

            int result = scanner.nextInt();
            if (result == 1) {
                int[][] arr1 = new int[5][5];
                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr1[i].length; j++) {
                        arr1[i][j] = (int) ((Math.random() - (Math.random())) * 10);
                        System.out.print(arr1[i][j] + "\t"); // разделяем элементы массива при выводе табуляцией, а не пробелом
                    }
                    System.out.println();
                }
                sumOfPositiveElements(arr1);
            }
            if (result == 2) {
                System.out.println("Введите длину стороны квадрата");
                int sc2 = scanner.nextInt();
                printSquare(sc2);
            }
            if (result == 3) {
                int[][] arr3 = new int[10][10];
                System.out.println("Был такой массив:");
                for (int i = 0; i < arr3.length; i++) {
                    for (int j = 0; j < arr3[i].length; j++) {
                        arr3[i][j] = (int) (Math.random() * 10);
                        System.out.print(arr3[i][j] + "\t");
                    }
                    System.out.println();
                }
                zorroX(arr3);
            }
            if (result == 4) {
                int[][] arr4 = new int[10][10];
                for (int i = 0; i < arr4.length; i++) {
                    for (int j = 0; j < arr4[i].length; j++) {
                        arr4[i][j] = (int) (Math.random() * 100);
                        System.out.print(arr4[i][j] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("Максимальное число в данном массиве: " + findMax(arr4));
            }
            if (result == 5) {
                System.out.println("Проверяем работу метода \n1 - c целым массивом\n2 - c пустой второй строкой");
                int sc5 = scanner.nextInt();
                int[] arrNull = {};
                int[][] arr5 = new int[10][10];
                for (int i = 0; i < arr5.length; i++) {
                    for (int j = 0; j < arr5[i].length; j++) {
                        arr5[i][j] = (int) (Math.random() * 100);
                    }
                }
                if (sc5 == 1) {
                    sumSecondString(arr5);
                }
                if (sc5 == 2) {
                    arr5[1] = arrNull;
                    sumSecondString(arr5);
                }

                for (int i = 0; i < arr5.length; i++) {
                    for (int j = 0; j < arr5[i].length; j++) {
                        System.out.print(arr5[i][j] + "\t");
                    }
                    System.out.println();
                }

                if (sumSecondString(arr5) == -1) {
                    System.out.println("В данном массиве нет второй строки");
                } else {
                    System.out.println("Сумма элементов второй строки массива = " + sumSecondString(arr5));
                }
            }

            if (result == 0) {
                break;
            }
        }
    }
    private static int sumSecondString(int[][] array) {// Метод №5
        int sum = 0;
        if (array[1].length == 0) {
            return -1;
        } else {
            for (int j = 0; j < array[1].length; j++) {
                sum += array[1][j];
            }
            return sum;
        }
    }

    private static int findMax(int[][] array) {// Метод №4
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    private static void zorroX(int[][] arr) {// Метод №3
        System.out.println("А такой стал:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || i == arr[j].length - j - 1) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void printSquare(int size) {// Метод №2
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private static void sumOfPositiveElements(int[][] arr) {// Метод №1
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println("Сумма положительных элементов массива = " + sum);
    }
}
