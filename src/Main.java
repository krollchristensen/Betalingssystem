import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();
        System.out.print("Choose payment method (1: Credit Card, 2: PayPal, 3: Bank Transfer): ");
        int choice = scanner.nextInt();
        /*
        Et ennkelt interfacereference kan bruges til at kalde metoder på forskellige
        objekter (konkrete implementeringer), hvor den faktiske metode, der kaldes,
         bestemmes ved kørselstid = polymorfisme
         */
        PaymentProcessor processor;
        switch (choice) {
            case 1:
                processor = new CreditCardProcessor();
                break;
            case 2:
                processor = new PayPalProcessor();
                break;
            case 3:
                processor = new BankTransferProcessor();
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        processor.processPayment(amount);
        scanner.close();
    }
}