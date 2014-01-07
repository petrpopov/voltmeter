package com.petrpopov.voltmeter.web.other;

import java.io.Serializable;

/**
 * Created by petrpopov on 07.01.14.
 */

public class Message implements Serializable {

    private MessageState state;
    private String message;
    private Object value;

    public static Message okMessage() {
        return okMessage(null, null);
    }

    public static Message okMessage(String message) {
        return okMessage(message, null);
    }

    public static Message okMessage(Object value) {
        return okMessage(null, value);
    }

    public static Message okMessage(String message, Object value) {
        Message res = new Message();
        res.setState(MessageState.ok);
        res.setMessage(message);
        res.setValue(value);
        return res;
    }

    public MessageState getState() {
        return state;
    }

    public void setState(MessageState state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
