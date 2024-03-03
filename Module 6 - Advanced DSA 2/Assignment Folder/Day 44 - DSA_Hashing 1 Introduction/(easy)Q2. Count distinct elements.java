// Problem Description
// Given an array A of N integers, return the number of unique elements in the array.

// Problem Constraints
// 1 <= N <= 105
// 1 <= A[i] <= 109

// Input Format
// First argument A is an array of integers.

// Output Format
// Return an integer.

public class Solution {
    public int solve(ArrayList<Integer> A) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.size();

        for(int i=0; i<n; i++){
            set.add(A.get(i));
        }

        return set.size();
    }
}
