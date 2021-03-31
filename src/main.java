import phone.Phone;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.addMoney(0.6f);
        /*System.out.println(phone.getBalance());
        System.out.println(phone.call("88005553535"));*/
        Scanner sc = new Scanner(System.in);

        UserCommands command = UserCommands.TurnOn;
        int j = 1, commandIndex;
        String telephoneNumber;
        float deposit = 0;

        //Пользовательский интерфейс
        System.out.print("Phone is turned on! Welcome!\n");
        /* while (command != UserCommands.TurnOff)
        {
            System.out.print("--------------------\n");
            System.out.print("What do you want?\n" +
                    "1 - See your order\n" +
                    "2 - Change your order\n" +
                    "0 or any other number - Exit\n");
            System.out.print("--------------------\n");

            commandIndex = sc.nextInt();
            command = UserCommands.values()[commandIndex];


            switch (command)
            {
                case (FindOutBalance):
                    System.out.print("--------------------\n");
                    System.out.println("Your balance: " + phone.getBalance());
                    System.out.print("--------------------\n");

                    break;


                case (PutMoneyOnBalance):
                    System.out.print("--------------------\n");
                    System.out.print("How much do you want to deposit?" );
                    deposit = sc.nextFloat();
                    if (deposit <= 0) {
                        System.out.print("The value cannot be less than or equal zero!\n");
                    }
                    else {
                        phone.addMoney(deposit);
                    }
                    System.out.print("--------------------\n");

                    break;

                case (CallSmb):
                    System.out.print("--------------------\n");
                    System.out.print("What number do you want to call?" );
                    telephoneNumber = sc.nextLine();
                    phone.call(telephoneNumber);
                    //start time
                    System.out.println("Calling on number: \n" + telephoneNumber);
                    System.out.print("--------------------\n");

                    break;

                case (ResetCall):
                    System.out.print("--------------------\n");
                    System.out.print("The call was cancelled" );
                    //stop time
                    phone.clickEnd();
                    System.out.print("--------------------\n");

                    break;

                default:

                    break;
            }
        } */

    }
}