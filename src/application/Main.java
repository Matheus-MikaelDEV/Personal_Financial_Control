package application;

import entities.Transaction;
import entities.enums.TypeTransaction;
import util.Financial;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to your Personal Financial System!");

        System.out.println("Type start to start the program.");
        String start = sc.nextLine();

        if (start.equalsIgnoreCase("start")) {
            System.out.println("Welcome to your Personal Financial System!");

            int option = 0;

            Financial financial = new Financial();

            do {
                System.out.println("1 - Transaction\n2 - Remove Transaction\n3 - List by Period\n4 - Total Amount\n5 - Exit");
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        // System that deposits and withdraws from the system
                        System.out.println("Transaction!");
                        System.out.print("Enter a description for your transaction: ");
                        String description = sc.nextLine();
                        System.out.print("What type of transaction is it? ");
                        TypeTransaction type = TypeTransaction.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Transfer date (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        System.out.print("Enter amount to deposit: ");
                        BigDecimal amount = new BigDecimal(sc.nextLine());

                        Transaction transaction = new Transaction(description, type, amount, date);

                        financial.addTransaction(transaction);

                        if (financial.addTransaction(transaction)) {
                            System.out.println("Transaction completed!");
                        } else {
                            System.out.println("Transaction with some failure.");
                        }
                        break;
                    case 2:
                        financial.list();

                        System.out.println("Remove Transaction");
                        System.out.print("Transaction ID that will be removed: ");
                        Integer remove = sc.nextInt();
                        sc.nextLine();

                        financial.removeTransaction(remove);

                        if (financial.removeTransaction(remove)) {
                            System.out.println("Complete removal!");
                        } else {
                            System.out.println("Removal with some failure.");
                        }

                        break;
                    case 3:
                        //Listing for a period taking beginning and end
                        System.out.println("List by Period");
                        System.out.print("First date (YYYY-MM-DD): ");
                        LocalDate firstDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        System.out.print("Second date (YYYY-MM-DD): ");
                        LocalDate secondDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                        System.out.println(financial.listByPeriod(firstDate, secondDate));

                        if (financial.listByPeriod(firstDate, secondDate) == null) {
                            System.out.println("Empty period.");
                        } else {
                            System.out.println("Listing by period completed!");
                        }
                        break;
                    case 4:

                    case 5:
                        System.out.println("Leaving the program...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }

            } while (option != 4);
        }
    }
}