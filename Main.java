import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import service.StudentService;
import service.CourseService;
import service.AttendanceService;

import util.ReportUtil;
import util.FunctionalDemo;
import util.UserDemo;
import util.JavaBasicsDemo;
import util.ThreadDemo;
import util.CollectionDemo;
import util.JDBCDemo;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService =
                new StudentService();

        CourseService courseService =
                new CourseService();

        AttendanceService attendanceService =
                new AttendanceService();

        ReportUtil reportUtil =
                new ReportUtil();

        FunctionalDemo functionalDemo =
                new FunctionalDemo();

        UserDemo userDemo =
                new UserDemo();

        JavaBasicsDemo javaBasicsDemo =
                new JavaBasicsDemo();

        ThreadDemo threadDemo =
                new ThreadDemo();

        CollectionDemo collectionDemo =
                new CollectionDemo();

        JDBCDemo jdbcDemo =
                new JDBCDemo();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Course");
            System.out.println("7. View Courses");
            System.out.println("8. Mark Attendance");
            System.out.println("9. View Attendance");
            System.out.println("10. Generate Student Report");
            System.out.println("11. Show Top Students");
            System.out.println("12. Functional Interface Demo");
            System.out.println("13. Inheritance & Interface Demo");
            System.out.println("14. Java Basics Demo");
            System.out.println("15. Thread & Synchronization Demo");
            System.out.println("16. Collections Demo");
            System.out.println("17. JDBC Demo");
            System.out.println("18. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            try {

                choice = scanner.nextInt();

            } catch (Exception e) {

                System.out.println(
                        "Please enter a number."
                );

                scanner.nextLine();

                choice = 0;
            }

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Student ID: "
                    );

                    int id =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Name: "
                    );

                    String name =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Email: "
                    );

                    String email =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Course: "
                    );

                    String course =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Marks: "
                    );

                    double marks =
                            scanner.nextDouble();

                    studentService.addStudent(
                            id,
                            name,
                            email,
                            course,
                            marks
                    );

                    break;


                case 2:

                    studentService.viewStudents();

                    break;


                case 3:

                    System.out.print(
                            "Enter Student ID to search: "
                    );

                    int searchId =
                            scanner.nextInt();

                    studentService.searchStudent(
                            searchId
                    );

                    break;


                case 4:

                    System.out.print(
                            "Enter Student ID to update: "
                    );

                    int updateId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter New Name: "
                    );

                    String newName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter New Email: "
                    );

                    String newEmail =
                            scanner.nextLine();

                    System.out.print(
                            "Enter New Course: "
                    );

                    String newCourse =
                            scanner.nextLine();

                    System.out.print(
                            "Enter New Marks: "
                    );

                    double newMarks =
                            scanner.nextDouble();

                    studentService.updateStudent(
                            updateId,
                            newName,
                            newEmail,
                            newCourse,
                            newMarks
                    );

                    break;


                case 5:

                    System.out.print(
                            "Enter Student ID to delete: "
                    );

                    int deleteId =
                            scanner.nextInt();

                    studentService.deleteStudent(
                            deleteId
                    );

                    break;


                case 6:

                    System.out.print(
                            "Enter Course ID: "
                    );

                    int courseId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Course Name: "
                    );

                    String courseName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Teacher Name: "
                    );

                    String teacherName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Duration: "
                    );

                    String duration =
                            scanner.nextLine();

                    courseService.addCourse(
                            courseId,
                            courseName,
                            teacherName,
                            duration
                    );

                    break;


                case 7:

                    courseService.viewCourses();

                    break;


                case 8:

                    System.out.print(
                            "Enter Student ID: "
                    );

                    int attendanceStudentId =
                            scanner.nextInt();

                    System.out.print(
                            "Enter Course ID: "
                    );

                    int attendanceCourseId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Attendance Date " +
                            "(YYYY-MM-DD): "
                    );

                    String dateInput =
                            scanner.nextLine();

                    try {

                        LocalDate attendanceDate =
                                attendanceService.parseDate(
                                        dateInput
                                );

                        System.out.print(
                                "Enter Status " +
                                "(Present/Absent): "
                        );

                        String status =
                                scanner.nextLine();

                        attendanceService.markAttendance(
                                attendanceStudentId,
                                attendanceCourseId,
                                attendanceDate,
                                status
                        );

                    } catch (DateTimeParseException e) {

                        System.out.println(
                                "Invalid date format!"
                        );

                        System.out.println(
                                "Please use YYYY-MM-DD."
                        );
                    }

                    break;


                case 9:

                    attendanceService.viewAttendance();

                    break;


                case 10:

                    System.out.print(
                            "Enter Student ID for report: "
                    );

                    int reportStudentId =
                            scanner.nextInt();

                    reportUtil.generateStudentReport(
                            reportStudentId
                    );

                    break;


                case 11:

                    studentService.showTopStudents();

                    break;


                case 12:

                    functionalDemo
                            .demonstrateFunctionalInterfaces();

                    break;


                case 13:

                    userDemo.demonstrateUsers();

                    break;


                case 14:

                    javaBasicsDemo
                            .demonstrateBasics();

                    break;


                case 15:

                    threadDemo
                            .demonstrateThreads();

                    break;


                case 16:

                    collectionDemo
                            .demonstrateCollections();

                    break;


                case 17:

                    jdbcDemo
                            .demonstrateJDBC();

                    break;


                case 18:

                    System.out.println(
                            "Thank you for using " +
                            "Student Management System!"
                    );

                    break;


                default:

                    if (choice != 0) {

                        System.out.println(
                                "Invalid choice! " +
                                "Please try again."
                        );
                    }
            }

        } while (choice != 18);

        scanner.close();
    }
}
