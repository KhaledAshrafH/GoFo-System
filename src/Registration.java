import java.util.ArrayList;
import java.util.Scanner;
/**
 * @since 12/6/2021
 * @version 1.0
 * @author Shimaa Reda Saeed
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 *for login, Register , check User
 * */
public class Registration {//for login, Register , check User
    Scanner input = new Scanner(System.in);
    /**
     * String userName of player or playgroundOwner
     * */
    protected String userName;
    /**
     * String password of player or playgroundOwner
     * */
    protected String password;
    /**
     * String email of player or playgroundOwner
     * */
    protected String email;
    /**
     * String phone of player or playgroundOwner
     * */
    protected String phone;
    /**
     * String userType of player or playgroundOwner
     * */
    protected String userType="";

    /**
     * @return password
     * Getters
     * */
    public String getPassword() {
        return password;
    }
    /**
     * @return userName
     * Getters
     * */
    public String getUserName() {
        return userName;
    }

    String str;//To check if user player or playground Owner
    boolean Bool = false;//check if Account valid or not
    /**
     * @param userName
     * userName of player or playgroundOwner
     * @param password
     * password of player or playgroundOwner
     * @param s
     * Type
     * @return Bool
     * Login
     * */
    public boolean Login(String userName, String password,String s)
    {
        str=s;//Type of User
        if(CheckUser(userName,password))
        {
            this.userName=userName;this.password=password;
            Bool = true;
        }
        else
        {
            System.out.println("Not Found Account");
            Bool = false;
        }
        return Bool;//Return State of User
    }

    int indexOfPlayers=0,indexOfPlaygroundOwner=0;
    ArrayList<Registration> Players = new ArrayList<>();//ArrayList to store players Accounts
    ArrayList<Registration> PlaygroundOwners = new ArrayList<>();//ArrayList to store playground owner Accounts

    /**
     * @param Kind
     * Player or PlaygroundOwner
     * */
    public void Register(String Kind)
    {
        Registration R = new Registration();//new object from Registration

        //enter username information
        System.out.println("Enter Your information");
        System.out.print("Enter Your Name : ");
        R.userName = input.next();
        System.out.print("Enter Your Password : ");
        R.password = input.next();
        System.out.print("Enter Your phone : ");
        R.phone = input.next();
        System.out.print("Enter Your Email : ");
        R.email = input.next();

        if(Kind.equals("1"))//Account is player
        {
            R.userType="Player";
            Players.add(indexOfPlayers++,R);//
        }
        else if (Kind.equals("2"))//Account is playground owner
        {
            R.userType="PlaygroundOwner";
            PlaygroundOwners.add(indexOfPlaygroundOwner++,R);
        }
        else
        {
            System.out.println("NOt Recognize Type! ");
        }
    }
    boolean check = false;//State of Check User

    /**
     * @param Username
     * userName of player or playgroundOwner
     * @param Password
     * password of player or playgroundOwner
     * @return check
     * */
    public boolean CheckUser(String Username,String Password)
    {
        if(str.equals("Player"))//Option 1 is player
        {
            if(Players.isEmpty())//if ArrayList to store players Accounts is Empty
            {
                check = false;
            }
            else
            {
                for(int i=0;i<Players.size();i++)
                {
                    if(Players.get(i).getUserName().equals(Username))//check if user name already stored in System or not
                    {
                        if(Players.get(i).getPassword().equals(Password))//check its Password
                        {
                            System.out.println("Login Successfully\n");
                            check = true;
                            break;
                        }
                        else
                        {
                            check = false;
                            break;
                        }
                    }
                    else
                    {
                        check = false;
                    }
                }
            }

        }//end player
        else if(str.equals("PlaygroundOwner")) //Option 2 is PlaygroundOwner
        {
            if(PlaygroundOwners.isEmpty())//if ArrayList to store playground owner is Empty
            {
                check=false;
            }
            else
            {
                for(int i=0;i<PlaygroundOwners.size();i++)
                {
                    if(PlaygroundOwners.get(i).getUserName().equals(Username))//check if user name already stored in System or not
                    {
                        if(PlaygroundOwners.get(i).getPassword().equals(Password))//check its Password
                        {
                            System.out.println("Login Successfully\n");
                            check = true;
                            break;
                        }
                        else
                        {
                            check = false;
                            break;
                        }
                    }
                    else
                    {
                        check = false;
                    }
                }
            }
        }
            return check;
    }

    /**
     * @return Information Accounts
     * */
    @Override
    public String toString() {//To print Information Accounts
        return  "\nUsername : " + userName + "\n" +"Password : " + password + "\n" +"Email : " + email + "\n" +"Phone : " + phone + "\n" +
                "UserType : " + userType + "\n";
    }
}