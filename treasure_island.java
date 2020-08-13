import java.util.*;

class Coord {
    int x;
    int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class treasure_island {
    public static int find(char[][] map) {
        if(map == null || map.length == 0) {
            return 0;
        }
        int len = map.length;
        int wid = map[0].length;

        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;
        Queue<Coord> journey = new LinkedList<>();
        journey.add(new Coord(0,0));

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
			{'O', 'O', 'O', 'O'},
			{'D', 'O', 'D', 'O'},
			{'O', 'O', 'O', 'O'},
            {'0', 'D', 'D', 'O'},
            {'0', 'D', 'X', 'O'}
	    };
	    int result = find(island);
	    System.out.println(result);
    }
}