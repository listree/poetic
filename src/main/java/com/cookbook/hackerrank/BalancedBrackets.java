package com.cookbook.hackerrank;

import java.util.*;

/**
 * Created by poet on 7/25/16.
 */
public class BalancedBrackets {

    /**
     * 3
     * {[()]}
     * {[(])}
     * {{[[(())]]}}
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            System.out.println(isBalanced(s) ? "YES":"NO");
        }

    }

    // Double Brace Initialization
    static HashMap<Character, Character> map = new HashMap<Character, Character>() {{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};

    public static boolean isBalanced(String string) {

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0 ; i < string.length(); i++ ) {
            Character cur = string.charAt(i);
            if( map.containsValue(cur) ) {
                stack.push(cur);
            } else {
                Character c = stack.peek();
                if( c.equals( map.get(cur) ) ) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.empty();

    }


}
