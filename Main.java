public class Main {
    
    public static void main(String[] args) {

        Message message = new Message();
        message.sender = 0;
        message.nextDestination = 5;
        message.finalDestination = 8;

        Mailbox.mbox_send(0, message);
        System.out.println(Mailbox.mbox_empty(0));
        Message newMessage = Mailbox.mbox_receive(0);
        System.out.println(Mailbox.mbox_empty(0));

        System.out.println(newMessage.nextDestination);
        

    }


}
