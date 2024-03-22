Problem Description
Given a sorted array of integers A of size N and an integer B, 
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {

        int n = A.size();
        if(n == 1){
            if(A.get(0) == B){
                return 0;
            }else{
                return -1;
            }
        }

        int target = B;

        int L = 0;
        int R = n-1;
        if(A.get(L)<A.get(R)){
           
            while(L<=R){
                int mid = L+(R-L)/2;
                if(A.get(mid) == B){
                    return mid;
                }else  if(A.get(mid)<B){ //move right
                    L = mid+1;
                }else{                  //move left
                    R = mid-1;
                }
            }
            return -1;
        }

        while(L<=R){
            int mid = L+(R-L)/2;
            
            if(A.get(mid) == target){
                return mid;
            }else if(target>=A.get(0)){ //target in part 1
                if(A.get(mid)<A.get(0)){ //mid in part 2
                    R = mid-1;
                }else{          //mid in part 1
                    if(A.get(mid)<target){
                        L = mid+1;      //move to right
                    }else{              //move to left
                        R = mid-1;
                    }
                }
            }else{      //target in part 2
                if(A.get(mid)>=A.get(0)){ //mid in part 1
                    L = mid+1;
                }else{      //mid in part 2
                    if(A.get(mid)<target){ //move right
                        L = mid+1;
                    }else{
                        R = mid-1;
                    }
                }
            }
        }

        return -1;
    }
}


