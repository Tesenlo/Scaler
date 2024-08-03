Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) 
such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int mod = 1000000007;
        long ans = 0;

        if(n == 1){
            return 0;
        }

        int i = 0;
        int j = n-1;

        while(i<j){
            long sum = A.get(i) + A.get(j);

            if(sum<B){
                i++;
            }else if(sum>B){
                j--;
            }else{

                if(A.get(i).equals(A.get(j))){
                    long length = j-i+1;
                    ans +=  (length*(length-1)/2)%mod;
                    break;               
                }

                int i2 = i; long count1 = 0;
                while(A.get(i).equals(A.get(i2))){
                    i2++;
                    count1++;
                }
                i = i2;

                int j2 = j; long count2 = 0;
                while(A.get(j).equals(A.get(j2))){
                    j2--;
                    count2++;
                }
                j = j2;
                ans += count1*count2;
            }
        }

       // int result = (int)ans%mod;
        return (int)ans%mod;
    }
}
