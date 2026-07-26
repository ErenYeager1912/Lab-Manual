import java.util.*;
import java.util.stream.Collectors;
class Employee {
    int id;
    String name;
    String dept;
    double salary;
    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}
public class Main {
    public static void main(String[] args) {
        List<Employee> emp = Arrays.asList(
                new Employee(101, "Rahul", "CSE", 55000),
                new Employee(102, "Sneha", "ECE", 62000),
                new Employee(103, "Kiran", "CSE", 48000),
                new Employee(104, "Divya", "MECH", 51000),
                new Employee(105, "Arjun", "ECE", 70000)
        );
        System.out.println("---- All Employees ----");
        for (Employee e : emp) {
            System.out.println(e.id + "\t" + e.name + "\t" + e.dept + "\t" + e.salary);
        }
        System.out.println();
        System.out.println("---- Salary Above 50000 (High to Low) ----");
        emp.stream()
                .filter(e -> e.salary > 50000)
                .sorted((a, b) -> Double.compare(b.salary, a.salary))
                .forEach(e -> System.out.println(e.name + " -> " + e.salary));
        System.out.println();
        System.out.println("---- Employee Names ----");
        System.out.println(
                emp.stream()
                        .map(e -> e.name)
                        .collect(Collectors.toList()));
        System.out.println();
        Map<String, List<String>> group = emp.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        LinkedHashMap::new,
                        Collectors.mapping(e -> e.name, Collectors.toList())
                ));
        System.out.println("---- Employees Grouped by Department ----");
        System.out.println("CSE : " + group.get("CSE"));
        System.out.println("ECE : " + group.get("ECE"));
        System.out.println("MECH : " + group.get("MECH"));
        System.out.println();
        Map<String, Double> avg = emp.stream()
                .collect(Collectors.groupingBy(
                        e -> e.dept,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(e -> e.salary)
                ));
        System.out.println("---- Average Salary per Department ----");
        System.out.printf("CSE : %.2f\n", avg.get("CSE"));
        System.out.printf("ECE : %.2f\n", avg.get("ECE"));
        System.out.printf("MECH : %.2f\n", avg.get("MECH"));
        System.out.println();
        double total = emp.stream().mapToDouble(e -> e.salary).sum();
        long cseCount = emp.stream()
                .filter(e -> e.dept.equals("CSE"))
                .count();
        Employee highest = emp.stream()
                .max(Comparator.comparingDouble(e -> e.salary))
                .get();
        System.out.printf("Total Salary Paid : %.2f\n", total);
        System.out.println("Number of CSE Employees : " + cseCount);
        System.out.println("Highest Paid : " + highest.name + " (" + highest.salary + ")");
    }
}
