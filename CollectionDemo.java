package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

    public void demonstrateCollections() {

        System.out.println(
                "\n================================="
        );

        System.out.println(
                "        COLLECTIONS DEMO"
        );

        System.out.println(
                "================================="
        );


        // ---------------------------------
        // 1. LIST - ARRAYLIST
        // ---------------------------------

        System.out.println(
                "\n--- ARRAYLIST ---"
        );

        List<String> students =
                new ArrayList<>();

        students.add("Rahul");
        students.add("Amit");
        students.add("Priya");

        System.out.println(
                "Students: " + students
        );

        System.out.println(
                "First student: "
                + students.get(0)
        );


        // ---------------------------------
        // 2. LINKEDLIST
        // ---------------------------------

        System.out.println(
                "\n--- LINKEDLIST ---"
        );

        LinkedList<String> courses =
                new LinkedList<>();

        courses.add("Java");
        courses.add("Database");
        courses.add("Python");

        courses.addFirst("Programming");
        courses.addLast("Web Development");

        System.out.println(
                "Courses: " + courses
        );

        System.out.println(
                "First course: "
                + courses.getFirst()
        );

        System.out.println(
                "Last course: "
                + courses.getLast()
        );


        // ---------------------------------
        // 3. SET - HASHSET
        // ---------------------------------

        System.out.println(
                "\n--- HASHSET ---"
        );

        Set<String> subjects =
                new HashSet<>();

        subjects.add("Java");
        subjects.add("Database");
        subjects.add("Java");
        subjects.add("Python");

        System.out.println(
                "Subjects: " + subjects
        );

        System.out.println(
                "Notice: duplicate Java is stored only once."
        );


        // ---------------------------------
        // 4. ITERATOR
        // ---------------------------------

        System.out.println(
                "\n--- ITERATOR ---"
        );

        Iterator<String> iterator =
                subjects.iterator();

        while (iterator.hasNext()) {

            String subject =
                    iterator.next();

            System.out.println(
                    "Subject: " + subject
            );
        }


        // ---------------------------------
        // 5. HASHMAP
        // ---------------------------------

        System.out.println(
                "\n--- HASHMAP ---"
        );

        Map<Integer, String> studentMap =
                new HashMap<>();

        studentMap.put(
                101,
                "Rahul"
        );

        studentMap.put(
                102,
                "Amit"
        );

        studentMap.put(
                103,
                "Priya"
        );

        System.out.println(
                "Student Map: "
                + studentMap
        );

        System.out.println(
                "Student with ID 101: "
                + studentMap.get(101)
        );


        // ---------------------------------
        // 6. HASHMAP FOREACH
        // ---------------------------------

        System.out.println(
                "\n--- HASHMAP FOREACH ---"
        );

        studentMap.forEach(
                (id, name) -> {

                    System.out.println(
                            "ID: " + id
                            + ", Name: " + name
                    );
                }
        );


        // ---------------------------------
        // 7. LIST FOREACH
        // ---------------------------------

        System.out.println(
                "\n--- LIST FOREACH ---"
        );

        students.forEach(
                student -> {

                    System.out.println(
                            "Student: " + student
                    );
                }
        );


        System.out.println(
                "\nCollection demonstration completed."
        );
    }
}

