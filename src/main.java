import phone.Phone;

import java.time.Instant;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);
        String command;
        String state;

        String help =
                "help\t\t\t\tshow this text\n" +
                "addMoney <float>\tadd money to the phone`s balance\n" +
                "showBalance\t\t\tshow your phone`s balance\n" +
                "answerCall\t\t\tanswer to incoming call\n" +
                "call <number>\t\tcall to number (only if balance more then 0.5)\n" +
                "endCall\t\t\t\tend talking\n" +
                "turnOff\t\t\t\tturn off your phone";

        String telephoneNumber;
        float deposit = 0;
        Instant start, finish;

        while (true)
        {
            command = sc.next();
            state = "";

            switch (command)
            {
                case "showBalance":
                    System.out.println("Your balance: " + phone.getBalance());
                    break;

                case "turnOff":
                    System.out.println("Turning off... Good bye!");
                    return;

                case "addMoney":
                    deposit = sc.nextFloat();

                    if (phone.addMoney(deposit)) {
                        System.out.print("The balance is replenished!\n");
                    }
                    else {
                        System.out.print("Something went wrong!" +
                                "May be you entered a negative amount or a zero?\n");
                    }

                    break;

                case "call":
                    telephoneNumber = sc.next();
                    phone.call(telephoneNumber);
                    start = Instant.now();
                    System.out.println("Calling on number:" + telephoneNumber);

                    break;

                case "answerCall":
                    state = phone.clickAnswer();
                    if (state == null) {
                        System.out.println("Can not answer!");
                    } else {
                        System.out.println("Answer...");
                        phone.clickAnswer();
                    }
                    break;

                case "endCall":
                    state = phone.clickEnd();
                    if (state == null) {
                        System.out.println("Can not end call!");
                    } else {
                        finish = Instant.now();
                        System.out.println("Call is end.");
                    }
                    break;

                case "help":
                    System.out.println(help);
                    break;

                default:
                    System.out.print("You entered the wrong command" +
                            "Enter" + '"' + "help" + '"' + "to get information about the program.");
                    break;

            }
        }
    }
}