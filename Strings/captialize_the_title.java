public class captialize_the_title {

    public static String capitalizeTitle(String str) {
        StringBuilder sb = new StringBuilder("");
        String[] words = str.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.length() <= 2) {
                sb.append(word);
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1));
            }
            if(i < words.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "jwdjc kjckjbc kjenckjn";
        System.out.println(capitalizeTitle(str));
    }
}
