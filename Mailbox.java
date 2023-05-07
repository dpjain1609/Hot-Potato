import java.util.*;

public class Mailbox{
    
    private Map<Integer, ArrayDeque<Message>> mailboxes;
    //TODO explicity locking
    
    private Mailbox(){
        this.mailboxes = new HashMap<>();
    }

    private static Mailbox _mailbox = new Mailbox();

    //API function - these are the only ones that can be used
    public static boolean mbox_empty(int mailboxID){
        return _mailbox.empty(mailboxID);
    }

    public static void mbox_send(int mailboxID, Message message){
        _mailbox.send(mailboxID, message);
    }

    public static Message mbox_receive(int mailboxID){
        return _mailbox.receive(mailboxID);
    }

    private boolean empty(int mailboxID){
        if(!mailboxes.containsKey(mailboxID)){
            return true;
        }

        return mailboxes.get(mailboxID).isEmpty();
    }

    private void send(int mailboxID, Message message){
        if(!mailboxes.containsKey(mailboxID)){
            mailboxes.put(mailboxID, new ArrayDeque<>());
        }
        
        mailboxes.get(mailboxID).add(message);
    }

    private Message receive(int mailboxID){
        if(!mailboxes.containsKey(mailboxID)){
            return null;
        }

        return mailboxes.get(mailboxID).pop();
    }
}