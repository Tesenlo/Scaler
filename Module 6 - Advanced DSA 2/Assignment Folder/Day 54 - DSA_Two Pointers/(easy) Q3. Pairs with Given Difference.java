Problem Description
Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

Problem Constraints
1 <= N <= 104
0 <= A[i], B <= 105

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an integer B.

Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(n == 1){
            return 0;
        }
        Collections.sort(A);

        int i=0;
        int j=1;
        int count = 0;
        while(j<n){

            int x = A.get(i);
            int y = A.get(j);
            int diff = y-x;

            if(diff == B){
                //count only once
               count++;
               while(i<n-1 && A.get(i) == x){
                   i++;
               } 
              
               while(j<n-1 && A.get(j) == y){
                   j++;
               }   
            }else if(diff>B){
                i++;
            }else{
                j++;
            }

            if(i==j){
                j++;
            }
        }

        return count;
    }
}
