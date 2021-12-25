import java.util.ArrayList;
/**
 * @since 12/6/2021
 * @version 1.0
 * @author Shimaa Reda Saeed
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 * */
class Playground {
    protected String namePlayground;
    protected String namePlaygroundOwner;
    protected String location;
    protected String Payment;
    protected int Start=0,end=0;
    protected double price;

    int indexPlayground = 0;
    ArrayList <Playground> playgrounds = new ArrayList<>();//ArrayList to store playgrounds

    /**
     * @param playground
     * */
    public void AddPlayground(Playground playground)//Add playground in System
    {
        playgrounds.add(indexPlayground++,playground);
    }

    /**
     * Display Playgrounds In the System
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
                System.out.println("namePlayground: "+playgrounds.get(i).namePlayground);
                System.out.println("namePlaygroundOwner: "+playgrounds.get(i).namePlaygroundOwner);
                System.out.println("Price: "+playgrounds.get(i).price+"\n");
            }
        }
    }
    /**
     * @param namePlayground
     * @param namePlaygroundOwner
     * @param location
     * @param Payment
     * @param price
     * */
    Playground(String namePlayground,String namePlaygroundOwner,String location,String Payment,double price)//parametrize constructor
    {
        this.namePlayground=namePlayground;
        this.namePlaygroundOwner=namePlaygroundOwner;
        this.location=location;
        this.Payment=Payment;
        this.price=price;
    }
    /**
     * default constructor
     * */
    Playground(){}//default constructor

    public int arr[] = new int[13];//To store Book Time
    public int Available = 0;

    /**
     * @param start
     * @param end
     * @param obj
     * */
    public void Range(int start,int end,Playground obj)//Range of time
    {
        if(obj.Available ==0 )
        {
            insert(obj);
            obj.Available++;
        }
            for(int i=start;i<=end;i++)
            {
                if(obj.arr[i] ==0 )//Already Book
                {
                    System.out.println("Time Not Available");
                    break;
                }
                else
                {
                    System.out.println("Time Is Available and you Booked\n");
                    for(int j=start;j<end;j++)
                    {
                        obj.arr[j]=0;
                    }
                    break;
                }
            }
    }
    /**
     * @param obj
     * */

    public void insert(Playground obj)//Insert 12 hours For Time
    {
        for (int i=1;i<=12;i++)
        {
            obj.arr[i] = i;
        }
    }

    int j,tmp;
    /**
     * @param Name
     * */
    public int SearchName(String Name)//Search Name Of playground
    {
        for (j = 0;j<playgrounds.size();j++)
        {
            if(playgrounds.get(j).namePlayground.equals(Name))
            {
                tmp = j;//return index
                break;
            }
            else
            {
                tmp = -1;//not found
            }
        }
        return tmp;
    }

    /**
     * @return information About Playgrounds
     * */
    @Override
    public String toString() {//Print information About Playgrounds
        return "\nnamePlayground : " + namePlayground +"\n"+"namePlaygroundOwner : " + namePlaygroundOwner +"\n" +
                "location : " + location + "\n" + "Payment : " + Payment + "\n" + "Price : " + price+"\n";
    }
}