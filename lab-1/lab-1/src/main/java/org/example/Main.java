package org.example;

import java.util.Arrays;
import java.util.Scanner;

import org.example.task1.CosFunction;
import org.example.task2.CountSort;

public class Main {
    public static void main(String[] args) {
        // task 1
//        System.out.println("Input an angle in rad: ");
//        Scanner input = new Scanner(System.in);
//        double x = input.nextDouble();
//        System.out.println("Result = " + CosFunction.cos(x));


        // task 2
        int[] array = new int[]{10, 20, 14, 0, 2};
        CountSort.sort(array, array.length);
        System.out.println(Arrays.toString(array));







        // task 3

    }
}