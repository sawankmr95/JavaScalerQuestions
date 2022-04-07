package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithGivenSum {
    /*
    Given an array of positive integers A and an integer B, find and return first continuous sub-array which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 109
    1 <= B <= 109

    Input Format
    The first argument given is the integer array A.
    The second argument given is integer B.

    Output Format
    Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

    Example Input

    Input 1:
     A = [1, 2, 3, 4, 5]
     B = 5

    Input 2:
     A = [5, 10, 20, 100, 105]
     B = 110

    Example Output

    Output 1:
     [2, 3]

    Output 2:
     -1

    Example Explanation

    Explanation 1:
     [2, 3] sums up to 5.

    Explanation 2:
     No sub-array sums up to required number.
    */

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int start = 0, sum = A.get(0);
        for (int i = 1; i <= n; i++) {
            while (sum > B && start < i - 1) {
                sum = sum - A.get(start);
                start++;
            }
            if (sum == B) {
                for (int j = start; j <= i - 1; j++) {
                    ans.add(A.get(j));
                }
                return ans;
            }
            if (i < n)
                sum += A.get(i);
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 5;
        System.out.println(solve(A, B));
    }
}
