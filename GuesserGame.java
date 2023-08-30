import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

// Value from Guesser is set here--------------------------------------------------------------------------------------------------------------------------------
class guesser {
  int num;
    
    int guessvalue() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Throw the dice guesser!!");
      System.out.println("What's your number between 1-6?");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! You ran out of time to make a guess.");
                sc.nextLine(); // Consume newline
            }
        };
        
        try {
            timer.schedule(task, 10000); // 10 seconds
            num = sc.nextInt();
            if (num >= 1 && num <= 6) {
              System.out.println("Let's keep this number a secret from the player!");  
            } 
            else {
              System.out.println("OOPS!Looks like you entered something wrong.");
              System.out.println("You have 3 chances to roll the dice now.");
                for (int i = 1; i <= 3; i++) {
                   System.out.println("Chance No.: " +i);
                   System.out.println("Roll the dice!");
                   num = sc.nextInt();
                      if (num >= 1 && num <= 6) {
                        System.out.println("Nice roll!");
                        break;
                      }
                      else{
                        continue;
                      }
                }
            }
            if (num < 0) {
              throw new Exception("Can't give a negative number");
            }
            } 
            catch (InputMismatchException e) {
               System.out.println("Please enter a valid number.");
               sc.nextLine(); // Consume the invalid input
            }
            catch (Exception e) {
               System.out.println(e.getMessage());
            }

       return num;
    }
}

// values from player will be set here.----------------------------------------------------------------------------------------------------------------------
class player {
    int num2;
    
    int guessvalue1(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you ready "+ name);
        System.out.println("Enter your guess between 1-6!"); 
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! " + name + ", you ran out of time to make a guess.");
                sc.nextLine(); // Consume newline
            }
            };
        try {
            timer.schedule(task, 30000); // 30 seconds
            num2 = sc.nextInt();
                if (num2 >= 1 && num2 <= 6) {
                }  
                else {
                    System.out.println("OOPS!Looks like you entered something wrong "+ name);
                }
                if(num2 < 0){
                    throw new Exception("Can't have a negative number "+name);
                }
                } 
        catch (InputMismatchException e) {
            System.out.println("Please enter a valid number "+name);
            sc.nextLine(); // Consume the invalid input
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return num2;
    }
}

// Here all the rules will be set.-----------------------------------------------------------------------------------------------------------------------------------
class umpire {  
    int numfromguesser;
    String playerName1;
    String playerName2;
    String playerName3;
    int numfromplayer1;
    int numfromplayer2;
    int numfromplayer3;

//values will be taken from both classes and compared here.------------------------------- 
    void compare() {
        Scanner sc = new Scanner(System.in);
        guesser g = new guesser();
        player p = new player();
        numfromguesser = g.guessvalue();
 //Names will be taken here. 
        System.out.println("Enter you name player1.");
        playerName1 = sc.nextLine();
        numfromplayer1 = p.guessvalue1(playerName1);
        System.out.println("Enter you name player2.");
        playerName2 = sc.nextLine();
        numfromplayer2 = p.guessvalue1(playerName2);
        System.out.println("Enter you name player3.");
        playerName3 = sc.nextLine();
        numfromplayer3 = p.guessvalue1(playerName3);   
//code for comparison of the values from guesser and players.
//also we will tell whether the value is high or low.
// Value is equal------------------------------------------------------------------------------------------------ 
        if (numfromplayer1 == numfromguesser) {
            if (numfromplayer1 == numfromplayer2 && numfromplayer1 == numfromplayer3) {
                System.out.println("Guessed right by :" + playerName1 + playerName2 + playerName3);
            }
            else if (numfromplayer1 == numfromplayer2) {
                System.out.println("Guessed right by : " + playerName1 + playerName2);
            } 
            else if (numfromplayer1 == numfromplayer3) {
                System.out.println("Guessed right by : " + playerName1 + playerName3);
                
            }
            else{
               System.out.println("Guessed right by : " + playerName1);
            }
        }
        else if (numfromplayer2 == numfromguesser) {
            if (numfromplayer2 == numfromplayer3) {
               System.out.println("Guessed right by : " + playerName1 + playerName2);
            }
            else{
               System.out.println("Guessed right by : " + playerName1);
            }
        }
        else if (numfromplayer3 == numfromguesser) {
            System.out.println("Guessed right by : " + playerName3);
        }
//When guess is low------------------------------------------------------------------------------------------------ 
        if (numfromguesser > numfromplayer1) {
            if (numfromguesser > numfromplayer1 && numfromguesser > numfromplayer2 && numfromguesser > numfromplayer3) {
                System.out.println("All guessed low: " +playerName1 + playerName2 + playerName3);
            }
            else if(numfromguesser > numfromplayer1 && numfromguesser > numfromplayer2){
                System.out.println("Guess is low : " +playerName1 + playerName2);
            }
            else if(numfromguesser > numfromplayer1 && numfromguesser > numfromplayer3){
                System.out.println("Guess is low : " +playerName1 + playerName3);
            }
            else{
            System.out.println("Guess is too low : " + playerName1);
            }
        } 
        else if (numfromguesser > numfromplayer2) {
            if (numfromguesser > numfromplayer2 && numfromguesser > numfromplayer3) {
                System.out.println("Guess is low: " +playerName2 + playerName3);
            }
            else {
                System.out.println("Guess is low : " + playerName2);
            }
        }
        else if (numfromguesser > numfromplayer3) {
            System.out.println("Guess is too low : " + playerName3);
        }
//When value high.----------------------------------------------------------------------- 
        if (numfromguesser < numfromplayer3) {
            if (numfromguesser < numfromplayer1 && numfromguesser < numfromplayer2 && numfromguesser < numfromplayer3) {
                System.out.println("All guessed high: " +playerName1 + playerName2 + playerName3);
                System.out.println("You all Lost: " + playerName1 + playerName2 + playerName3);
            }
            else if(numfromguesser < numfromplayer1 && numfromguesser < numfromplayer2){
                System.out.println("Guess is high : " +playerName1 + playerName2);
            }
            else if(numfromguesser < numfromplayer1 && numfromguesser < numfromplayer3){
                System.out.println("Guess is high : " +playerName1 + playerName3);
            }
            else{
                System.out.println("Guess is too high : " + playerName1);
            }
        }  
        else if (numfromguesser < numfromplayer2) {
           if (numfromguesser < numfromplayer2 && numfromguesser < numfromplayer3) {
               System.out.println("Guess is high: " +playerName2 + playerName3);
               System.out.println("You all Lost: " + playerName1 + playerName2 + playerName3);
            }
            else {
               System.out.println("Guess is high : " + playerName2);
            }
        }  
        else if (numfromguesser < numfromplayer3) {
          System.out.println("Guess is too high : " + playerName3);
        }   
    }  
}

public class GuesserGame {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("***************||Dice Guesser Game||*****************");
        System.out.println("**********||Welcome to the Guesser Game||************");
        System.out.println("*****************************************************");
        System.out.println(" ");
        System.out.println("Rules for the game.");
        System.out.println("1.There is a need of 3 players to play this game.\n2.Guesser will get 10 sec to guess the number.\n3.Player will get 30 sec to guess \n(including entering your name or correction of any error made by you)\n4.If anything wrong is entered then Guesser gets 3 chances and player gets none.");
        System.out.println("Hit 'enter' to start the game");
        sc.nextLine();
//calling of the umpire class. 
        umpire u = new umpire();
        u.compare();
    }
}
