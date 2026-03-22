package org.example;

import org.example.exercise1.Convention;
import org.example.exercise1.NamingConventions;

public class Main {
    static void main() {
        System.out.println("Está no parão: " + NamingConventions.isFollowingConvetion("testConvention", Convention.METHOD));
        System.out.println("Const para metodo: " + NamingConventions.fromConstToVariable("TEST_CONSTANT"));
        System.out.println("Var para const: " + NamingConventions.fromVariableToConst("testVariable"));
    }
}
