// Problem Description
// You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.

// Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.

// Problem Constraints
// 1 <= N <= 105
// A and B are lowercase strings

public class Solution {                          //TC - O(N)
    public int solve(String A, String B) {       //SC - O(1)
        int sumA = 0;
        int sumB = 0;

        int n=A.length();

        for(int i=0; i<n; i++){
            sumA += Character.getNumericValue(A.charAt(i));
            sumB += Character.getNumericValue(B.charAt(i));
        }

        if(sumA == sumB){
            return 1;
        }else{
            return 0;
        }
    }
}

