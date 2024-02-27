// Problem Description
// Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

// Problem Constraints
// 2 <= length of the array <= 100000
// 0 <= A[i] <= 109

// Input Format
// First and only argument of input contains an integer array A.

// Output Format
// Return a single integer denoting minimum xor value.

public class Solution {
  
    public int findMinXor(ArrayList<Integer> A) {
        int n = A.size();
       Collections.sort(A);
       int ans = Integer.MAX_VALUE;

       for(int i=0; i<n-1; i++){
           ans = Math.min(ans, A.get(i)^A.get(i+1));
       }

       return ans;

    }
}
