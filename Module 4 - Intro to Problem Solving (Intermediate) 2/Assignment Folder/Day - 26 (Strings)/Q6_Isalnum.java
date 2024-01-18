// Problem Description
// You are given a function isalpha() consisting of a character array A.
// Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.

// Problem Constraints
// 1 <= |A| <= 10^5

public class Solution {
    public int solve(ArrayList<Character> A) {

        int n = A.size();
        

        for(int i=0; i<n; i++){
           char ch = A.get(i);
           if(
               !(ch>='0' && ch<='9') &&
               !(ch>='a' && ch<='z') &&
               !(ch>='A' && ch<='Z')
           )
           return 0;
        }

        return 1;
    }

}
