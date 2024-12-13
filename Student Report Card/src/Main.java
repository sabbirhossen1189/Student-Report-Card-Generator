import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    UserStore.registerUser(username, password);
                    System.out.println("Registration successful!");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (UserStore.loginUser(username, password)) {
                        System.out.println("Login successful!");

                        // Main functionality after successful login
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.nextLine();

                        System.out.print("Enter Student Name: ");
                        String studentName = scanner.nextLine();

                        Student.StudentBuilder builder = new Student.StudentBuilder()
                                .setId(studentId)
                                .setName(studentName);

                        // Adding subjects
                        while (true) {
                            System.out.print("Enter Subject Name (or type 'done' to finish): ");
                            String subjectName = scanner.nextLine();
                            if ("done".equalsIgnoreCase(subjectName)) {
                                break;
                            }

                            System.out.print("Enter Subject Score: ");
                            int score = scanner.nextInt();
                            scanner.nextLine();

                            builder.addSubject(subjectName, score);
                        }

                        Student student = builder.build();
                        student.displayReportCard();

                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
