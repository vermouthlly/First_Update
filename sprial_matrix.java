import java.util.*;

public class sprial_matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return answer;
        }
        int len = matrix.length;
        int wid = matrix[0].length;
        
        int a1 = 0;
        int b1 = 0;
        int a2 = len - 1;
        int b2 = wid - 1;
        while(answer.size() < len * wid) {
            for(int m = b1; m <= b2 && answer.size() < len * wid; m++) {
                answer.add(matrix[a1][m]);
            }
            for(int m = a1 + 1; m <= a2 && answer.size() < len * wid; m++) {
                answer.add(matrix[m][b2]);
            }
            for(int m = b2 - 1; m >= b1 && answer.size() < len * wid; m--) {
                answer.add(matrix[a2][m]);
            }
            for(int m = a2 - 1; m > a1 && answer.size() < len * wid; m--) {
                answer.add(matrix[m][b1]);
            }
            a1++;
            b1++;
            b2--;
            a2--;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] num = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}
                      };
        System.out.println(spiralOrder(num));
    }
}