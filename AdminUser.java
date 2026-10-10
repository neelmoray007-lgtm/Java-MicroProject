package model;

public class AdminUser extends User
        implements Reportable {

    private final String userType = "ADMIN";

    public AdminUser(
            int userId,
            String userName) {

        super(userId, userName);
    }

    @Override
    public void displayRole() {

        System.out.println(
                "Role       : Administrator"
        );

        System.out.println(
                "User Type  : " + userType
        );
    }

    @Override
    public void generateReport() {

        System.out.println(
                "Administrator report generated."
        );
    }
}
