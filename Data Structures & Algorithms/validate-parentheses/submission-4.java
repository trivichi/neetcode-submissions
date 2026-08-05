class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '[' || c=='{'|| c=='('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) {
                    return false;
                }
                if(c==']'&& stack.peek()=='['){
                    stack.pop();
                }
                else if(c=='}'&& stack.peek()=='{'){
                    stack.pop();
                }
                else if(c==')'&& stack.peek()=='('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
