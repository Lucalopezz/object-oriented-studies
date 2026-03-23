package org;

public class UserAccount {
    private String email;
    private String userName;

    private UserAccount[] followers = new UserAccount[100];
    private int followersCount = 0;

    private Post[] timeLine = new Post[10];
    private int timeLineCount = 0;

    private Post[] posts = new Post[100];
    private int postsCount = 0;



    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
