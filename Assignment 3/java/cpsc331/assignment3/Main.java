package cpsc331.assignment3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(10);


        int i = 0;
        while (i < 5) {
        A.add(i);
        i = i + 1;
        };
        
        BetterMergeSort<Integer> Tester = new BetterMergeSort<Integer>();
        ArrayList<Integer> B = Tester.sort(A);

        System.out.println("Final sorted array: " + B.toString());

    }
}