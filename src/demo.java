import java.util.Scanner;
/**
 * @since 12/6/2021
 * @version 1.0
 * @author Shimaa Reda Saeed
 * @author Khaled Ashraf Hanafy
 * @author Ahmed Sayed Hassan
 * */
public class demo {
    /**
     * @param args
     * Main menu (demo)
     * */
    static public void main(String args []){
        Scanner input=new Scanner(System.in);
        System.out.println("System Football");
        String check="";//option in menu choose
        String checkType="";//Check if User is Player Or playground owner
        //objects from classes
        Registration Register=new Registration();
        Playground playground ;
        PlaygroundOwner playgroundowner = new PlaygroundOwner();
        Player player = new Player();
        Playground obj = new Playground();

        System.out.print("1-Player\n2-PlaygroundOwner\n");
        checkType = input.next();
       while (true)
       {
           if(checkType.equals("1"))//menu is player
           {
               System.out.println("\nPlayer System");

               System.out.print("1-Login\n2-Register\n3-Transform to playgroundOwner\n4-Close\n");
               check=input.next();

                boolean StaySignIn = true;
               if(check.equals("1"))//if User Enter Number 1 (Login)
               {
                   //Enter information Account
                   String Name,Password;
                   System.out.println("Enter Your information");
                   System.out.print("Enter Your Name : ");
                   Name=input.next();
                   System.out.print("Enter Your Password : ");
                   Password=input.next();

                   if(Register.Login(Name,Password,"Player"))//login
                   {
                       while (StaySignIn)
                       {
                           player.Book(obj);//Booking
                           System.out.println("Book another? : 1-yes 2-No");
                           String str =input.next();
                           if(str.equals("1"))//Book another
                           {
                               StaySignIn = true;//stay login
                           }
                           else if(str.equals("2"))//log-out
                           {
                               System.out.println("Successful log-out");
                               StaySignIn = false;
                           }
                           else
                           {
                               System.out.println("Invalid Number! ");
                           }
                       }
                   }

               }
               else if (check.equals("2"))//register
               {
                   Register.Register(checkType);
               }
               else if(check.equals("3"))//transform to menu of playground owner
               {
                   checkType="2";
               }
               else if(check.equals("4"))//exit program
               {
                   System.exit(0);
               }
               else
               {
                   System.out.println("Invalid Choose Number!");
               }

           }//end menu player
           else if(checkType.equals("2"))//menu playgroundOwner
           {
               System.out.println("\nPlaygroundOwner System");
               System.out.print("1-Login\n2-Register\n3-Transform to player\n4-Close\n");
               check=input.next();
               if(check.equals("1"))//if User Enter Number 1 (Login)
               {    //Enter Account
                   String Name,Password;
                   System.out.println("Enter Your information");
                   System.out.print("Enter Your Name : ");
                   Name=input.next();
                   System.out.print("Enter Your Password : ");
                   Password=input.next();

                   if(Register.Login(Name,Password,"PlaygroundOwner"))//if Account already Existing
                   {
                        boolean StaySignIn=true;
                        while (StaySignIn)
                        {
                            playground = new Playground();//Add new playground
                            String namePlayground;String location;String Payment;double price;
                            System.out.print("Enter namePlayground : ");
                            namePlayground=input.next();

                            System.out.print("Enter location : ");
                            location=input.next();
                            System.out.print("Enter Payment : ");
                            Payment=input.next();
                            System.out.print("Enter price : ");
                            price=input.nextInt();

                            playground.namePlayground = namePlayground;
                            playground.namePlaygroundOwner = Register.userName;
                            playground.location=location;
                            playground.Payment=Payment;
                            playground.price=price;

                            playgroundowner.AddPlayground(playground);
                            obj.AddPlayground(playground);

                            System.out.println("Add another? : 1-yes 2-No");//Add another playground?
                            String str =input.next();
                            if(str.equals("1"))//yes and stay login
                            {
                                StaySignIn = true;
                            }
                            else if(str.equals("2"))//log-out
                            {
                                System.out.println("Successful log-out");
                                StaySignIn = false;
                            }
                            else
                            {
                                System.out.println("Invalid Number! ");
                            }

                        }
                    }

               }
               else if (check.equals("2"))//Register playgroundOwner account
               {
                   Register.Register(checkType);
               }
               else if(check.equals("3"))//Transform To play menu Player
               {
                   checkType="1";
               }
               else if(check.equals("4"))//exit program
               {
                   System.exit(0);
               }
               else
               {
                   System.out.println("Invalid Choose Number!");
               }
           }
           else
           {
               System.out.println("Invalid Choose Number!");
               break;
           }
       }
    }
}