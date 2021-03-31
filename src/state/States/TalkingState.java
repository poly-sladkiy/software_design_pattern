package state.States;

import state.State;
import phone.Phone;

public class TalkingState extends State {

    public TalkingState(Phone phone) {
        super(phone);
    }

    /**
     * Добавлено для удобства работы совершения звонков
     * Чтобы не обращаться к названию состояния и балансу, используем метод callable
     * Он проверяет возможность совершить звонок в данном состоянии телефона
     * Во время разговора мы не можем кому-то позвонить
     * @return boolean
     */
    @Override
    public boolean callable() {
        return false;
    }

    /**
     * Из состояния разговора нельзя ответить на ещё один звонок
     * @return String
     */
    @Override
    public String clickAnswer() {
        return null;
    }

    /**
     * Завершение звонка
     * @return String
     */
    @Override
    public String clickEnd() {
        phone.changeState(new WaitingState(phone));
        return this.getClass().getName() + " -> clickEnd" + " -> WaitingState";
    }

    /**
     * Во время разговора мы не можем позвонить другому человеку
     * @return String
     */
    @Override
    public String call() {
        return null;
    }
}
