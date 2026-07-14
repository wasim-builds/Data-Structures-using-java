package OOps;
//21mis7125
class Employee {
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee emp = (Employee) obj;
        return empId == emp.empId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(empId);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "John", 50000);
        Employee e2 = new Employee(101, "John", 50000);

        System.out.println(e1);
        System.out.println(e2);

        System.out.println("Are employees equal? " + e1.equals(e2));
        System.out.println("HashCodes: " + e1.hashCode() + ", " + e2.hashCode());
    }
}
