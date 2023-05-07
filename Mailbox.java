import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Mailbox{
    
    class Item{
        public int size;
        public byte[] content;
    }
    
    private static Map<Integer, ArrayDeque<Item>> mailboxes;
    
    private Mailbox(){
        this.mailboxes = new HashMap<>();
    }

    private static Mailbox _mailbox = new Mailbox();

    //API function - these are the only ones that can be used
    public static boolean mbox_empty(int mailboxID){
        return _mailbox.empty(mailboxID);
    }

    public static int mbox_send(int mailboxID, Object object, int size){
        return _mailbox.send(mailboxID, object, size);
    }

    public static int mbox_receive(int mailboxID, byte[] buffer, int size){
        return _mailbox.receive(mailboxID, buffer, size);
    }

    private boolean empty(int mailboxID){
        if(!mailboxes.containsKey(mailboxID)){
            return true;
        }

        return mailboxes.get(mailboxID).isEmpty();
    }

    private int send(int mailboxID, Object object, int size){
        if(!mailboxes.containsKey(mailboxID)){
            mailboxes.put(mailboxID, new ArrayDeque<>());
        }
        
        Item item = new Item();

        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            item.size = size;
            item.content = bos.toByteArray();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        mailboxes.get(mailboxID).add(item);
        return size;
    }

    private int receive(int mailboxID, byte[] buffer, int max){
        if(!mailboxes.containsKey(mailboxID)){
            return 0;
        }

        Item item = mailboxes.get(mailboxID).pop();

        if(item.size > max){
            return -1;
        }

        buffer = item.content;

        return item.size;
    }
}