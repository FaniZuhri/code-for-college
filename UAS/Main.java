package UAS;

import java.util.Scanner;

// Class
public class Main {

	// Main driver method
	public static void main(String[] args) {
		// Creating listBookject of Scanner class
		// to take input from user
		try (Scanner input = new Scanner(System.in)) {
			// Displaying menu
			System.out.println(
					"********************Welcome to the Library!********************");
			System.out.println(
					"				 Select From The Following Options:			 ");
			System.out.println(
					"**********************************************************************");

			// Creating listBookject of book class
			Books listBook = new Books();
			// Creating listBookject of Members class
			Members listMember = new Members();

			int choice;
			int searchChoice;

			// Creating menu
			// using do-while loop
			do {

				listBook.dispMenu();
				System.out.print("\nUser Input: ");
				choice = input.nextInt();
				System.out.println();

				// Switch case
				switch (choice) {
					case 1:
						Book b = new Book();
						listBook.addBook(b);
						break;
					case 2:
						listBook.upgradeBookQty();
						break;
					case 3:
						System.out.println(
								" press 1 to Search with Book Serial Number");
						System.out.println(
								" Press 2 to Search with Book's Author Name");
						System.out.print("\nUser Input: ");
						searchChoice = input.nextInt();
						System.out.println();

						// Nested switch
						switch (searchChoice) {
							case 1:
								listBook.searchBySerialNumber();
								break;
							case 2:
								listBook.searchByAuthorName();
								break;
						}
						break;
					case 4:
						listBook.showAllBooks();
						break;
					case 5:
						MemberBasic memberBasic = new MemberBasic();
						listMember.addMember(memberBasic);
						break;
					case 6:
						MemberVip memberVip = new MemberVip();
						listMember.addMember(memberVip);
						break;
					case 7:
						listMember.showAllMembers();
						break;
					case 8:
						listMember.checkOutBook(listBook);
						break;
					case 9:
						listMember.checkInBook(listBook);
						break;
					default: // Print statement
						System.out.println("ENTER BETWEEN 0 TO 8.");
				}
			}

			// Checking condition at last where we are
			// checking case entered value is not zero
			while (choice != 0);
		}
	}
}
