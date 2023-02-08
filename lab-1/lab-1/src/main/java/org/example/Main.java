package org.example;

import java.util.Scanner;

import org.example.task1.CosFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input an angle in rad: ");
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();

        System.out.println("Result = " + CosFunction.cos(x));
    }
}