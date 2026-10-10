package model;

public class StudentUser extends User
        implements Reportable {

    private String course;

    private final String userType = "STUDENT";

    public StudentUser(
            int userId,
            String userName,
            String course) {

        super(userId, userName);

        this.course = course;
    }

    @Override
    public void displayRole() {

        System.out.println(
                "Role       : Student"
        );

        System.out.println(
                "Course     : " + course
        );

        System.out.println(
                "User Type  : " + userType
        );
    }

    @Override
    public void generateReport() {

        System.out.println(
                "Student report generated for: "
                + userName
        );
    }
}
