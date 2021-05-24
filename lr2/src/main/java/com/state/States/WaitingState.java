package com.state.States;

import com.phone.Phone;
import com.state.State;
import org.springframework.stereotype.Component;

@Component
public class WaitingState extends State {

    public WaitingState(Phone phone) {
        super(phone);
    }

    /**
     * Добавлено для удобства работы совершения звонков
     * Чтобы не обращаться к названию состояния и балансу, используем метод callable
     * Он проверяет возможность совершить звонок в данном состоянии телефона
     * Если баланс положительный, то мы можем позвонить из состояния ожидания
     *
     * @return boolean
     */
    @Override
    public boolean callable() {
        return phone.getBalance() > 0;
    }

    /**
     * Мы можем ответить на входящий звонок в режиме ожидания
     *
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
     *
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
     *
     * @return null
     */
    @Override
    public String clickEnd() {
        return null;
    }

}
