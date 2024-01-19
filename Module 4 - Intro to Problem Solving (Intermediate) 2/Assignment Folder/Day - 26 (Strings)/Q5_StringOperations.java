// Problem Description
// Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

// Concatenate the string with itself.
// Delete all the uppercase letters.
// Replace each vowel with '#'.
// You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

// NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

// Problem Constraints
// 1<=N<=100000

public class Solution {
    public String solve(String A) {
        int n = A.length();

        A = A+A;
        A = A.replaceAll("([A-Z])", "");
        A = A.replaceAll("([a,e,i,o,u])", "#");
        return A;
    }
}
