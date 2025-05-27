import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char option = 0;
        while (option != '3') {
            System.out.println("|");
            System.out.println("|  [1] Calculate Student Media.");
            System.out.println("|  [2] View All Students Status.");
            System.out.println("|  [3] Exit.");
            System.out.print("|  Choose a option:");
            option = input.next().charAt(0);
            input.nextLine();

            if (option == '1') {
                Student.calculateMedia(input);
            } else if (option == '2') {
                Student.showStudents();
            } else if (option != '3') {
                System.out.println("Invalid Option!");
            }
        }
        input.close();
        System.out.println("| [!] Program Finished With Succesful!");
    }
}