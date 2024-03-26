import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        int strengthScore = calculateStrengthScore(length, hasUpperCase, hasLowerCase, hasDigit, hasSpecialChar);

        System.out.println("Password strength: " + evaluateStrength(strengthScore));

        scanner.close();
    }

    private static int calculateStrengthScore(int length, boolean hasUpperCase, boolean hasLowerCase, boolean hasDigit, boolean hasSpecialChar) {
        int score = 0;

        // Length
        if (length >= 8) {
            score += 5;
        } else if (length >= 6) {
            score += 3;
        } else {
            score += 1;
        }

        // Uppercase and lowercase letters
        if (hasUpperCase && hasLowerCase) {
            score += 3;
        } else if (hasUpperCase || hasLowerCase) {
            score += 2;
        }

        // Digits
        if (hasDigit) {
            score += 2;
        }

        // Special characters
        if (hasSpecialChar) {
            score += 3;
        }

        return score;
    }

    private static String evaluateStrength(int score) {
        if (score >= 12) {
            return "Strong";
        } else if (score >= 7) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
