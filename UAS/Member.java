package UAS;
// Importing required classes
import java.util.Scanner;

// Class
public class Member {

	// Class member variables
	String memberName;
	String regNum;

	Book borrowedBooks[] = new Book[3];
	public int booksCount = 0;

	// Creating object of Scanner class to
	// take input from user
	Scanner input = new Scanner(System.in);

	// Constructor
	public Member()
	{
		// Print statement
		System.out.println("Enter Member Name:");

		// This keywords refers to current instance
		this.memberName = input.nextLine();

		// Print statement
		System.out.println("Enter Registration Number:");
		this.regNum = input.nextLine();
	}
}
