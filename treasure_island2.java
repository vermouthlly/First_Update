import java.util.*;

public class treasure_island2 {
    public static int find(char[][] map) {
        if(map == null || map.length == 0) {
            return 0;
        }

        int len = map.length;
        int wid = map[0].length;
        
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        Queue<Coord> journey = new LinkedList<>();
        for(int a = 0; a < len; a++) {
            for(int b = 0; b < wid; b++) {
                if(map[a][b] == 'S') {
                    journey.add(new Coord(a, b));
                    map[a][b] = 'D';
                }
            }
        }

        while(!journey.isEmpty()) {
            int size = journey.size();
            for(int j = 0; j < size; j++) {
                Coord cur = journey.poll();
                if(map[cur.x][cur.y] == 'X') {
                    return step;
                }else {
                    map[cur.x][cur.y] = 'D';
                }

                for(int i = 0; i < 4; i++) {
                    int newX = cur.x + direc[i][0];
                    int newY = cur.y + direc[i][1];
                    if(newX > -1 && newY > -1 && newX < len && newY < wid && map[newX][newY] != 'D') {
                        journey.add(new Coord(newX, newY));
                    }
                }
            }
            
            step++;

        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
			{'S', 'O', 'O', 'S', 'S'},
            {'D', 'O', 'D', 'O', 'D'},
            {'O', 'O', 'O', 'O', 'O'},
            {'O', 'D', 'D', 'O', 'O'},
            {'X', 'D', 'D', 'D', 'X'}
	    };
	    int result = find(island);
	    System.out.println(result);
    }
}