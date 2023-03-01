package main.model;

import main.client.P;
import main.log.Logger;

import java.io.Serializable;

public class Message implements Serializable {

    private Integer clientOrigim;
    private Integer clientId;
    private Integer value;
    private String ip;
    private Integer port;
    private String threadName;
    private Boolean detailed;

    public Message(P client) {
        this.clientOrigim = client.getClientId();
        this.clientId = client.getClientId();
        this.detailed = client.getDetailed();
        this.threadName = Thread.currentThread().getName();
        this.ip = client.getAddress().getHostAddress();
        this.port = client.getPort();
    }

    public Message(P client, Integer value) {
        this.clientOrigim = client.getClientId();
        this.clientId = client.getClientId();
        this.detailed = client.getDetailed();
        this.threadName = Thread.currentThread().getName();
        this.ip = client.getAddress().getHostAddress();
        this.port = client.getPort();
        this.value = value;
    }

    public Integer getClientOrigim() {
        return clientOrigim;
    }

    public void setNewClient(P client){
        this.clientId = client.getClientId();
        this.detailed = client.getDetailed();
        this.threadName = Thread.currentThread().getName();
        this.ip = client.getAddress().getHostAddress();
        this.port = client.getPort();
    }

    public void setClientOrigim(Integer clientOrigim) {
        this.clientOrigim = clientOrigim;
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

    public void print(){
        if(detailed){
            Logger.print("[" + clientId + " - " + value + "]");
            Logger.online("Ip: " + ip + ":" + port);
            Logger.info("Id Origem: " + clientOrigim);
        } else {
            Logger.print("[" + clientId + " - " + value + "]");
        }

    }

}
