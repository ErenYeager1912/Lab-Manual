import java.util.Scanner;
public class CountCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int vowels = 0, consonants = 0, digits = 0, special = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
            else if (Character.isDigit(ch)) {
                digits++;
            }
            else {
                special++;
            }
        }
        System.out.println("\nVowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);
     sc.close();
    }
}
        System.out.println("\nBreakdown for \"" + input + "\":");
        System.out.print("- Vowels: ");
        for (char ch : input.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                System.out.print(ch + " ");
            }
        }
        System.out.println("→ " + vowels);

        System.out.print("- Consonants: ");
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch) && "aeiouAEIOU".indexOf(ch) == -1) {
                System.out.print(ch + " ");
            }
        }
        System.out.println("→ " + consonants);

        System.out.print("- Digits: ");
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                System.out.print(ch + " ");
            }
        }
        System.out.println("→ " + digits);

        System.out.print("- Special Characters: ");
        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                System.out.print(ch + " ");
            }
        }
        System.out.println("→ " + specialChars);
        scanner.close();
    }
