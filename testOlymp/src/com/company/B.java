package com.company;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        if(x1 > x2) {
            int temp = x2;
            x2 = x1;
            x1 = temp;
            int t = y2;
            y2 = y1;
            y1 = t;
        }
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                if (Math.abs(i - x1) + Math.abs(k - y1) == Math.abs(i - x2) + Math.abs(k - y2)) {
                    System.out.println(i + " " + k + "\n");
                }
            }
        }
    }
}
