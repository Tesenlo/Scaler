Problem Description
Given N non-negative integers A[0], A[1], ..., A[N-1] , where each represents a point at coordinate (i, A[i]).
N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water. You need to return this maximum area.
Note: You may not slant the container. It is guaranteed that the answer will fit in integer limits.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 105

Input Format
Single Argument representing a 1-D array A.

Output Format
Return single Integer denoting the maximum area you can obtain.

public class Solution {
    public int maxArea(ArrayList<Integer> A) { //contains height of the wall
        int n = A.size();
        int water = 0;

        if(n == 1){    // no water can be stored
            return water;
        }

        int i = 0;   //left most wall
        int j = n-1; //right most wall

        while(i<j){
            water = Math.max(water, Math.min(A.get(i), A.get(j))*(j-i));

            if(A.get(i)<A.get(j)){
                i++;
            }else if(A.get(i)>A.get(j)){
                j--;
            }else{
                i++; //if both equal, move anyone
            }
        }

        return water;
    }
}
