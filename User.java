package model;

public abstract class User {

    protected int userId;
    protected String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public abstract void displayRole();

    public void displayUser() {

        System.out.println(
                "User ID   : " + userId
        );

        System.out.println(
                "User Name : " + userName
        );
    }
}

