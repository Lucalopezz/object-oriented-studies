package org;

import java.time.LocalDate;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;

    private UserAccount userAccount;

    public Post(String quote, UserAccount userAccount) {
        this.quote = quote;
        this.userAccount = userAccount;
        this.date = LocalDate.now();
        this.claps = 0;
        this.boos = 0;
    }

    public int getBoos() {
        return boos;
    }

    public int getClaps() {
        return claps;
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.date).append(" ").append(this.userAccount.getUserName()).append(": ").append(this.quote).append(" (").append(this.claps).append(" claps, ").append(this.boos).append(" boos)");
        return sb.toString();
    }
    public void clap() {
        this.claps++;
    }
    public void boo() {
        this.boos++;
    }
}
