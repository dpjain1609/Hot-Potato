import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
    
    private static int nodeCount = 0;

    public static ArrayList<Node> readGraph(String filename){
        ArrayList<Node> nodes = new ArrayList<>();

        try{
            FileInputStream inFile = new FileInputStream(filename);
            Scanner scan = new Scanner(inFile);
            
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                ArrayList<Integer> neighbors = new ArrayList<>();
                
                if(line.charAt(0) == '#'){
                    continue;
                }
                
                String newLine = line.substring(line.indexOf(":") + 1, line.length());

                StringTokenizer tokenizer = new StringTokenizer(newLine);
                while(tokenizer.hasMoreTokens()){
                    neighbors.add(Integer.parseInt(tokenizer.nextToken(",")));
                }

                nodes.add(new Node(nodeCount, neighbors));
                nodeCount++;
            }

            scan.close();
            inFile.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        for(Node node : nodes){
            node.nodeCount = nodeCount;
        }

        return nodes;
    }

    public static void printGraph(ArrayList<Node> nodes){
        for(Node node : nodes){
            System.out.print(node.nodeID + ": ");

            for(int i=0; i<node.neighbors.size(); i++){
                System.out.print(node.neighbors.get(i) + ", ");
            }
            System.out.println();
        }
    }
    
}
