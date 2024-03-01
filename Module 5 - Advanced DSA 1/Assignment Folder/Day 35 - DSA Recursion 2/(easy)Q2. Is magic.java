// Problem Description
// Given a number A, check if it is a magic number or not.

// A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.

// Problem Constraints
// 1 <= A <= 109

// Input Format
// The first and only argument is an integer A.

// Output Format
// Return an 1 if the given number is magic else return 0.

public class Solution {
    public int solve(int A) {

        if(A==1){
            return 1;
        }else if(A>1 && A<=9){
            return 0;
        }

        int ans = 0;
        while(A>0){
            ans += A%10;
            A = A/10;
        }

        return solve(ans);
    }
}
