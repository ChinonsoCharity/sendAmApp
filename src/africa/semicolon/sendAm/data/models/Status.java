package africa.semicolon.sendAm.data.models;

import java.time.LocalDateTime;

public class Status {
    private final LocalDateTime dateTime = LocalDateTime.now();

//    public Status(String status){
//        this.status = status;
//        LocalDateTime dateTime = LocalDateTime.now();
//    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  String status;
}
