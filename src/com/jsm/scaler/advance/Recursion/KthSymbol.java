package com.jsm.scaler.advance.Recursion;

public class KthSymbol {
    /*
    On the first row, we write a 0. Now in every subsequent row,
    we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).

    Problem Constraints
    1 <= A <= 20
    1 <= B <= 2A - 1

    Input Format
    First argument is an integer A.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the Bth indexed symbol in row A.

    Example Input

    Input 1:
     A = 2
     B = 1

    Input 2:
     A = 2
     B = 2

    Example Output

    Output 1:
     0

    Output 2:
     1

    Example Explanation

    Explanation 1:
     Row 1: 0
     Row 2: 01

    Explanation 2:
     Row 1: 0
     Row 2: 01
    */

    private static int solve(int N, int K) {
        if (N == 1)
            return 0;
        int parent = solve(N - 1, K / 2 + K % 2);
        boolean isKOdd = (K % 2 == 1);
        if (parent == 1)
            return isKOdd ? 1 : 0;
        return isKOdd ? 0 : 1;
    }

    public static void main(String[] args) {
        int N = 4, K = 5;
        System.out.println(solve(N, K));
    }

}
