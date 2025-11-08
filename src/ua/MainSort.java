package ua;

import ua.model.Product;
import ua.util.GroupRepository;
import ua.util.StudentRepository;

import java.time.LocalDate;

public class MainSort {
    public static void main(String[] args) {
        System.out.println("=== demonstration ===\n");

        StudentRepository studentRepo = new StudentRepository();
        GroupRepository groupRepo = new GroupRepository();

        studentRepo.add(new Product("Ivan", 90, 5, LocalDate.of(2025, 1, 5)));
        studentRepo.add(new Product("Petro", 75, 8, LocalDate.of(2025, 2, 1)));
        studentRepo.add(new Product("Oksana", 100, 3, LocalDate.of(2025, 3, 1)));

        System.out.println("\n Студенти за іменем:");
        studentRepo.sortByName().forEach(System.out::println);

        System.out.println("\n Студенти за оцінками (price):");
        studentRepo.sortByPrice().forEach(System.out::println);

        System.out.println("\n Студенти за датою:");
        studentRepo.sortByDate().forEach(System.out::println);

        groupRepo.add(new Product("Group A", 200, 10, LocalDate.of(2025, 1, 10)));
        groupRepo.add(new Product("Group B", 150, 15, LocalDate.of(2025, 2, 20)));
        groupRepo.add(new Product("Group C", 300, 8, LocalDate.of(2025, 3, 15)));

        System.out.println("\n Групи за stock (кількість студентів):");
        groupRepo.sortByStock().forEach(System.out::println);

        System.out.println("\n Групи за датою (спадання):");
        groupRepo.sortByDateDesc().forEach(System.out::println);

        System.out.println("\n Групи за identity (asc):");
        groupRepo.sortByIdentityAsc().forEach(System.out::println);
    }
}