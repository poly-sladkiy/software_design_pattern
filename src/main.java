import phone.Phone;

import java.time.Instant;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);

        String command, telephoneNumber;
        float deposit = 0;
        Instant start, finish;

        while (true)
        {
            command = sc.next();

            switch (command)
            {
                case ("showBalance"):
                    System.out.println("Your balance: " + phone.getBalance());

                    break;


                case ("addMoney"):
                    deposit = sc.nextFloat();

                    if (phone.addMoney(deposit);) {
                        System.out.print("The balance is replenished!\n");
                    }
                    else {
                        System.out.print("Something went wrong!" +
                                "May be you entered a negative amount or a zero?\n");
                    }

                    break;

                case ("call"):
                    telephoneNumber = sc.next();
                    phone.call(telephoneNumber);
                    start = Instant.now();
                    System.out.println("Calling on number:" + telephoneNumber);

                    break;


                default:
                    System.out.print("You entered the wrong command" +
                            "Enter" + '"' + "help" + '"' + "to get information about the program.");
                    break;
            }
        }

    }
}