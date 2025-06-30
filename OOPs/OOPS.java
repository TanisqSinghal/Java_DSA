public class OOPS {
    public static void main(String args[]) {
        Pen p1 = new Pen();
        p1.setColor("blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.Tip);
        p1.setColor("Yellow");
        System.out.println(p1.color);
    }
}

class Pen {
    String color;
    int Tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        Tip = newTip;
    }
}

class Student  {
    String name;
    int age;

    void changeName(String newName) {
        name = newName;
    }
}