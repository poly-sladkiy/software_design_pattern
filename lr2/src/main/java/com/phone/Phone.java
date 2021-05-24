package com.phone;

import com.state.State;
import com.state.States.WaitingState;
import org.springframework.stereotype.Component;

@Component
public class Phone {

    private State state;

    private String number;
    private float balance;

    public Phone() {
        this.state = new WaitingState(this);
    }

    public float getBalance() {
        return balance;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean addMoney(float money) {
        if (money > 0) {
            this.balance += money;
            return true;
        } else
            return false;
    }

    //Сама функция списания денег
    public void payMoney(long time) {
        balance -= 0.03f * time;
    }

    public String clickAnswer() {
        return this.state.clickAnswer();
    }

    public String clickEnd() {
        return this.state.clickEnd();
    }

    public String call(String num) {
        if (state.callable()) {
            return this.state.call();
        }
        return null;
    }
}
