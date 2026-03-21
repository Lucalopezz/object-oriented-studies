package org.example;


import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um email: ");

        String email = scanner.nextLine();
        if (Email.isEmailValid(email)) {
            System.out.println("Email válido: " + email);
        }else {
            System.out.println("Email inválido: " + email);
        }

    }
}
