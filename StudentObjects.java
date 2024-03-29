//Bonniebao
import java.util.Scanner;

//Student Class Creation
class Student {
    String name;
    double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentObjects {
//Employ a  object to create an interactive console menu that allows the user to select among the modified sorting algorithms for sorting the students.Scanner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //build the array
        Student[] students = {
                new Student("Tim", 3.1),
                new Student("kim", 2.5),
                new Student("Sam", 3.2),
                new Student("Isa", 3.9),
                new Student("Eve", 4.0)
        };
        //print out the menu for choose the sorting algorithm
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Quick Sort");
        System.out.print("Enter your choice: ");

        //read the choice
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                bubbleSort(students);
                break;
            case 2:
                selectionSort(students);
                break;
            case 3:
                quickSort(students, 0, students.length - 1);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        //print out the sorted list of students 
        System.out.println("Sorted students:");
        for (Student student : students) {
            System.out.println(student.name + " - GPA: " + student.gpa);
        }
    }
    //bubble sort
    public static void bubbleSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].gpa < students[j + 1].gpa) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    // selectionSort
    public static void selectionSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].gpa > students[max_idx].gpa) {
                    max_idx = j;
                }
            }
            Student temp = students[max_idx];
            students[max_idx] = students[i];
            students[i] = temp;
        }
    }
    //quickSort
    public static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);

            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }
    //help method for quick sort 
    public static int partition(Student[] students, int low, int high) {
        double pivot = students[high].gpa;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students[j].gpa > pivot) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1;
    }
}
