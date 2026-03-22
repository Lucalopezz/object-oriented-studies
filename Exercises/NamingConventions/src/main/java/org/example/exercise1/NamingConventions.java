package org.example.exercise1;

public class NamingConventions {
    public static boolean isFollowingConvetion(String name, Convention convention) {
        if (!isValidJavaIdentifier(name)) return false;
        return switch (convention) {
            case CLASS -> Character.isUpperCase(name.charAt(0)) && !name.contains("_");
            case METHOD, VARIABLE -> Character.isLowerCase(name.charAt(0)) && !name.contains("_");
            case CONSTANT -> name.equals(name.toUpperCase());
            default -> false;
        };
    }

    public static String fromConstToVariable(String constant) {
        if (!isValidJavaIdentifier(constant)) return "";

        StringBuilder result = new StringBuilder();
        boolean upperNext = false;

        constant = constant.toLowerCase();

        for (int i = 0; i < constant.length(); i++) {
            char c = constant.charAt(i);

            if (c == '_') {
                upperNext = true;
                continue;
            }

            if (upperNext) {
                result.append(Character.toUpperCase(c));
                upperNext = false;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String fromVariableToConst(String variable) {
        if (!isValidJavaIdentifier(variable)) return "";

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < variable.length(); i++) {
            char c = variable.charAt(i);

            if (Character.isUpperCase(c) && i > 0) {
                result.append('_');
            }

            result.append(Character.toUpperCase(c));
        }

        return result.toString();
    }

    public static boolean isValidJavaIdentifier(String name) {
        if (name.isEmpty() || name.charAt(0) == '_') return false;
        if (name.equals("class") || name.equals("int") || name.equals("char") || name.equals("float")) return false;
        for (char c : name.toCharArray()) {
            if (c == '#' || c == '$' || c == '@') return false;
        }
        return true;
    }


}
