package org.example;

public class Guest {
    private String ssn;
    private String name;
    private String email;

    public Guest(String ssn, String name, String email) {
        if (!ssn.isEmpty() && !name.isEmpty() && !email.isEmpty()) {
            this.ssn = ssn;
            this.name = name;
            this.email = email;
        }
    }


    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
