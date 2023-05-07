import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {

        Message message = new Message();
        message.sender = 0;
        message.nextDestination = 5;
        message.finalDestination = 8;
        byte[] buffer = new byte[128];
        System.out.println(Mailbox.mbox_send(0, message, 16));
        System.out.println(Mailbox.mbox_empty(0));
        System.out.println(Mailbox.mbox_receive(0, buffer, 128));
        System.out.println(Mailbox.mbox_empty(0));

        Message newMessage = new Message();
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = new ObjectInputStream(bis);
            newMessage = (Message)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(newMessage.nextDestination);
        //float rand = RandomNumberGenerator.rand_exponential(5);
        //System.out.println(rand);

    }


}
