public class pairing_problem {

    public static int pairPeople(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return pairPeople(n-1) + (n-1)*pairPeople(n-2);
    }

    public static void main(String args[]) {
        System.out.println(pairPeople(4));
    }
}
