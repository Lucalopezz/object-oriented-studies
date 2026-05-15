package org.example;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty())
            return false;


        String[] parts = email.split("@");
        if (parts.length != 2)
            return false;

        String domain = parts[1];
        String text = parts[0];
        if (text.isEmpty() || domain.isEmpty() || text.length() <= 3 || domain.length() <= 3) {
            return false;
        }
        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\\.");

        for (String part : domainParts) {
            if (part.isEmpty())
                return false;
        }



        return true;
    }
}
