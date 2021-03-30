package state.States;

import phone.Phone;
import state.State;
import state.States.*;

public class BlockedState extends State {

    public BlockedState(Phone phone) {
        super(phone);
    }

    /**
     * Мы можем принять звонок от другого человека с отрицательным балансом
     * @return String
     */
    @Override
    public String clickAnswer() {
        phone.changeState(new CallingState(phone));
        return this.getClass().getName() + " -> clickAnswer" +  " -> CallingState";
    }

    /**
     * Мы ни с кем не разговариваем - не за чем завершать разговор.
     * Проверяем не стал ли баланс положительным для возможного перехода
     * к другому состоянию.
     * @return String
     */
    @Override
    public String clickEnd() {
        if (phone.getBalance() > 0) {
            phone.changeState(new WaitingState(phone));
            return this.getClass().getName() + " -> clickEnd" +  " -> WaitingState";
        }
        return null;
    }

    /**
     * Проверяем не стал ли баланс положительным.
     * Если да, то переходим к состоянию звонка,
     * если нет, то ничего не делаем.
     * @return String
     */
    @Override
    public String call() {
        if (phone.getBalance() > 0) {
            phone.changeState(new CallingState(phone));
            return this.getClass().getName() + " -> call" +  " -> CallingState";
        }
        return null;
    }
}
