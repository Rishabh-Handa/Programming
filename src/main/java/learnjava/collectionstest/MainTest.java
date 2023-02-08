package learnjava.collectionstest;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        char[] chars = "abcdab".toCharArray();

        for(char ch: chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if(value == 1) {
                System.out.println(key);
            }
        }


        List<Employee> players = Arrays.asList(new Employee("Sachin"), new Employee("Sourav"), new Employee("Sehwag"),
                new Employee("Dravid"));
        List<Employee> names = new ArrayList<>();
        names.addAll(players);

        System.out.println("Players" + players);
        System.out.println("Names" + names);

        names.get(2).name = "NewName";
        names.remove(3);
        System.out.println("*********");
        System.out.println("Players" + players);
        System.out.println("Names" + names);

        List<Employee> employees = Arrays.asList(new Employee("A", "D1", 21),
                new Employee("B", "D1", 31),
                new Employee("C", "D2", 21),
                new Employee("D", "D2", 11));

        Map<String, Optional<Employee>> depatmentWise = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(e -> e.salary)))));

        Map<String, List<Employee>> depatmentWise2 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));

        System.out.println(depatmentWise);
        System.out.println(depatmentWise2);

    }

    private static class Employee {
        String name;
        String department;
        int salary;

        Employee(String name) {
            this.name = name;
        }

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
