//Problem Description
//Given an array, arr[] of size N, the task is to find the count of array 
//indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

public class Solution {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> pfe = new ArrayList<Integer>(); //even prefix sum array
        ArrayList<Integer> pfo = new ArrayList<Integer>(); //odd prefix sum array
        int count = 0;     //sprecial index count
        pfe.add(A.get(0)); 
        pfo.add(0);
        for(int i=1; i<A.size(); i++){
            if(i%2==0){
                pfe.add(pfe.get(i-1)+A.get(i));
                pfo.add(pfo.get(i-1));
            }else{
                pfo.add(pfo.get(i-1)+A.get(i));
                pfe.add(pfe.get(i-1));
            }
        }
        int N = A.size();
        for(int j=0; j<A.size(); j++){
        
            int sumE = 0;
            int sumO = 0;
            if(j==0){
                sumE = pfo.get(N-1)-pfo.get(j);
                sumO = pfe.get(N-1)-pfe.get(j);
            }else{
                sumE = pfe.get(j-1)+pfo.get(N-1)-pfo.get(j);
                sumO = pfo.get(j-1)+pfe.get(N-1)-pfe.get(j);
            }

            if(sumE == sumO){
                count++;
            }
        }
        return count;
    }
}


