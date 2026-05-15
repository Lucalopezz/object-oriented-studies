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

    public void publish(String quote) {
        final Post post = new Post(quote, this);

        this.posts[this.postsCount++] = post;

        for (int i = 0; i < followersCount; i++) {
            followers[i].updateTimeLine(post); // ctrl alt n ou ctrl alt 
        }
    }

    public void updateTimeLine(Post post) {
        timeLine[timeLineCount % 10] = post;
        timeLineCount++;
    }

    public boolean delete(int postIndex) {
        if (postIndex < 0 || postIndex >= postsCount) {
            return false;
        }
        posts[postIndex] = posts[postsCount - 1];
        posts[postsCount - 1] = null;
        postsCount--;
        return true;
    }

    private boolean isInvalidTimeLineIndex(int postIndex) {
        return postIndex < 0 || postIndex >= Math.min(timeLineCount, 10);
    }

    public void clapPost(int postIndex) {
        // Se ele fez mais do q postCount é 10
        if (isInvalidTimeLineIndex(postIndex)) {
            return;
        }
        timeLine[postIndex].clap();
    }

    public void booPost(int postIndex) {
        // Se ele fez mais do q postCount é 10
        if (isInvalidTimeLineIndex(postIndex)) {
            return;
        }
        timeLine[postIndex].boo();
    }

    public void acceptFollower(UserAccount userAccount) {
        followers[followersCount++] = userAccount;
    }

    public void blockFollower(UserAccount follower) {
        if (followers == null) return;

        for (int i = 0; i < followersCount; i++) {
            UserAccount userAccount = followers[i];
            if (userAccount.getUserName().equals(follower.getUserName())) {
                followers[i] = followers[followersCount - 1];
                followers[followersCount - 1] = null;
                followersCount--;
            }
        }
    }

    public String timeLineAsString() {
        StringBuilder builder = new StringBuilder("TimeLine: ");
        for (int i = 0; i < Math.min(timeLineCount, 10); i++) {
            Post post = timeLine[i];
            builder.append(post.show()).append("\n");

        }
        return builder.toString();
    }

    public String myPostsAsString() {
        StringBuilder builder = new StringBuilder("MyPosts: ");
        for (int i = 0; i < Math.min(postsCount, 10); i++) {
            Post post = posts[i];
            builder.append(post.show()).append("\n");

        }
        return builder.toString();
    }

    public String followersAsString() {
        StringBuilder builder = new StringBuilder("Followers: ");
        for (int i = 0; i < followersCount; i++) {
            UserAccount userAccount = followers[i];
            builder.append(userAccount.getUserName()).append("\n");

        }
        return builder.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
