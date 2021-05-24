package com.state.States;

import com.phone.Phone;
import com.state.State;
import org.springframework.stereotype.Component;

@Component
public class CallingState extends State {
    public CallingState(Phone phone) {
        super(phone);
    }

    /**
     * Добавлено для удобства работы совершения звонков
     * Чтобы не обращаться к названию состояния и балансу, используем метод callable
     * Он проверяет возможность совершить звонок в данном состоянии телефона
     * Во время вызова мы не можем позвонить ещё раз
     *
     * @return boolean
     */
    @Override
    public boolean callable() {
        return false;
    }

    /**
     * В режиме разговора мы не можем ответить на звонок
     *
     * @return null
     */
    @Override
    public String clickAnswer() {
        return null;
    }

    /**
     * В режиме разговора мы не можем позвонить
     *
     * @return null
     */
    @Override
    public String call() {
        return null;
    }

    /**
     * Мы можем сбросить звонок при разговоре и перейти в режим ожидания
     *
     * @return String
     */
    @Override
    public String clickEnd() {
        phone.changeState(new WaitingState(phone));
        return this.getClass().getName() + " -> clickEnd" + " -> WaitingState";
    }

}
