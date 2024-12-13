import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Subject> subjects;
    private String grade;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.subjects = builder.subjects;
        this.grade = calculateGrade();
    }

    private String calculateGrade() {
        int totalScore = subjects.stream().mapToInt(Subject::getScore).sum();
        double average = (double) totalScore / subjects.size();
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public void displayReportCard() {
        System.out.println("\n=== Report Card ===");
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println("  " + subject.getName() + ": " + subject.getScore());
        }
        System.out.println("Grade: " + grade);
    }

    public static class StudentBuilder {
        private String id;
        private String name;
        private List<Subject> subjects = new ArrayList<>();

        public StudentBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder addSubject(String subjectName, int score) {
            this.subjects.add(new Subject(subjectName, score));
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
