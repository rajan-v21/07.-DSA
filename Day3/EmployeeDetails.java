import java.util.*;

class Employee {
    int id;
    static int empid;
    String name;
    String gender;
    double salary;
    Employee next;

    Employee(String name, String gender, double salary) {
        id = ++empid;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        next = null;
    }
}

public class EmployeeDetails {
    Employee root;

    void create_list() {
        root = null;
    }

    void insert_employee(String name, String gender, double salary) {
        Employee n = new Employee(name, gender, salary);
        if (root == null) {
            root = n;
            System.out.println("Employee inserted.");
        } else {
            Employee t = root;
            while (t.next != null)
                t = t.next;

            t.next = n;
            System.out.println("Employee inserted.");
        }
    }

    void search(int key) {
        if (root == null)
            System.out.println("Empty List");
        else {
            Employee t;
            t = root;
            while (t != null && t.id != key) {
                t = t.next;
            }
            if (t == null)
                System.out.println(key + " is not found in the list");
            else {
                System.out.println(key + " is found in the list");
                System.out.print("| [" + t.id + "]" + t.name + " <" + t.gender + ">" + t.salary + "|->");
            }
        }
    }

    void print_list() {
        if (root == null)
            System.out.println("List is empty");
        else {
            Employee t = root;
            System.out.print("List: ");
            while (t != null) {
                System.out.print("| [" + t.id + "]" + t.name + " <" + t.gender + ">" + t.salary + "|->");
                t = t.next;
            }
        }
    }

    void delete_employee(int key) {
        if (root == null)
            System.out.println("Empty List");
        else {
            Employee t, t2;
            t = t2 = root;
            while (t != null && t.id != key) {
                t = t.next;
            }
            if (t == null)
                System.out.println(key + " is not found in the list");
            else {
                if (t == root)
                    root = root.next;
                else if (t.next == null)
                    t.next = null;
                else
                    t2.next = t.next;
                System.out.println("Deleted:" + t.name);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String name, gender;
        double salary;

        EmployeeDetails obj = new EmployeeDetails();

        obj.create_list();

        do {
            System.out.println(
                    "\n1.Insert Employee\n2.Delete Employee\n3.Print Employees List\n4.Search Employee\n0:Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Thank you !!");
                    break;
                case 1:
                    System.out.println("Enter name,gender,salary : ");
                    name = sc.next();
                    gender = sc.next();
                    salary = sc.nextDouble();
                    obj.insert_employee(name, gender, salary);
                    break;
                case 2:
                    System.out.print("Enter the employee id to be deleted : ");
                    int n = sc.nextInt();
                    obj.delete_employee(n);
                    break;

                case 3:
                    obj.print_list();
                    break;

                case 4:
                    System.out.print("Enter id to be searched in the list : ");
                    int id = sc.nextInt();
                    obj.search(id);
                    break;

                default:
                    System.out.println("Wrong choice entered !!");
            }
        } while (choice != 0);
        sc.close();
    }
}