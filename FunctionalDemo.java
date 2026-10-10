package util;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {

    public void demonstrateFunctionalInterfaces() {

        List<Student> students = new ArrayList<>();

        students.add(
            new Student(
                101,
                "Rahul Sharma",
                "rahul@gmail.com",
                "Java",
                85
            )
        );

        students.add(
            new Student(
                102,
                "Amit Kumar",
                "amit@gmail.com",
                "Database",
                55
            )
        );

        students.add(
            new Student(
                103,
                "Priya Singh",
                "priya@gmail.com",
                "Java",
                92
            )
        );


        // Predicate
        Predicate<Student> passedStudent =
            student -> student.getMarks() >= 60;


        // Consumer
        Consumer<Student> displayStudent =
            student -> {

                System.out.println(
                    "ID     : " + student.getId()
                );

                System.out.println(
                    "Name   : " + student.getName()
                );

                System.out.println(
                    "Course : " + student.getCourse()
                );

                System.out.println(
                    "Marks  : " + student.getMarks()
                );

                System.out.println("-------------------------");
            };


        // Supplier
        Supplier<String> messageSupplier =
            () -> "Students who scored 60 or above:";


        // Function
        Function<Student, String> studentToString =
            student ->
                student.getName()
                + " - "
                + student.getMarks();


        System.out.println("\n=================================");
        System.out.println("   FUNCTIONAL INTERFACE DEMO");
        System.out.println("=================================");


        System.out.println(
            messageSupplier.get()
        );


        for (Student student : students) {

            if (passedStudent.test(student)) {

                displayStudent.accept(student);

                System.out.println(
                    "Summary: "
                    + studentToString.apply(student)
                );

                System.out.println("-------------------------");
            }
        }
    }
}

