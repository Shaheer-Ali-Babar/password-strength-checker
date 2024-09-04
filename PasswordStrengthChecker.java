package javaapplication4;

import java.util.Scanner;

public class PasswordStrengthChecker {
    
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);

        scanner.close();
    }

    public String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Determine password strength
        if (length >= 8 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
            return "Strong";
        } else if (length >= 6 && ((hasUpperCase && hasLowerCase) || (hasDigit && hasSpecialChar))) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}