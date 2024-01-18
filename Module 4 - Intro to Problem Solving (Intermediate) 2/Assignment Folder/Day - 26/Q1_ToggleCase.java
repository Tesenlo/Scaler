// Problem Description
// You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
// You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

public class Solution {

    public static char toggle(char ch){
        if(ch>='A' && ch<='Z'){
            ch = (char) (ch+32);
        }else{
            ch = (char) (ch-32);
        }
        return ch;
    }
  
    public String solve(String A) {
        int n = A.length();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++){
            ans.append(toggle(A.charAt(i)));
        }
        String str = ans.toString();
        return str;
    }
}

