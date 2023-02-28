package main;

import java.io.Serializable;

public class Message implements Serializable {

    private Integer clientId;
    private Integer value;

    public Message(Integer clientId) {
        this.clientId = clientId;
    }

    public Message(Integer clientId, Integer value) {
        this.clientId = clientId;
        this.value = value;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isClientIdEven(){
        return this.clientId % 2 == 0;
    }

    @Override
    public String toString() {
        return "[" + clientId + " - " + value + "]";
    }

}
