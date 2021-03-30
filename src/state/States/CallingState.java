package state.States;

import state.State;
import phone.Phone;


public class CallingState {
    public CallingState(Phone phone) {
        super(phone);
    }

    /**
     * В режиме разговора мы не можем ответить на звонок
     * @return null
     */
    @Override
    public String clickAnswer) {
        return null;
    }

    /**
     * В режиме разговора мы не можем позвонить
     * @return null
     */
    @Override
    public String call) {
        return null;
    }

    /**
     * Мы можем сбросить звонок при разговоре и перейти в режим ожидания
     * @return String
     */
    @Override
    public String clickEnd() {
        phone.changeState(new WaitingState(phone));
        return this.getClass().getName() + " -> CallingState" + " -> WaitingState";
    }

}
