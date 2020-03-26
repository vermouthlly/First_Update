import java.util.Stack;

/**
 * valid_parentheses
 */
public class valid_parentheses {

    public static boolean isValid(String s) {
        Stack<Character> room = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                room.push(s.charAt(i));
            } else if(room.empty()) {
                return false;
            }else if(s.charAt(i) == ')') {
                if(room.contains('(')) {
                    room.pop();
                }else
                    return false;
            } else if(s.charAt(i) == ']') {
                if(room.contains('[')) {
                    room.pop();
                }else 
                    return false;
            } else if(s.charAt(i) == '}') {
                if(room.contains('{')) {
                    room.pop();
                }else 
                    return false;
            }
        }
        return room.empty() ? true:false;
    }

    public static void main(String[] args) {
        String s = "()[]]";
        System.out.println(isValid(s));
    }
}