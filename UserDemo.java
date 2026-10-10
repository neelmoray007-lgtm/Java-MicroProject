package util;

import model.AdminUser;
import model.StudentUser;
import model.User;

public class UserDemo {

    public void demonstrateUsers() {

        User student =
                new StudentUser(
                        101,
                        "Rahul Sharma",
                        "Java"
                );

        User admin =
                new AdminUser(
                        1,
                        "System Administrator"
                );

        System.out.println(
                "\n================================="
        );

        System.out.println(
                "       INHERITANCE DEMO"
        );

        System.out.println(
                "================================="
        );

        System.out.println(
                "\n--- STUDENT USER ---"
        );

        student.displayUser();
        student.displayRole();

        System.out.println(
                "\n--- ADMIN USER ---"
        );

        admin.displayUser();
        admin.displayRole();

        System.out.println(
                "\n--- REPORT ---"
        );

        ((StudentUser) student).generateReport();

        ((AdminUser) admin).generateReport();
    }
}

