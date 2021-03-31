import phone.Phone;

import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Scanner sc = new Scanner(System.in);
        String command;
        String state;

        String help =
                "\nhelp\t\t\t\tshow this text\n" +
                "addMoney <float>\tadd money to the phone`s balance\n" +
                "showBalance\t\t\tshow your phone`s balance\n" +
                "answerCall\t\t\tanswer to incoming call\n" +
                "call <number>\t\tcall to number (only if balance more then 0.5)\n" +
                "endCall\t\t\t\tend talking\n" +
                "turnOff\t\t\t\tturn off your phone\n";

        String telephoneNumber;
        float deposit = 0;
        Instant start = Instant.now();
        Instant finish = Instant.now();
        boolean didYouCall = false;                 //Флажок для реализации логики списания денег

        System.out.println(help);
        System.out.println("Phone is turn on!");

        while (true)
        {
            System.out.print("Enter command: ");

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
                        System.out.print("Something went wrong! " +
                                "May be you entered a negative amount or a zero?\n");
                    }
                    break;

                case "call":
                    telephoneNumber = sc.next();
                    state = phone.call(telephoneNumber);
                    didYouCall = true;

                    if (state == null){
                        System.out.println("Can not call!");
                    } else {
                        start = Instant.now();
                        System.out.println("Calling on number: " + telephoneNumber);
//                        System.out.println(state);
                    }
                    break;

                case "answerCall":
                    state = phone.clickAnswer();
                    didYouCall = false;
                    if (state == null) {
                        System.out.println("Can not answer!");
                    } else {
                        System.out.println("Answer...");
                        phone.clickAnswer();
                        start = Instant.now();
//                        System.out.println(state);
                    }
                    break;

                case "endCall":
                    state = phone.clickEnd();
                    if (state == null) {
                        System.out.println("Can not end call!");
                    } else {
                        finish = Instant.now();
                        long elapsed = (Duration.between(start, finish).toMillis())/1000;
                        System.out.println("Your phone conversation lasted: " + elapsed + " seconds");
                        if (didYouCall)                                            //Если звонил ты, то деньги списались
                            phone.payMoney(elapsed);
                        System.out.println("Call is end.");
//                        System.out.println(state);
                    }
                    break;

                case "help":
                    System.out.println(help);
                    break;

                default:
                    System.out.println("You entered the wrong command\n" +
                            "Enter 'help' to get information about the program.");
                    break;

            }
        }
    }
}