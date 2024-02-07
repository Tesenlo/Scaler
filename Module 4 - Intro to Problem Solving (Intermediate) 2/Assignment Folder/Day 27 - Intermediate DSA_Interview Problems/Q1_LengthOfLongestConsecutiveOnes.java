// Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.

// Input Format
// The only argument given is string A.
  
// Output Format
// Return the length of the longest consecutive 1’s that can be achieved.
  
// Constraints
// 1 <= length of string <= 1000000
// A contains only characters 0 and 1.

public class Solution {
    public int solve(String A) {
        // Observation:{
        //     1. find count of total 1s in string.
        //     2. check if count of total 1s == length of string, if true, return the string;
        //     3. for each 0, check count of left and right continuos 1s and add them. if == total 1s of string, return total 1s of string';
        //     4. if not equal, +1 to L+R count;
        //     5. maintain max count;
        // }
        int n = A.length();
        int totalCount = 0;

        for(int i=0; i<n; i++){ //total count of 1s in String
            if(A.charAt(i)=='1'){
                totalCount++;
            }
        }

        if(totalCount == n){
            return totalCount;
        }

        if(totalCount == 0){
            return 0;
        }

        int maxCount = 0;
        for(int j=0; j<n; j++){
            if(A.charAt(j)=='0'){
                int Left = j-1;
                int Right = j+1;
                int LeftCount = 0;
                int RightCount = 0;
                int total = 0;

                while(Left>=0 && A.charAt(Left)=='1'){
                    LeftCount++;
                    Left--;
                }
                while(Right<n && A.charAt(Right)=='1'){
                    RightCount++;
                    Right++;
                }

                if(LeftCount+RightCount == totalCount){
                    total = LeftCount+RightCount;
                }else{
                    total = LeftCount+RightCount+1;
                }

                maxCount = Math.max(maxCount, total);
            }
            
        }

        return maxCount;
    }
}

