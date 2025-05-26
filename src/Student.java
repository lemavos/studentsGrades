import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Student {
    String name;
    double grade1, grade2, grade3, grade4;

    public Student(String name, double grade1, double grade2, double grade3, double grade4) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.grade4 = grade4;
    }

    public double average() {
        return (grade1 + grade2 + grade3 + grade4) / 4;
    }

    public String getStatus() {
        double media = average();
        if (media >= 7) {
            return "Passed!";
        } else if (media >= 5) {
            return "Academic Recovery!";
        } else {
            return "Failed!";
        }
    }

    public static void calculateMedia(Scanner input) {
        System.out.print("|  Student Name: ");
        String name = input.nextLine();

        System.out.print("|  Grade 1: ");
        double grade1 = input.nextDouble();

        System.out.print("|  Grade 2: ");
        double grade2 = input.nextDouble();

        System.out.print("|  Grade 3: ");
        double grade3 = input.nextDouble();

        System.out.print("|  Grade 4: ");
        double grade4 = input.nextDouble();
        input.nextLine();

        Student student = new Student(name, grade1, grade2, grade3, grade4);

        try (FileWriter writer = new FileWriter("student.json")) {
            Gson gson = new Gson();
            gson.toJson(student, writer);
            System.out.println("Saved!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        double media = student.average();
        String status = student.getStatus();

        System.out.println("|");
        System.out.println("|  Student: " + name);
        System.out.println("|  Media: " + String.format("%.2f", media));
        System.out.println("|  Status: " + status);
        System.out.println();
        System.out.println("[!] Press enter to continue\n\n");
        input.nextLine();
    }
}
