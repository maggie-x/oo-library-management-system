package oo.study.library;

public class Notification {

    public String getMessage() {
        return message;
    }

    String message;
    String createDate;

    public Notification(String message) {
        this.message = message;
        // TODO initialize create date
    }

}
