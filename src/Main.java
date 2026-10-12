import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Task1 :List<Integer> verilir. Yalnız cüt ədədləri seç, hər birinin kvadratını al və nəticəni yeni siyahıya yığ.
//        Nümunə: [1, 2, 3, 4, 5, 6] → [4, 16, 36]

//        List<Integer> numbers=List.of(1,2,3,4,5,6,78,9);
//        List<Integer> result=numbers.stream()
//                .filter(n-> n % 2==0)
//                .map(n-> n * n)
//                .toList();
//        System.out.println(result);


//        Task2 :List<String> formatında sözlər verilir. Uzunluğu 3-dən böyük olanları seç,
//         uzunluğa görə azalan sırada düz və ilk 3-nü qaytar. Təkrarlananları çıxar (distinct).

//        List<String> words = List.of("nar", "alma", "aş", "mal", "maşın", "alma");
//        List<String> result = words.stream()
//                .filter(n -> n.length() > 3)
//                .distinct()
//                .toList();
//        System.out.println(result);

        //Task3 :Employee sinfi var: name, department, salary, age.

        List<Employee> employees = List.of(
                new Employee("Əli", "IT", 3500.0, 28),
                new Employee("Aysel", "IT", 4200.0, 34),
                new Employee("Nigar", "HR", 2500.0, 26),
                new Employee("Rəşad", "HR", 2800.0, 41),
                new Employee("Leyla", "Finance", 3900.0, 31),
                new Employee("Kamran", "Finance", 4500.0, 45),
                new Employee("Sevinc", "IT", 5000.0, 29)
        );

        //  Ən yüksək maaşlı işçi
        Optional<Employee> topEarner = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println(topEarner);

        //  Bütün işçilərin orta maaşı
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Orta maaş: " + avgSalary);

        //  Yaşı 30-dan böyük olanların ümumi maaş cəmi
        double sumOver30 = employees.stream()
                .filter(e -> e.getAge() > 30)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("30-dan böyük yaşlıların maaş cəmi: " + sumOver30);


                // TASK 4

                // 1) Department-ə görə qruplaşdırma
                Map<String, List<Employee>> byDepartment = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
                byDepartment.forEach((dep, list) ->
                        System.out.println(dep + " -> " + list));

                // 2) Hər departamentdə neçə işçi var
                Map<String, Long> countByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));
                System.out.println("İşçi sayı: " + countByDepartment);

                // 3) Hər departamentin orta maaşı
                Map<String, Double> avgSalaryByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));
                System.out.println("Departament üzrə orta maaş: " + avgSalaryByDepartment);

//        Task 5 :List<String> e-poçt ünvanları verilir (təkrarlananlar var).
//        Bunları et:
//        hamısını kiçik hərfə çevir,
//        @gmail.com ilə bitənləri seç,
//                təkrarları sil,
//                neçə unikal Gmail ünvanı olduğunu count() ilə tap.

        // Hamısını kiçik hərfə çevir, @gmail.com ilə bitənləri seç, təkrarları sil
        List<String> emails = List.of(
                "Ali@Gmail.com",
                "aysel@yahoo.com",
                "ali@gmail.com",
                "NIGAR@GMAIL.COM",
                "rashad@outlook.com",
                "nigar@gmail.com",
                "Leyla@Gmail.com",
                "leyla@gmail.com"
        );

        List<String> uniqueGmail = emails.stream()
                .map(String::toLowerCase)
                .filter(e -> e.endsWith("@gmail.com"))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unikal Gmail ünvanları: " + uniqueGmail);

        // Unikal Gmail ünvanlarının sayı (count ilə)
        long count = emails.stream()
                .map(String::toLowerCase)
                .filter(e -> e.endsWith("@gmail.com"))
                .distinct()
                .count();


        //Task 6
        System.out.println("Unikal Gmail sayı: " + count);

        List<String> students = List.of("Aysel", "Orxan", "Leyla");

        students.stream()
                .map(name -> "Tələbə: " + name)
                .forEach(System.out::println);

        //Task 7
        List<Integer> numbers = List.of(5, 12, 8, 15, 20);

        numbers.stream()
                .filter(n -> n > 10)
                .map(n -> "Ədəd: " + n)
                .forEach(System.out::println);


        //Task 8

        Map<String, Integer> grades = new LinkedHashMap<>();
        grades.put("Riyaziyyat", 90);
        grades.put("Fizika", 85);
        grades.put("Kimya", 78);
        grades.put("Ədəbiyyat", 92);

        grades.forEach((key, value) -> System.out.println(key + " -> " + value));



    }
}