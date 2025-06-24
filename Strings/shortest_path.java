public class shortest_path {

    public static float shorttestPath(String str) {
        int x = 0, y = 0;
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
        }
        float displacement = (float) Math.sqrt((x * x) + (y * y));
        return displacement;
    }

    public static void main(String args[]) {
        String str = "WNEENESENNN";
        System.out.println(shorttestPath(str));
    }
}
