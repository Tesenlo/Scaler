// Problem Description
// Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
// You may assume that the array is non-empty and the majority element always exists in the array.

// Problem Constraints
// 1 <= N <= 5*105
// 1 <= num[i] <= 109


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        // Observation:{
        //     1. i: 0 -> n-1;
            
        // }

        int n = A.size();
        int majorElement = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            if(count == 0){
                majorElement = A.get(i);
                count++;
            }else{
                if(majorElement == A.get(i)){
                    count++;
                }else{
                    count--;
                }
            }
        }


        //majority Element exsist as per question, therefore no need to do this part
        // int freq = 0;
        // for(int i=0; i<n; i++){
        //     if(A.get(i)==majorElement){
        //         freq++;
        //     }
        // }

        // if(freq > n/2){
        //     return majorElement;
        // }

        // return 0;

        return majorElement;
    }
}
