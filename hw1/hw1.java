package jjjava.hw1;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class hw1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // // task1

        // System.out.println("\ntask1\n");

        // System.out.print("num: ");
        // int num = reader.nextInt();
        // int resAdd = 0;
        // int resMult = 1;
        // for (int i = 1; i <= num; i++) {
        //     if (num != 0) {
        //         resAdd += i;
        //         resMult *= i;
        //     } else
        //         resMult = 0;
        // }
        // System.out.printf("T(%d): %d", num, resAdd);
        // System.out.println();
        // System.out.printf("%d!: %d", num, resMult);

        // // task2

        // System.out.println("\ntask2\n");

        // System.out.print("num: ");
        // num = reader.nextInt();
        // for (int i = 1; i <= num; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         if (j != 1 && j != i && i % j == 0)
        //             break;
        //         if (i == j)
        //             System.out.println(i);
        //     }
        // }

        // task4 запутался =((((

        System.out.println("\ntask4\n");

        System.out.print("num Q: ");
        String userQ = reader.nextLine();
        System.out.print("num W: ");
        String userW = reader.nextLine();
        System.out.print("num E: ");
        String userE = reader.nextLine();

        int q, w, e;
        int check = 0;
        try {
            q = Integer.parseInt(userQ);
            check += 100;
        } catch (Exception ex) {
            q = genNum(userQ);
        }
        try {
            w = Integer.parseInt(userW);
            check += 10;
        } catch (Exception ex) {
            w = genNum(userQ);
        }
        try {
            e = Integer.parseInt(userE);
            check += 1;
        } catch (Exception ex) {
            e = genNum(userQ);
        }

        switch (check) {
            case 0:
                System.out.printf("%d + %d = %d", q, w, q + w);
                break;
            case 100:
            case 10:
            case 110:
                System.out.printf("%d + %d = %d", q, w, q + w);
                break;
            case 1:
            case 11:
                System.out.printf("%d + %d = %d", e - w, w, e);
                break;
            case 101:
                System.out.printf("%d + %d = %d", q, e - q, e);
                break;
            default:
                if (q + w == e)
                    System.out.printf("%d + %d = %d", e - w, w, e);
                else
                    System.out.print("No solution");
        }
    }

    public static int genNum(String userString) {
        Random random = new Random();
        char[] chars = userString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        int[] digits = new int[chars.length];
        for (int i = chars.length -1; i >= 0; i--) {
            int x = 1;
            try {
                digits[i] = Integer.valueOf(chars[i]);
                //System.out.println(digits[i]);
            } catch (Exception e) {
                digits[i] = (int) (Math.random()*10);
            }
            digits[i] *= x;
            x *= 10;
            
        }
        int buildedNum = 0;
        for (int i = 0; i < digits.length; i++) {
            buildedNum += digits[i];
        }
        //System.out.println(buildedNum);
        return buildedNum;

        // как убрать звездочки при раскомментировании?
    }
}