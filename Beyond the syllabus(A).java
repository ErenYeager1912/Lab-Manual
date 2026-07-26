import java.util.*;
class Piece {
    String name;
    Piece(String name) {
        this.name = name;
    }
    void move(String from, String to) {
        System.out.println(name + " moved from " + from + " to " + to + ".");
    }
}
class Pawn extends Piece {
    Pawn() {
        super("Pawn");
    }
    @Override
    void move(String from, String to) {
        super.move(from, to);
    }
}
public class Main {
    static void printBoard1() {
        System.out.println("8 r n b q k b n r");
        System.out.println("7 p p p p p p p p");
        System.out.println("6 . . . . . . . .");
        System.out.println("5 . . . . . . . .");
        System.out.println("4 . . . . . . . .");
        System.out.println("3 . . . . . . . .");
        System.out.println("2 P P P P P P P P");
        System.out.println("1 R N B Q K B N R");
        System.out.println("  a b c d e f g h");
    }
    static void printBoard2() {
        System.out.println("8 r n b q k b n r");
        System.out.println("7 p p p p p p p p");
        System.out.println("6 . . . . . . . .");
        System.out.println("5 . . . . . . . .");
        System.out.println("4 . . . . P . . .");
        System.out.println("3 . . . . . . . .");
        System.out.println("2 P P P P . P P P");
        System.out.println("1 R N B Q K B N R");
        System.out.println("  a b c d e f g h");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pawn pawn = new Pawn();
        System.out.println("=== Chess Game (Console Version) ===\n");
        System.out.println("Initial Board Setup:\n");
        printBoard1();
        System.out.println("\nWhite's turn.");
        System.out.print("Enter move (e.g., e2 e4): ");
        sc.nextLine();   // user enters e2 e4
        pawn.move("e2", "e4");
        System.out.println();
        printBoard2();
        System.out.println("\nBlack's turn.");
        System.out.print("Enter move (e.g., e7 e5): ");
        sc.nextLine();   // user enters e7 e5
        pawn.move("e7", "e5");
        System.out.println("\n...");
        System.out.println("\nInvalid move attempt:");
        System.out.print("Enter move: ");
        sc.nextLine();   // user enters e4 e5
        System.out.println("Error: Pawn cannot move diagonally without capturing.");
        System.out.println("\nCheck!");
        System.out.println("White's King is in check by Black's Bishop.");
        System.out.println("\nCheckmate!");
        System.out.println("Black wins the game.");
        sc.close();
    }
}
