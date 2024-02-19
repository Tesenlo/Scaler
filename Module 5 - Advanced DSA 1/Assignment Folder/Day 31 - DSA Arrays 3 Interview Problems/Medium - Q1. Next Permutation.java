public class Solution {

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> A, int start, int end){
        while(start<end){
            int temp = A.get(end);
            A.set(end, A.get(start));
            A.set(start, temp);
            start++;
            end--;
            
        }
        return A;
    }

    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();
        if(n==1){
            return A;
        }
        int desc_flag = 0;
        int asc_flag = 0;

        //considering array to be in descending order
        for(int j=1; j<n; j++){
            if(A.get(j)>A.get(j-1)){// not descending
                desc_flag = 1;
            }
        }
        
        if(desc_flag==0){ //if in descending order
            return reverseArray(A, 0, n-1);
        }
        
        //considering array to be in ascending order
        for(int j=1; j<n; j++){
           if(A.get(j)<A.get(j-1)){ //not ascending
               asc_flag = 1;
           }
        }
        if(asc_flag==0){ //if in ascending order, swap last 2 elements
            int temp = A.get(n-1);
            A.set(n-1, A.get(n-2));
            A.set(n-2, temp);
            return A;
        }

        int index = 0;
        for(int i = n-1; i>0; i--){ //find dipping point
            if(A.get(i-1)<A.get(i)){
                index = i-1;
                break;
            }
        }

        for(int j=n-1; j>=index; j--){
               if(A.get(j)>A.get(index)){ //swap with the number that is just greater than dipping point
                   int temp = A.get(j);
                   A.set(j, A.get(index));
                   A.set(index, temp);
                   break;
               }
            }

            
        return reverseArray(A, index+1, n-1 ); //make all elements after dipping point in ascending order to get the next largest permutation

    }
}
