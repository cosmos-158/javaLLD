class Students {
    int rollNo;
    String name;

    public Students(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + " Roll No: " + rollNo;
    }

}

class Children{
    int count = 3;
    public void count(){
        System.out.println("Counting....");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Students topper = new Students(10, "Ashu");
        System.out.println(topper);
        Students st[] = new Students[3];
        st[0] = new Students(8, "Ashish");
        st[1] = new Students(1, "Inder");
        st[2] = new Students(3, "Utkarsh");

        for (Students s : st) {
            System.out.println(s);
        }

        Children ch = new Children();
        System.out.println(ch.count);
        ch.count = 4;
        System.out.println(ch.count);

    }
}
