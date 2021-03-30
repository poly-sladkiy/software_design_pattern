package state.States;

import state.State;
import phone.Phone;

public class WaitingState extends State {

    public WaitingState(Phone phone) {
        super(phone);
    }

    //todo: прописать комментарии
    @Override
    public boolean callable() {
        if (phone.getBalance() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Мы можем ответить на входящий звонок в режиме ожидания
     * @return String
     */
    @Override
    public String clickAnswer() {
        phone.changeState(new CallingState(phone));
        return this.getClass().getName() + " -> clickAnswer" + " -> CallingState";
    }

    /**
     * Проверяем баланс телефона
     * Если он положительный, то переходим к состоянию звонка,
     * Если он отрицательный, то переходим в режиму блокировки.
     * @return String
     */
    @Override
    public String call() {
        if (phone.getBalance() > 0) {
            phone.changeState(new CallingState(phone));
            return this.getClass().getName() + " -> call" + " -> CallingState";
        } else {
            phone.changeState(new BlockedState(phone));
            return this.getClass().getName() + " -> call" + " -> BlockedState";
        }
    }

    /**
     * В режиме ожидания мы не можем сбросить звонок
     * @return null
     */
    @Override
    public String clickEnd() {
        return null;
    }

}
