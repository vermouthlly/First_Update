/**
 * lcs
 */
public class lcs {
 
    public static int getLCS(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        int[][] result = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                    max = Math.max(max, result[i + 1][j + 1]);
                }
            }
        }
        // // ----- print table -----
        // System.out.print(" ");
        // for (int i = 0; i < b.length; i++) {
        //     System.out.print(" " + b[i]); // 打印第一行
        // }
        // System.out.println();
        // for (int i = 1; i < result.length; i++) {
        //     System.out.print(a[i - 1] + " ");
        //     for (int j = 1; j < result[i].length; j++) {
        //         System.out.print(result[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // -----------------------
        return max;
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFG";
        String s2 = "SSSSABZDEFKG";
        System.out.println("LCS：" + getLCS(s1, s2));
    }
}