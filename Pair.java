import java.util.*;
 
// Pair to strore positions
public class Pair {
    //x, y values to represent a spot on the chessboard (x and y coordinate)
    int x, y;
    Pair parent;
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Pair(int x, int y,Pair parent)
    {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

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

    //Recieves a number and converts it into an alphabet A-H;
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
    
    //How we want the solution to appear
    public String toString()
    {
         return getAlphabet(x) +""+y ;   
    }
}