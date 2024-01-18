// Problem Description
// Given a string A, you are asked to reverse the string and return the reversed string.

// Problem Constraints
// 1 <= |A| <= 105
// String A consist only of lowercase characters.

public class Solution {
    public String solve(String A) {
        StringBuilder str = new StringBuilder();
        
        int n = A.length();
        for(int i=n-1; i>=0; i--){
            str.append(A.charAt(i));
        }

        String ans = str.toString();

        return ans;
    }
}
