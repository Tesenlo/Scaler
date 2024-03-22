Problem Description
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.

Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.


public class Solution {
    public int paint(int A, int B, ArrayList<Integer> C) {

        int n = C.size();
        int mod = 10000003;
        
        //A -> no of painters
        //B -> time taken to paint 1 unit of board;
        long L = Integer.MIN_VALUE;
        long R = 0;
        for(int i=0; i<n; i++){
            L = Math.max(L, C.get(i));
            R += C.get(i);
        }

        //worst case
        long ans = R;

        //if only 1 board
        if(n == 1){
            ans = C.get(0)*B;
            return (int)(ans%mod);
        }

        //if only 1 painter
        if(A == 1){
            return (int)((ans*B)%mod);
        }

        while(L<=R){
            long mid = L + (R-L)/2;
            if(completeWork(C, A, n, mid)){
                //if work can be completed, move left ie. find min time - utilise all works and try to reduce time
                ans = mid;
                R = mid - 1;
            }else{
                //work cannot be completed, increase time for all workers
                L = mid + 1;
            }
        }
       return (int)((ans*B)%mod);
    }
    
    public static boolean completeWork(ArrayList<Integer> C, int A, int n, long mid){
        //initailse the workers, we start with 1 workers
        int w = 1;

        //intialise effort by the worker as zero
        long sum = 0;

        for(int i=0; i<n; i++){
            if(sum <= mid){       //if effort has not reached the limit 'mid'
                sum += C.get(i);
                if(sum>mid){      //if effort has reached limit for this worker, then use next worker
                    w++;
                    sum = C.get(i); //new worker has taken this effort
                    if(w>A){    //if we exceed the number of worker to complete the work, then return false
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
