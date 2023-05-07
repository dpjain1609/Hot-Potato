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

    public Node(int nodeID, ArrayList<Integer> neighbors, int nodeCount){
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
        
        
        

    }

    public void receive(){

    }
}
