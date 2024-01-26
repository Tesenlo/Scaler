// Problem Description
// Given a number A, find if it is COLORFUL number or not.
// If number A is a COLORFUL number return 1 else, return 0.

// What is a COLORFUL Number:
// A number can be broken into different consecutive sequence of digits. 
// The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245. 
// This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

// Problem Constraints
// 1 <= A <= 2 * 109

public class Solution {

    public static ArrayList<Integer> reverse(ArrayList<Integer> arr){      
        int n = arr.size();
        int start = 0;
        int end = n-1;
        while(start<end){
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
        return arr;
    }

    public int colorful(int A) {                                //TC = O((log10 A)^2) i.e O(n^2)
        ArrayList<Integer> digits = new ArrayList<>();          //SC = O((log10 A)^2) i.e O(n^2)
        HashSet<Integer> products = new HashSet<>();

        int number = A;
        while(number>0){
            digits.add(number%10);
            number = number/10;
        }

        digits = reverse(digits);
        int n = digits.size();

        for(int i=0; i<n; i++){
            int prod = 1;
            for(int j=i; j<n; j++){
                prod *= digits.get(j);
                
                if(products.contains(prod)){
                    return 0;
                }else{
                    products.add(prod);
                }
            }
        }

        return 1;


    }
}
