// Problem Description
// Find the number of occurrences of bob in string A consisting of lowercase English alphabets.

// Problem Constraints
// 1 <= |A| <= 1000

public class Solution {
    public int solve(String A) {

        int n = A.length();
        int bobCount = 0;

        for(int i=1; i<n-1; i++){
            if(A.charAt(i)=='o'){
                int L = i-1;
                int R = i+1;
                if(A.charAt(L)=='b' && A.charAt(R)=='b'){
                    bobCount++;
                } 
            }
            
        }

        return bobCount;
    }
}
