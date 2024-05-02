package UAS;

import java.util.Scanner;

// Class
public class Members {

	// Creating objects of Scanner and members class
	Scanner input = new Scanner(System.in);
	Member members[] = new Member[50];
	public static int count = 0;

	// Method 1
	// To add books
	public void addMember(Member s) {
		for (int i = 0; i < count; i++) {

			if (s.regNum.equalsIgnoreCase(
					members[i].regNum)) {

				// Print statement
				System.out.println(
						"Member of Reg Num " + s.regNum
								+ " is Already Registered.");

				return;
			}
		}

		if (count <= 50) {
			members[count] = s;
			count++;
		}
	}

	// Method 2
	// Displaying all members
	public void showAllMembers() {
		// Printing Member name and
		// corresponding registered number
		System.out.println("Member Name\tReg Number\tGroup\tMax Ownership");
		for (int i = 0; i < count; i++) {

			System.out.println(members[i].memberName
					+ "\t\t"
					+ members[i].regNum
					+ "\t\t"
					+ members[i].groupName
					+ "\t\t"
					+ members[i].maxBooksCount);
		}
	}

	// Method 3
	// To check the Member
	public int isMember() {
		this.showAllMembers();
		// Display message only
		System.out.println("Enter Reg Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++) {

			if (members[i].regNum.equalsIgnoreCase(
					regNum)) {
				return i;
			}
		}

		// Print statements
		System.out.println("Member is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// Method 4
	// To remove the book
	public void checkOutBook(Books book) {
		int memberIndex = this.isMember();

		if (memberIndex != -1) {
			System.out.println("checking out");

			book.showAllBooks();
			Book b = book.checkOutBook();

			System.out.println("checking out");
			if (b != null) {

				if (members[memberIndex].booksCount < members[memberIndex].maxBooksCount) {

					System.out.println("adding book");
					members[memberIndex].borrowedBooks[members[memberIndex].booksCount] = b;
					members[memberIndex].booksCount++;

					return;
				} else {

					System.out.println(
							"Member Can not Borrow more than " + (members[memberIndex].maxBooksCount) + " Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}

	// Method 5
	// To add the book
	public void checkInBook(Books book) {
		int memberIndex = this.isMember();
		if (memberIndex != -1) {

			// Printing credentials corresponding to Member
			System.out.println(
					"S Num\t\t\tBook Name\t\t\tAuthor Name");

			Member s = members[memberIndex];

			for (int i = 0; i < s.booksCount; i++) {

				System.out.println(
						s.borrowedBooks[i].serialNumber + "\t\t\t"
								+ s.borrowedBooks[i].bookName + "\t\t\t"
								+ s.borrowedBooks[i].authorName);
			}

			// Display message only
			System.out.println(
					"Enter Serial Number of Book to be Checked In:");

			int serialNumber = input.nextInt();

			for (int i = 0; i < s.booksCount; i++) {
				if (serialNumber == s.borrowedBooks[i].serialNumber) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;

					return;
				}
			}

			System.out.println("Book of Serial No " + serialNumber
					+ "not Found");
		}
	}
}