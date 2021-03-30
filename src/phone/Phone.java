package phone;

import state.State;
import state.States.*;

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

    public void changeState (State state) {
        this.state = state;
    }

    public void addMoney (int money) {
        this.balance += money;
    }

    public String clickAnswer () {
        return this.state.clickAnswer();
    }

    public String clickEnd () {
        return this.state.clickEnd();
    }

    public String call (String num) {
        return this.state.call();
    }
}
