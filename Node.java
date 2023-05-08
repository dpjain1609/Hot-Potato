import java.util.ArrayDeque;
import java.util.ArrayList;

public class Node {
    
    public int nodeID;
    public int nodeCount;
    public ArrayList<Integer> neighbors;
    private ArrayDeque<byte[]> buffer;

    public Node(int nodeID){
        this.nodeID = nodeID;
        this.neighbors = new ArrayList<>();
    }

    public Node(int nodeID, ArrayList<Integer> neighbors){
        this.nodeID = nodeID;
        this.neighbors = neighbors;
    }

    public void send(){
        
        Message message = new Message();

        //select a random destination
        int nextDestinationIndex = (int)RandomNumberGenerator.rand_range(0, this.neighbors.size());
        int finalDestinationIndex = (int)RandomNumberGenerator.rand_range(0, nodeCount);        
        message.sender = this.nodeID;
        message.nextDestination = this.neighbors.get(nextDestinationIndex);
        message.finalDestination = finalDestinationIndex;
        
        Mailbox.mbox_send(nextDestinationIndex, message);
        
    }

    public void receive(){

        Message receivedMessage = Mailbox.mbox_receive(this.nodeID);

        if(receivedMessage == null){
            return;
        }

        //cooldown time
        try {
            Thread.sleep((long)RandomNumberGenerator.rand_exponential(3) * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //if this node is not final destination
            //remove receivedMessage.source from list of neighbors;
        
            //pick random neighbor

            //see if final destination is one of the direct neighbors, if yes, send it directly



    }
}
