package org;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String quote;
    private LocalDateTime date;
    private int claps;
    private int boos;

    private UserAccount userAccount;

    public Post(String quote, UserAccount userAccount) {
        this.quote = quote;
        this.userAccount = userAccount;
        this.date = LocalDateTime.now();
        this.claps = 0;
        this.boos = 0;
    }

    public String show() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm");
        return String.format(
                "[%s] %s says \"%s\" | Claps: %d | Boos: %d.",
                formatter.format(date),
                userAccount.getUserName(),
                quote,
                claps,
                boos
        );
    }

    public void clap() {
        this.claps++;
    }

    public void boo() {
        this.boos++;
    }

    public int getBoos() {
        return boos;
    }

    public int getClaps() {
        return claps;
    }

    public String getQuote() {
        return quote;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getUserName() {
        return userAccount.getUserName();
    }
}
