import phone.Phone;

public class main {
    public static void main(String[] args) {
        Phone phone = new Phone();

        phone.addMoney(1);
        System.out.println(phone.getBalance());
        System.out.println(phone.call("085093450"));
    }
}