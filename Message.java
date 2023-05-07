import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{
    public int sender;
    public int nextDestination;
    public int finalDestination;

    public int hopCount = 0;
    public ArrayList<Integer> nodesVisited = new ArrayList<>();
}
