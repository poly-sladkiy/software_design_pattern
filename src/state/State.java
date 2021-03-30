package state;

import phone.Phone;

public abstract class State {
    public Phone phone;

    public State(Phone phone) {
        this.phone = phone;
    }

    public abstract boolean callable();

    public abstract String clickAnswer();
    public abstract String clickEnd();
    public abstract String call();
}
