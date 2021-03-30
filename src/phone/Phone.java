package phone;

import state.*;

public class Phone {
    private State state;
    private String number;
    private int balance;

    public Phone () {
        this.state = new WaitingState(this);
    }

    public int getBalance() {
        return balance;
    }

    public void chanheState (State state) {
        this.state = state;
    }

    public void addMoney (int money) {
        this.balance += money;
    }

    public void clickAnswer () {
        this.state.clickAnswer();
    }

    public void clickEnd () {
        this.state.clickEnd();
    }

    public void call (String num) {
        this.state.call();
    }
}
