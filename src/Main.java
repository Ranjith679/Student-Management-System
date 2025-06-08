import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hi welcome to Student Management System");
        Scanner sc = new Scanner(System.in);
        while(true) {

            System.out.println("Choose Operation \n 1. View all student records \n 2. insert new student \n 3.Update student record \n 4.Delete student \n 5.Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    Student.viewAllStudents();
                    break;
                case 2:
                    System.out.println("Enter student details of name , age and marks");
                    String name = sc.next();
                    int age = sc.nextInt();
                    int marks = sc.nextInt();

                    Student s1 = new Student(0, name, age, marks);
                    if (Student.addNewStudent(s1)) {
                        System.out.println("1 rows affected insertion successful");
                    }
                    break;
                case 3:
                    System.out.println("Enter record details with Student id");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    String updateName = sc.nextLine();
                    int updateAge = sc.nextInt();
                    sc.nextLine();
                    int updateMarks = sc.nextInt();
                    Student updateStudent = new Student(updateId, updateName, updateAge, updateMarks);
                    Student.updateStudent(updateStudent);
                    break;
                case 4:
                    System.out.println("Enter student id for deletion");
                    int deleteId = sc.nextInt();
                    Student.deleteStudent(deleteId);
                    break;
            }
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            if(option == 5) {
                System.out.println("Thank you");
                break;
            }
            }
        }
    }
