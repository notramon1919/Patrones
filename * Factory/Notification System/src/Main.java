abstract class Notification {
    abstract void sendNotification();

    static Notification factory(String destination){
        if (destination.contains("@")){
            return new EmailNotification();
        } else if (destination.contains("http")){
            return new PushNotification();
        } else {
            return new SMSNotification();
        }
    }
}

class SMSNotification extends Notification {
    @Override
    public void sendNotification(){
        System.out.println("SENDING SMS to: +34 678 789 890");
    }
}
class EmailNotification extends Notification {
    @Override
    public void sendNotification(){
        System.out.println("SENDING Email to: gerard@benigaslo.com");
    }
}
class PushNotification extends Notification {
    @Override
    public void sendNotification(){
        System.out.println("SENDING Push to: http://benigaslo.com/gerard");
    }
}

public class Main {
    public static void main(String[] args) {

        Notification.factory("gerard@benigaslo.com").sendNotification();
        Notification.factory("http://benigaslo.com/gerard").sendNotification();
        Notification.factory("+34 678 789 890").sendNotification();
    }
}
