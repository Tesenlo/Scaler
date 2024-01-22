// You are given a string S, and you have to find all the amazing substrings of S.
// An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

// Input
// Only argument given is string S.
  
// Output
// Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
// Constraints

// 1 <= length(S) <= 1e6
// S can have special characters

public class Solution {
    public int solve(String A) {
        long n = A.length();
        ArrayList<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a','e','i','o','u','A','E','I','O','U');
        long amazing_count = 0;

        for(int i=0; i<n; i++){
            char curr_char = A.charAt(i);
            if(
                vowels.contains(curr_char)
            ){
                long sub_length = (n-1)-i+1;
                amazing_count += sub_length;
            }
        }

        long ans = amazing_count%10003;
        int ass = (int)ans;
        return ass;
    }
}
