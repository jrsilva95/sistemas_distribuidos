package main;

import java.time.LocalDateTime;

public class Log {

    private LocalDateTime time;

    private String address;
    private Message message;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" +
                "time=" + time +
                ", address='" + address + '\'' +
                ", message=" + message +
                '}';
    }

}
