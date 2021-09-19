import java.util.*;
public class Main
{
    //all possible movements
    private static int[] x = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] y = { -1, 1, 1, -1, 2, -2, 2, -2 };
    private static ArrayList<Pair> results = new ArrayList<Pair>(); //Stores visited rows
    
    //Receives a character and returns a Number 
    public static int getNum(char x){
        int count = 0;
        char [] smallAlphabets = {'a','b','c','d','e','f','g','h'};
        char [] alphabets = {'A','B','C','D','E','F','G','H'};
        for(int i=0;i<alphabets.length;i++)
        {
            count++;
            if(x == alphabets[i] || x == smallAlphabets[i])
            {
                break;
            }
        }
        return count;
    }
    
    //Recieves a number and converts it into an alphabet A-H
    public static char getAlphabet(int x)
    {
        int count = 0;
        int [] numbers = {1,2,3,4,5,6,7,8};
        char [] alphabets = {'A','B','C','D','E','F','G','H'}; 
        for(int i=0;i<numbers.length;i++)
        {
            //count++;
            if(x == numbers[i])
            {
                count = i;
                break;
            }
        }
        return alphabets[count];
    }

    //Checks if the position to be visited is a valid position
    public static boolean isValidPosition(int x, int y)
    {
        int size = 8;
        if (x >= 1 && x <= size && y >= 1 && y <= size)
            return true;
        return false;
    }
    //Recusive call that stores all traversed Pairs
    private static void printPath(Pair pair) {
        if (pair == null) {
            return;
        }
        printPath(pair.parent);
        storeResults(pair);
    }
    
    public static void storeResults(Pair pair)
    {
         results.add(pair);    //Maintains a list of pairs
    }
    
    public static void removeFirst()
    {
        results.remove(0); //Remove the first pair in the list because we wont need that for the result
    }
    
    //Depth First Search Traversal Considering we are looking for the shortest path
    public static Pair traverseBoard(Pair startPoint,Pair endPoint)
    {
        int size = 8;
        Set<Pair> traversed = new HashSet<>(); //HashSet to represent uniquely what has been traversed
        Queue<Pair> traversal = new ArrayDeque<>();//Create a queue and make the first pair the first item in the queue
        traversal.add(startPoint);

        while(!traversal.isEmpty())
        {
            Pair head = traversal.poll(); //grab item at the top of the queue 
            int a = head.x;
            int b = head.y;

            if (a == endPoint.x && b == endPoint.y) {
                return head; //if at destination, return the pair at destination
            }
            
            if(!traversed.contains(head)) 
            {
                traversed.add(head);//Tracking parent

                for(int i =0;i<size;i++)
                {
                    int pos1 = a + x[i];
                    int pos2 = b + y[i];
                    //add valid position in traversal to the visited rows
                    if(isValidPosition(pos1,pos2)){
                        traversal.add(new Pair(pos1,pos2,head));
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        
        int size = 8;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input");
        String input = scan.nextLine();
        String[] result = input.split(" ", 2);
        
        String first = result[0];
        String last = result[1];
        
        Pair startPoint = new Pair(getNum(first.charAt(0)),Character.getNumericValue(first.charAt(1)));
        //Pair startPoint = new Pair(3, 5); //C5

        Pair endPoint = new Pair(getNum(last.charAt(0)),Character.getNumericValue(last.charAt(1)));
        //Pair endPoint = new Pair(8, 8); //G8

        Pair visitedNodes = traverseBoard(startPoint,endPoint);
        printPath(visitedNodes);
        removeFirst();
        System.out.println(results.toString().replace("[", "").replace("]", "").replace(",",""));
        
    }
}