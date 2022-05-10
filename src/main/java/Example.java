
// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("AC967c1374063811cf045498447a575809");
    public static final String AUTH_TOKEN = System.getenv("1fedaa74f7576a99d3e92656a9109a67");

    public static void main(String[] args) {
        Twilio.init("AC967c1374063811cf045498447a575809", "1fedaa74f7576a99d3e92656a9109a67");
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+972505989929"),
                        new com.twilio.type.PhoneNumber("whatsapp:+19706326327"),
                        "Hello there!")
                .create();

        System.out.println(message.getSid());
    }
}
