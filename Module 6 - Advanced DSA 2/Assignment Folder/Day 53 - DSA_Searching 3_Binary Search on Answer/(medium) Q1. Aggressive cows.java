Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N 
where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. 
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {

        Collections.sort(A);

        int n = A.size();
        if(n == 2){
            return A.get(1)-A.get(0);
        }

        if(B == 2){
            return A.get(n-1)-A.get(0);
        }

        
        int R = A.get(n-1)-A.get(0);
        int L = R;

        for(int i=1; i<n; i++){
            L = Math.min(L, A.get(i)-A.get(i-1));
        }

        //WORST CASE - min distance between 2 cows
        int ans = L;

        while(L<=R){
            int mid = L+(R-L)/2;
            if(checkDistance(A, B, mid, n)){ //if feasible to fit all cows, then increase the distance by going right
                ans = mid;
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        return ans;
    }

    public static boolean checkDistance(ArrayList<Integer> A, int B, int mid, int n){
        int cow = 1;
        int positionOfLastStall = A.get(0);
        for(int i=1; i<n; i++){
            if(A.get(i)-positionOfLastStall>=mid){
                cow++;
                positionOfLastStall = A.get(i); //update position of the cow
                if(cow == B){       //if all cows are accomodated
                   return true;
                }
            }
        }
        return false;
    }
}