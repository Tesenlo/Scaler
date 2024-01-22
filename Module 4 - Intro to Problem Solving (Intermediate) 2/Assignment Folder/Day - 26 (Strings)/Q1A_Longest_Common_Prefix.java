// Problem Description
// Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
// The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
// Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

// Problem Constraints
// 0 <= sum of length of all strings <= 1000000

public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        int n = A.size();

        if(n == 0){
            return "";
        }else if(n == 1){
            return A.get(0);
        }

        int min_size = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int curr_size = A.get(i).length();
            min_size = Math.min(min_size, curr_size);
        }

        int min_Count = Integer.MAX_VALUE;
        int flag = 0;
        for(int i=1; i<n; i++){
            int curr_count = 0;
            String prev_String = A.get(i-1);
            String curr_String = A.get(i);

            for(int j=0; j<min_size; j++){
                if(prev_String.charAt(j) == curr_String.charAt(j)){
                    curr_count++;
                }
                else{
                  //  flag = 1;
                    break;
                }
            }
            // if(flag == 1){
            //     break;
            // }

            min_Count = Math.min(min_Count, curr_count);
        }

        if(min_Count == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<min_Count; i++){
            sb.append(A.get(0).charAt(i));
        }

        String ans = sb.toString();

        return ans;

    }
}
