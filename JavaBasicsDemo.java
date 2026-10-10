package util;

import java.util.Vector;

public class JavaBasicsDemo {

    // Static variable
    private static int objectCount = 0;

    private int id;
    private String name;


    // Default constructor
    public JavaBasicsDemo() {

        this.id = 0;
        this.name = "Unknown";

        objectCount++;
    }


    // Parameterized constructor
    public JavaBasicsDemo(
            int id,
            String name) {

        this.id = id;
        this.name = name;

        objectCount++;
    }


    // Constructor overloading
    public JavaBasicsDemo(
            int id) {

        this.id = id;
        this.name = "Student";

        objectCount++;
    }


    // Static method
    public static int getObjectCount() {

        return objectCount;
    }


    // Display student
    public void display() {

        System.out.println(
                "ID   : " + id
        );

        System.out.println(
                "Name : " + name
        );
    }


    public void demonstrateBasics() {

        System.out.println(
                "\n================================="
        );

        System.out.println(
                "        JAVA BASICS DEMO"
        );

        System.out.println(
                "================================="
        );


        // Constructor demonstration

        JavaBasicsDemo student1 =
                new JavaBasicsDemo();

        JavaBasicsDemo student2 =
                new JavaBasicsDemo(
                        101,
                        "Rahul"
                );

        JavaBasicsDemo student3 =
                new JavaBasicsDemo(
                        102
                );


        System.out.println(
                "\n--- CONSTRUCTORS ---"
        );

        student1.display();

        System.out.println();

        student2.display();

        System.out.println();

        student3.display();


        // StringBuffer

        System.out.println(
                "\n--- STRINGBUFFER ---"
        );

        StringBuffer buffer =
                new StringBuffer("Java");

        buffer.append(" Programming");

        buffer.insert(
                5,
                "Core "
        );

        System.out.println(
                "Result: " + buffer
        );

        buffer.reverse();

        System.out.println(
                "Reversed: " + buffer
        );


        // Wrapper classes

        System.out.println(
                "\n--- WRAPPER CLASSES ---"
        );

        int number = 100;

        Integer wrappedNumber =
                Integer.valueOf(number);

        System.out.println(
                "Primitive int : " + number
        );

        System.out.println(
                "Integer object : " +
                wrappedNumber
        );


        // Unboxing

        int unboxedNumber =
                wrappedNumber.intValue();

        System.out.println(
                "Unboxed int    : " +
                unboxedNumber
        );


        // Typecasting

        System.out.println(
                "\n--- TYPECASTING ---"
        );

        double decimalNumber =
                95.75;

        int integerNumber =
                (int) decimalNumber;

        System.out.println(
                "Double value : " +
                decimalNumber
        );

        System.out.println(
                "After casting: " +
                integerNumber
        );


        // Vector

        System.out.println(
                "\n--- VECTOR ---"
        );

        Vector<String> courses =
                new Vector<>();

        courses.add("Java");

        courses.add("Database");

        courses.add("Python");

        System.out.println(
                "Courses: " + courses
        );

        System.out.println(
                "First course: " +
                courses.get(0)
        );


        // Static variable

        System.out.println(
                "\n--- STATIC ---"
        );

        System.out.println(
                "Objects created: " +
                JavaBasicsDemo.getObjectCount()
        );


        // Garbage collection

        System.out.println(
                "\n--- GARBAGE COLLECTION ---"
        );

        JavaBasicsDemo temporary =
                new JavaBasicsDemo(
                        999,
                        "Temporary"
                );

        temporary.display();

        temporary = null;

        System.gc();

        System.out.println(
                "Garbage collection requested."
        );
    }
}
