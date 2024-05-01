package algoten;
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class AlgoCh10
{
    private static Scanner input = new Scanner(System.in);
    private static Games user1 = new Games();
    private static Games user2 = new Games();
    
    private static String userInput = "";
    
	private static void displayIntro(){
	    System.out.println("####################### Math Games ########################");
	    System.out.println("Details:");
	    System.out.println("1. Given two random numbers from 1 to 10");
	    System.out.println("2. There's two users which has to answer the sum of two numbers");
	    System.out.println("3. For each correct answers will get 50 points");
	    System.out.println("4. User that reach 100 points first will be decided as winner");
	    System.out.println();
	    
	    while (true){
	        System.out.print("Type \"Start\" to start the game: ");
	        userInput = input.nextLine();
	        
	        if (!userInput.equalsIgnoreCase("start")){
	            System.out.println("Wrong input!");
	            continue;
	        }
	        
	        break;
	    }
	    
	    System.out.println("####################### Games Begin ########################");
	}
	
	private static void calcAndDisplayBothPoint(){
	    Games.correctAns = Games.firstNum + Games.secondNum;
	    
	    if (user1.userAns == Games.correctAns) user1.currentPoint += Games.correctAnswerPoint;
	    if (user2.userAns == Games.correctAns) user2.currentPoint += Games.correctAnswerPoint;
	    
	    System.out.println("Correct Answer: " + Games.correctAns);
	    System.out.println("Points given:");
	    System.out.println("User 1: " + user1.currentPoint);
	    System.out.println("User 2: " + user2.currentPoint);
	}
	
	private static void calcAndDisplayBothTotalPoint(){
	    user1.totalPoint += user1.currentPoint;
	    user2.totalPoint += user2.currentPoint;
	    
	    System.out.println("Total points:");
	    System.out.println("User 1: " + user1.totalPoint);
	    System.out.println("User 2: " + user2.totalPoint);
	}
	
	private static boolean isWinnerHasBeenDecided(){
	    boolean ret = false;
	    boolean isUser1Win = user1.totalPoint >= Games.winnerPoints;
	    boolean isUser2Win = user2.totalPoint >= Games.winnerPoints;
	    String userWinName = "";
	    
	    if (isUser2Win && isUser1Win) {
	        userWinName = "Both";
	        ret = true;
	    }
	    else if (isUser1Win){
	        userWinName = "User 1";
	        ret = true;
	    }
	    else if (isUser2Win){
	        userWinName = "User 2";
	        ret = true;
	    }
	    
	    if (ret == true){
	        System.out.println("####################### Winner Has Been Decided ########################");
	        System.out.println("Winner is " + userWinName);
	        System.out.println("####################### Games Ended ########################");
	    }
	    
	    return ret;
	    
	}
	
	public static void main(String[] args) {
		boolean isGameDone = false;
		int questionNum = 0;
		
		displayIntro();
		
		
		while (!isGameDone){
		    questionNum += 1;
		    
		    user1.currentPoint = user2.currentPoint = 0;
		    
		    Games.randomizeFirstNum();
		    Games.randomizeSecondNum();
		    
		    System.out.println();
		    System.out.println();
		    
		    System.out.println(questionNum + ". " + Games.firstNum + " + " + Games.secondNum);
		    
		    System.out.print("User 1: ");
		    user1.guessResult();
		    
		    System.out.print("User 2: ");
		    user2.guessResult();
		    
		    System.out.println();
		    System.out.println("########################### Result ########################");
		    calcAndDisplayBothPoint();
		    
		    System.out.println();
		    System.out.println("########################### Total Point ########################");
		    calcAndDisplayBothTotalPoint();
		    
		    isGameDone = isWinnerHasBeenDecided();
		}
		
	}
}
