import java.util.HashSet;

/**
 * town_judge
 */
public class town_judge {

    public static int findJudge(int N, int[][] trust) {
        HashSet<Integer> town = new HashSet<>();
        HashSet<Integer> vote = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            town.add(i);
        }
        for(int i = 0; i < trust.length; i++) {
            town.remove(trust[i][0]);
        }
        if(town.size() != 1) {
            return -1;
        }
        for(int i = 0; i < trust.length; i++) {
            if(town.contains(trust[i][1])) {
                vote.add(i);
            }
        }
        if(vote.size() != N - 1) {
            return -1;
        }else {
            for(Integer i : town) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(4, trust));
    }
}