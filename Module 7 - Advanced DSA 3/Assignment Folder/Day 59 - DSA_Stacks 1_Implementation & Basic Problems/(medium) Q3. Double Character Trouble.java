Problem Description
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is string A.

Output Format
Return the final string.

public class Solution {
    public String solve(String A) {
        int n = A.length();

        Stack<Character> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            char c = A.charAt(i);
            if(stack.size() != 0){
                char top = stack.peek();
                if(c == top){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i=1; i<=size; i++){
            char pop = stack.pop();
            sb = sb.append(pop);
        }


        return sb.toString();
    }
}
