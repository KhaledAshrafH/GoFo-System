import java.util.ArrayList;
import java.util.Scanner;
/**
 * @since 12/6/2021
 * @version 1.0
 * @author Shimaa Reda Saeed
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 * */
public class PlaygroundOwner {
    Scanner input=new Scanner(System.in);

    ArrayList<Playground> playgrounds = new ArrayList<>();//ArrayList to store playgrounds

    /**
     *Display Playgrounds In the System
     * */
    public void displayPlaygrounds()//Display Playgrounds In the System
    {
        if(playgrounds.isEmpty())//if ArrayList to store playgrounds is Empty
        {
         System.out.println("Not Found Playground");
        }
        else
        {
            for (int i=0;i<playgrounds.size();i++)//print Playground name, PlaygroundOwner name and Price
            {
                System.out.println("Playground Name : "+playgrounds.get(i).namePlayground);
                System.out.println("PlaygroundOwner Name : "+playgrounds.get(i).namePlaygroundOwner);
                System.out.println("Price : "+playgrounds.get(i).price+"\n");
            }
        }
    }
    /**
    * @param playground
     * Add new Playground
    * */
    public void AddPlayground(Playground playground)
    {
        playgrounds.add(playground);
    }

    int arr[] = new int[13];//To store Book Time
    int Available = 0;

    /**
     * @param start
     * Start Time
     * @param end
     * end Time
     * */
    public void Range(int start,int end)//Range of time
    {
        if(Available == 0)
        {
            insert();
            Available++;
        }
        for(int i=start;i<=end;i++)
        {
            if(arr[i] == 0 )//Already Book
            {
                System.out.println("Time Not Available\n");
                break;
            }
            else
            {
                System.out.println("Time Is Available and you Booked\n");
                for(int j=start;j<end;j++)
                {
                    arr[j] = 0;
                }
                break;
            }
        }
    }

    /**
     * Insert 12 hours For Time
     * */
    public void insert()//Insert 12 hours For Time
    {
        for (int i=1;i<=12;i++)
        {
            arr[i]=i;
        }
    }
}