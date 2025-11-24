import java.util.*;

public class EmployeeApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    dao.addEmployee(new Employee(name, age, salary));
                    break;

                case 2:
                    System.out.println("\n--- All Employees ---");
                    for (Employee e : dao.getAllEmployees()) {
                        System.out.println(
                                e.getId() + " | " +
                                        e.getName() + " | " +
                                        e.getAge() + " | " +
                                        e.getSalary()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int idU = sc.nextInt();

                    System.out.print("New name: ");
                    String newName = sc.next();

                    System.out.print("New age: ");
                    int newAge = sc.nextInt();

                    System.out.print("New salary: ");
                    double newSalary = sc.nextDouble();

                    dao.updateEmployee(new Employee(idU, newName, newAge, newSalary));
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int idD = sc.nextInt();
                    dao.deleteEmployee(idD);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
