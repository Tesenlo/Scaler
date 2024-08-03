Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

public class Solution {
    public int solve(String A) {
        int n = A.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){
            char c = A.charAt(i);
            //if c is an opening paranthesis
            if(c == '{' 
            || c == '[' 
            || c == '('){
                stack.push(c);
            }else{
                // if c is a closing paranthesis
                //1st check if stack is empty
                if(stack.size() == 0){
                    //if stack is empty then we do not have an opening backet to compare with. Therefore string is invalid
                    return 0;
                }
                //if stack is not empty, pop the top element and compare
                int opening = (int)stack.pop();
                //ex: '(' == 28 and ')' == 29
                //if not equal, invalid string
                int closing = (int)c;
                if(opening != closing-1
                && opening != closing-2){   //since '{'==123 and '}'==125
                    return 0;
                }
            }
        }

        //at the end, if the stack is not empty then also invalid string
            //because if it was a valid string, the paranthesis pairs will match and empty the string
            if(stack.size() != 0){
                return 0;
            }

            return 1;
    }
}
