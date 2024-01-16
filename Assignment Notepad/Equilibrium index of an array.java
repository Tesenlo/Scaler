//Q2. Equilibrium index of an array
//Problem Description
//You are given an array A of integers of size N.

//Your task is to find the equilibrium index of the given array

//The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

//If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

//Note:

//Array indexing starts from 0.
//If there is no equilibrium index then return -1.
//If there are more than one equilibrium indexes then return the minimum index.

public class Solution {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> pf = new ArrayList<Integer>();
        pf.add(A.get(0));
        for(int i=1; i<A.size(); i++){
            pf.add(pf.get(i-1)+A.get(i));
        }
        int ans = -1;
        int N = A.size();
       
        for(int i=0; i<A.size(); i++){
            int sumL = 0;
            int sumH = 0;

            if(i==0){
                sumL = 0;
                sumH = pf.get(N-1)-pf.get(i);
            }else if(i==N-1){
                sumL = pf.get(i-1);
                sumH = 0;
            }else{
                sumL = pf.get(i-1);
                sumH = pf.get(N-1)-pf.get(i);
            }

            if(sumL == sumH){
                return i;
            }
        }
        return ans;
    }
}
