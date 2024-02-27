// Q6. SUBARRAY OR

// Problem Description
// You are given an array of integers A of size N.
// The value of a subarray is defined as BITWISE OR of all elements in it.
// Return the sum of value of all subarrays of A % 109 + 7.

// Problem Constraints
// 1 <= N <= 105
// 1 <= A[i] <= 108

// Input Format
// The first argument given is the integer array A.

// Output Format
// Return the sum of Value of all subarrays of A % 109 + 7.

public class Solution {
    public int solve(ArrayList<Integer> A) {
        long mod = 1000000007;
        int n = A.size();
        long final_ans = 0;
        long total_subarrays = (long)n*(n+1)/2;

        for(int i=0; i<31; i++){
            long count_subarray_with_zero = 0;
            long count_consecutive_zero = 0;

            for(int j=0; j<n; j++){
                if((A.get(j)&1<<i)==0){
                    count_consecutive_zero++;
                }else{
                    count_subarray_with_zero += count_consecutive_zero*(count_consecutive_zero+1)/2;
                    count_consecutive_zero = 0;
                }
            }
            count_subarray_with_zero += count_consecutive_zero*(count_consecutive_zero+1)/2;
            long count_subarray_with_one = total_subarrays-count_subarray_with_zero;

            final_ans += count_subarray_with_one*(1<<i);
        }

    
        return (int)(final_ans%mod);
    }
}
