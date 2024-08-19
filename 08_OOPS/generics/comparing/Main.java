public class Main {

    public static void main(String[] args) {
        Student kunal = new Student(12, 76.3f);
        Student rahul = new Student(4, 99.3f);

        if (kunal.compareTo(rahul) < 0) {
            System.out.println("rahul has more marks");
        }
    }
}
