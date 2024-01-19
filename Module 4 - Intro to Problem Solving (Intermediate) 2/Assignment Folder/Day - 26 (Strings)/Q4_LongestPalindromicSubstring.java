// Problem Description
// Given a string A of size N, find and return the longest palindromic substring in A.

// Substring of string A is A[i...j] where 0 <= i <= j < len(A)

// Palindrome string:
// A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

// Incase of conflict, return the substring which occurs first ( with the least starting index).

// Problem Constraints
// 1 <= N <= 6000

public class Solution {

    public static String subString(String A, int s, int e){
        String subString = "";
        for(int i = s; i<=e; i++){
            subString += A.charAt(i);
        }
        return subString;
    }

    public String longestPalindrome(String A) {
        String ans = "";
        int n = A.length();
        int maxLength = 1;
        int s = 0;
        int e = 0;
        String longestPalindrome = String.valueOf(A.charAt(0));

        for(int c=0; c<n ;c++){ //for odd palindrome
            int i = c;
            int j = c;
            while(i>=0 && j<n){
                if(A.charAt(i) != A.charAt(j)){
                    break;
                }
                i--;
                j++;
            }
            i++;
            j--;
            int subLength = j-i+1;
            if(subLength>maxLength){
                maxLength = subLength;
                 s = i;
                 e = j;
               // longestPalindrome = subString(A,s,e);
            }
        }

        for(int c=0; c<n ;c++){ //for even palindrome
            int i = c;
            int j = c+1;
            while(i>=0 && j<n){
                if(A.charAt(i) != A.charAt(j)){
                    break;
                }
                i--;
                j++;
            }
            i++;
            j--;
            
            int subLength = j-i+1;
            if(subLength>maxLength){
                maxLength = subLength;
                 s = i;
                 e = j;
              //  longestPalindrome = subString(A,s,e);
            }
        }
        longestPalindrome = subString(A, s, e);

        return longestPalindrome;
    }
}
