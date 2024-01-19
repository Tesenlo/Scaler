// Problem Description
// You are given a string A of size N.

// Return the string A after reversing the string word by word.

// NOTE:
// A sequence of non-space characters constitutes a word.
// Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
// If there are multiple spaces between words, reduce them to a single space in the reversed string.

// Problem Constraints
// 1 <= N <= 3 * 105

public class Solution {
    public static String reverse(String s){
        int n = s.length();
        String ans ="";
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            ans = ans+ch;
        }
        return ans;
    }
    public String solve(String A) {
        int n = A.length();
        String ans = "";
        for(int i=n-1; i>=0; i--){
            if(A.charAt(i)!=' '){
                String curr = "";
                while(i>=0 && A.charAt(i)!=' '){
                    curr = curr+A.charAt(i);
                    i--;
                }
                curr = reverse(curr);
                if(ans != ""){
                    ans += ' ';
                }
                ans += curr;
            }
            
        }
        return ans;

    }
}
