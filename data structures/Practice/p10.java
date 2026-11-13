class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    void printResult() {
        double avg = calculateAverage();
        char grade;
        if (avg >= 90) grade = 'A';
        else if (avg >= 75) grade = 'B';
        else if (avg >= 60) grade = 'C';
        else if (avg >= 40) grade = 'D';
        else grade = 'F';

        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }

    public static void main(String[] args) {
        new Student("Asha", new int[]{80, 90, 70}).printResult();
        new Student("Ravi", new int[]{60, 55, 50}).printResult();
    }
}
