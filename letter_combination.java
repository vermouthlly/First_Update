import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * letter_combination
 */
public class letter_combination {

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();

        if(digits == null || digits.length()==0) {
            return answer;
        }
        
        Map<String, char[]> code = new HashMap<>();
        code.put("2", "abc".toCharArray());
        code.put("3", "def".toCharArray());
        code.put("4", "ghi".toCharArray());
        code.put("5", "jkl".toCharArray());
        code.put("6", "mno".toCharArray());
        code.put("7", "pqrs".toCharArray());
        code.put("8", "tuv".toCharArray());
        code.put("9", "wxyz".toCharArray());

        answer.add("");
        for(int i = 0; i < digits.length(); i++) {
            answer = deliver(answer, code.get(digits.substring(i, i + 1)));
        }
        return answer;
    }

    private static List<String> deliver(List<String> l,char[] arr) {
        List<String> temp = new ArrayList<String>();
        for(String s : l) {
            for(char t : arr) {
                temp.add(s + t);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String a = "234";
        System.out.println(letterCombinations(a));
    }
}