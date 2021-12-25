import java.util.Scanner;
/**
 * @since 12/6/2021
 * @version 1.0
 * @author Shimaa Reda Saeed
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 * */
public class Player {
    /**
     * String namePlayground
     * */
    protected String namePlayground;

    Scanner input = new Scanner(System.in);
    int start , end , index = -1;
    /**
     * @param playground
     * Booking playground
     * */
    public void Book( Playground playground)
    {
        if(playground.playgrounds.isEmpty())//if ArrayList to store playgrounds is Empty
        {
            System.out.println("Not Available Playgrounds");
        }
        else
        {
            playground.displayPlaygrounds();//Display information playgrounds in System
            System.out.print("Choose NamePlayground : ");
            namePlayground = input.next();
            index = playground.SearchName(namePlayground);//Return index of position playground
            if(index != -1)//if Name found
            {
                System.out.println(playground.playgrounds.get(index));//get Index
                //Book Range
                System.out.print("Enter Start Time : ");
                start = input.nextInt();
                System.out.print("Enter End Time : ");
                end = input.nextInt();
                playground.Range(start,end,playground.playgrounds.get(index));
            }
            else
            {
                System.out.println("This playground Not found");
            }
        }
    }
}