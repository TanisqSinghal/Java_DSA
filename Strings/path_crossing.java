import java.util.HashSet;
import java.util.Set;

public class path_crossing {
    //leetcode - 1496
    public boolean isPathCrossing(String str) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        visited.add(x + "," + y);

        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);
            if (dir == 'W') {
                x--;
            } else if (dir == 'E') {
                x++;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            }
            String pos = x + "," + y;
            if (visited.contains(pos)) {
                return true;
            }
            visited.add(pos);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
