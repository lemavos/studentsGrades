import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Student {
    private String name;
    private double grade1, grade2, grade3, grade4;

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

    public String getName() {
        return name;
    }

    public double getGrade1() {
        return grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public double getGrade4() {
        return grade4;
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

        try {
            File file = new File("student.json");
            List<Student> students = new ArrayList<>();

            if (file.exists()) {
                try (Reader reader = new FileReader(file)) {
                    students = new Gson().fromJson(reader,
                            new TypeToken<List<Student>>() {}.getType());
                    if (students == null) students = new ArrayList<>();
                }
            }

            students.add(student);

            try (Writer writer = new FileWriter("student.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(students, writer);
                System.out.println("Saved!");
            }

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
        System.out.println("[!] Press enter to continue\n");
        input.nextLine();
    }

    public static void showStudents() {
        try {
            File file = new File("student.json");
            List<Student> students = new ArrayList<>();

            if (file.exists()) {
                try (Reader reader = new FileReader(file)) {
                    students = new Gson().fromJson(reader,
                            new TypeToken<List<Student>>() {}.getType());
                    if (students == null) students = new ArrayList<>();
                }

                for (Student student : students) {
                    System.out.println("Name: " + student.getName());
                    System.out.println("Grade 1: " + student.getGrade1());
                    System.out.println("Grade 2: " + student.getGrade2());
                    System.out.println("Grade 3: " + student.getGrade3());
                    System.out.println("Grade 4: " + student.getGrade4());
                    System.out.println("Media: " + String.format("%.2f", student.average()));
                    System.out.println("Status: " + student.getStatus());
                    System.out.println("-----");
                }

            } else {
                System.out.println("[!] Error: file not founded.");
            }

        } catch (IOException e) {
            System.out.println("[!] Error: reading file: " + e.getMessage());
        }
    }
}
