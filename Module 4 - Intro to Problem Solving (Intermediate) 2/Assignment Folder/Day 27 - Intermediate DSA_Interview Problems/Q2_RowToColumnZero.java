// Problem Description
// You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

// Problem Constraints
// 1 <= A.size() <= 103
// 1 <= A[i].size() <= 103
// 0 <= A[i][j] <= 103

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();

        for(int i=0; i<row; i++){
            int flag = 0;
            for(int j=0; j<col; j++){
                if(A.get(i).get(j)==0){
                    flag = 1;
                }
            }
            if(flag==1){
                for(int j=0; j<col; j++){
                    if(A.get(i).get(j)>0){
                        int neg = (A.get(i).get(j))*-1;
                        A.get(i).set(j,neg);
                    }
                }
            }
        }

        for(int i=0; i<col; i++){
            int flag = 0;
            for(int j=0; j<row; j++){
                if(A.get(j).get(i)==0){
                    flag = 1;
                }
            }
            if(flag==1){
                for(int j=0; j<row; j++){
                    if(A.get(j).get(i)>0){
                        int neg = (A.get(j).get(i))*-1;
                        A.get(j).set(i,neg);
                    }
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(A.get(i).get(j)<0){
                    A.get(i).set(j,0);
                }
            }
        }

        return A;
    }
}


