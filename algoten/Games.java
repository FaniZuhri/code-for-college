package algoten;
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class Games
{
	public static Random rand = new Random();
	
	public static int firstNum, secondNum, correctAns;
	public static int correctAnswerPoint = 50, winnerPoints = 100;
	
	public int currentPoint = 0, totalPoint = 0, userAns = 0;
	
	public static void randomizeFirstNum() {
	    firstNum = rand.nextInt(10) + 1;
	}
	
	public static void randomizeSecondNum() {
	    secondNum = rand.nextInt(10) + 1;
	}
	
    public void guessResult(){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What's the result?");
        userAns = userInput.nextInt();
    }
	
}
