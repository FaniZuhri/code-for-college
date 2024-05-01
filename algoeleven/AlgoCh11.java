package algoeleven;
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlgoCh11
{
	private static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
	    Schedule schedule = new Schedule();
	    String name;
	    
        System.out.println("Masukkan lima nama untuk menentukan jadwal secara acak");
        
	    for(int i = 0; i < schedule.maxDay; i++){
	        System.out.print((i + 1) + ". Nama: ");
	        name = userInput.nextLine();
	        
	        schedule.setNameToInputList(name, i);
	    }
	    System.out.println("Hasil penentuan jadwal acak");
	    
	    schedule.displayRandomSchedule();
	    
	}
}

class Schedule {
    public int maxDay = 5;
    private final int dayCol = 0;
    private final int nameCol = 1;
	
	private String[][] scheduleArray = {
        {"Senin",   ""},
        {"Selasa",  ""},
        {"Rabu",    ""},
        {"Kamis",   ""},
        {"Jumat",   ""}
    };
	private String[] nameInputList = new String [maxDay];
    private List<Integer> randomArray = new ArrayList<>(maxDay);
	
	private void generateUniqueRandNum(){
        for (int i = 0; i < maxDay; i++) {
            randomArray.add(i);
        }

        Collections.shuffle(randomArray);
    }
	
	private void setNameListToSchedule(){
	    for (int row = 0; row < maxDay; row++){
	        scheduleArray[row][nameCol] = nameInputList[randomArray.get(row)];
	    }
	}
	
	public void setNameToInputList(String name, int row){
	    nameInputList[row] = name;
	}
	
	public void displayRandomSchedule(){
	    generateUniqueRandNum();
	    setNameListToSchedule();
	    
	    for (int row = 0; row < maxDay; row++){
	        System.out.println(scheduleArray[row][dayCol] + ": " + scheduleArray[row][nameCol]);
	    }
	}
}
