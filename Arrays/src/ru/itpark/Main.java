package ru.itpark;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter some number: ");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter some number for array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i]%25
                    == 0){
                arr[i]=0;
            }
            System.out.print(arr[i] + " ");
        }

        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            
        }

        System.out.print(arr[i] + " ");


    }
}
