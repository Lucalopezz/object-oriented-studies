package org;

public class Main {
    static void main() {
        final UserAccount big = new UserAccount("big@gm", "big");
        final UserAccount gui = new UserAccount("gui@gm", "gui");
        final UserAccount mary = new UserAccount("mary@gm", "mary");

        big.acceptFollower(gui);
        big.publish("Bigodes sao legais");

        System.out.println("Estado do big:");
        System.out.println(big.myPostsAsString());

        gui.clapPost(0);
        gui.booPost(0);
        System.out.println("Estado do gui:");
        System.out.println(gui.timeLineAsString());



    }
}
