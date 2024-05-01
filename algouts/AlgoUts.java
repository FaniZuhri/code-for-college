package algouts;
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class AlgoUts
{
	private static Scanner userInput = new Scanner(System.in);
	
	private static Card blackJackCard = new Card();
	private static Player userPlayer = new Player();
	private static Player systemPlayer = new Player();
    
    private static boolean isUserLose(){
        boolean result = false;
        if (userPlayer.isBust()){
            result = true;
        }
        
        if (systemPlayer.isBlackJack()){
            result = true;
        }
        
        if (userPlayer.getTotalCardCalculation() < systemPlayer.getTotalCardCalculation()){
            result = true;
        }
        
        return result;
    }
    
    private static String checkResult(){
        String result = "Win";
        
        if (userPlayer.getTotalCardCalculation() == systemPlayer.getTotalCardCalculation()){
            result = "Draw";
        }
        
        if (isUserLose()){
            result = "Lose";
        }
        
        if (systemPlayer.isBust()) {
            result = "Win";
        }
        
        return result;
    }
    
    private static boolean isUserGameDone(){
        boolean isDone = false;
        
        if (userPlayer.isBust()){
            isDone = true;
        }
        
        if (userPlayer.isBlackJack()){
            isDone = true;
        }
        
        return isDone;
    }
    
    private static boolean isSystemGameDone(){
        boolean result = false;
        
        if (checkResult() == "Lose" || checkResult() == "Draw"){
            result = true;
        }
        
        if (systemPlayer.isBust()){
            result = true;
        }
        
        return result;
    }
	
	private static boolean isWantToStop(){
	    String userConfirm = "";
	    boolean confirmation = false;
	    while (true){
    	    System.out.println("Do you want to hit or stand? (hit/stand)");
    	    
    	    userConfirm = userInput.nextLine();
    	    
    	    if (!userConfirm.equalsIgnoreCase("hit") && !userConfirm.equalsIgnoreCase("stand")){
    	        System.out.println("Unknown response, ask again the same question");
    	        continue;
    	    }
    	    
    	    if (userConfirm.equalsIgnoreCase("hit")){
    	        confirmation = false;
    	    }
    	    else{
    	        confirmation = true;
    	    }
    	    
    	    break;
	    }
	    
	    return confirmation;
	}
	
	private static boolean isLastTurn(int turn){
	    return turn == 4;
	}
	
	private static boolean isCardExist(int turn, String cardNumber, String[][] cardArray){
        boolean result = false;
        
        for(int row = 0; row < turn; row++){
            if (cardArray[row][1].equals(cardNumber)){
                result = true;
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		int userTurn = 0, systemTurn = 0, userRandomNum = 0, systemRandomNum = 0;
		
		boolean isGameDone = false;
		
		for(userTurn = 0; userTurn < 5; userTurn++){
		    if (userTurn == 0){
		        userRandomNum = rand.nextInt(blackJackCard.getCardTotal());
		        systemRandomNum = rand.nextInt(blackJackCard.getCardTotal());
		        
		        userPlayer.saveToCardArray(userTurn, blackJackCard.getCardNameStr(userRandomNum), blackJackCard.getCardNumberStr(userRandomNum));
		        systemPlayer.saveToCardArray(systemTurn, blackJackCard.getCardNameStr(systemRandomNum), blackJackCard.getCardNumberStr(systemRandomNum));
		    }
		    else{
		        while(true){
		            userRandomNum = rand.nextInt(blackJackCard.getCardTotal());
		            if(!isCardExist(userTurn, blackJackCard.getCardNumberStr(userRandomNum), userPlayer.getAllCardArray())){
		                break;
		            }
		        }
		        userPlayer.saveToCardArray(userTurn, blackJackCard.getCardNameStr(userRandomNum), blackJackCard.getCardNumberStr(userRandomNum));
		        
		        System.out.println("====================================== System ======================================");
		        systemPlayer.displayCardArray(systemTurn);
		        
		        System.out.println("======================================  User ======================================");
		        userPlayer.displayCardArray(userTurn);
		        
		        System.out.printf("User: %d \nSystem: %d\n", 
        		    userPlayer.getTotalCardCalculation(),
        		    systemPlayer.getTotalCardCalculation()
        		);
		        
		        isGameDone = isUserGameDone();
		        
		        if (isGameDone){
		            break;
		        }
		        
		        if (isLastTurn(userTurn)){
		            break;
		        }
		        
		        if (isWantToStop()){
		            break;
		        }
		    }
		}
		
		if (!isGameDone){
		    
    		for(systemTurn = 1; systemTurn < 5; systemTurn++){
    		    while(true){
        		    systemRandomNum = rand.nextInt(blackJackCard.getCardTotal());
		            if(!isCardExist(systemTurn, blackJackCard.getCardNumberStr(systemRandomNum), systemPlayer.getAllCardArray())){
		                break;
		            }
		        }
    		    systemPlayer.saveToCardArray(systemTurn, blackJackCard.getCardNameStr(systemRandomNum), blackJackCard.getCardNumberStr(systemRandomNum));
    		    
    		    System.out.println("====================================== System ======================================");
		        systemPlayer.displayCardArray(systemTurn);
		        System.out.println("======================================  User ======================================");
		        userPlayer.displayCardArray(userTurn);
		        
		        System.out.printf("User: %d \nSystem: %d\n", 
        		    userPlayer.getTotalCardCalculation(),
        		    systemPlayer.getTotalCardCalculation()
        		);
		        
		        if (isLastTurn(systemTurn)){
		            break;
		        }
		        
		        isGameDone = isSystemGameDone();
		        
		        if (isGameDone){
		            break;
		        }
		        
		        systemRandomNum = rand.nextInt(2);
		        
		        if (systemRandomNum == 0) {
		            break;
		        }
		        
    		}
		}
		
		System.out.printf("User result is %s\n", checkResult());
	}
}

class Card {
    private final String[][] cardList = {
//      Card Name       Card Number Card Name       Card Number Card Name       Card Number Card Name       Card Number
        {"Diamond Ace",     "1"},   {"Clubs Ace",     "1"},     {"Spades Ace",    "1"},     {"Heart Ace",     "1"},
        {"Diamond Two",     "2"},   {"Clubs Two",     "2"},     {"Spades Two",    "2"},     {"Heart Two",     "2"},
        {"Diamond Three",   "3"},   {"Clubs Three",   "3"},     {"Spades Three",  "3"},     {"Heart Three",   "3"},
        {"Diamond Four",    "4"},   {"Clubs Four",    "4"},     {"Spades Four",   "4"},     {"Heart Four",    "4"},
        {"Diamond Five",    "5"},   {"Clubs Five",    "5"},     {"Spades Five",   "5"},     {"Heart Five",    "5"},
        {"Diamond Six",     "6"},   {"Clubs Six",     "6"},     {"Spades Six",    "6"},     {"Heart Six",     "6"},
        {"Diamond Seven",   "7"},   {"Clubs Seven",   "7"},     {"Spades Seven",  "7"},     {"Heart Seven",   "7"},
        {"Diamond Eight",   "8"},   {"Clubs Eight",   "8"},     {"Spades Eight",  "8"},     {"Heart Eight",   "8"},
        {"Diamond Nine",    "9"},   {"Clubs Nine",    "9"},     {"Spades Nine",   "9"},     {"Heart Nine",    "9"},
        {"Diamond Ten",     "10"},  {"Clubs Ten",     "10"},    {"Spades Ten",     "10"},   {"Heart Ten",     "10"},
        {"Diamond Jack",    "10"},  {"Clubs Jack",    "10"},    {"Spades Jack",    "10"},   {"Heart Jack",    "10"},
        {"Diamond Queen",   "10"},  {"Clubs Queen",   "10"},    {"Spades Queen",   "10"},   {"Heart Queen",   "10"},
        {"Diamond King",    "10"},  {"Clubs King",    "10"},    {"Spades King",    "10"},   {"Heart King",    "10"}
    };
    
    public String getCardNameStr(int cardIndex){
        return cardList[cardIndex][0];
    }
    
    public String getCardNumberStr(int cardIndex){
        return cardList[cardIndex][1];
    }
    
    public int getCardNumberInt(int cardIndex){
        return Integer.valueOf(cardList[cardIndex][1]);
    }
    
    public int getCardTotal(){
        return cardList.length;
    }
}

class Player {
    private String[][] cardArray = new String[5][2];
    
    private int getNumberOfHoldingCard(){
        int row;
        
        for(row = 0; row < 5; row++){
            if (cardArray[row][0] == null){
                break;
            }
        }
        
        return row;
    }
    
    public void saveToCardArray(int row, String cardName, String cardNumber){
        cardArray[row][0] = cardName;
        cardArray[row][1] = cardNumber;
    }
    
    public void displayCardArray(int turn){
        for (int row = 0; row <= turn; row++){
            if (cardArray[row][0].equals(null)) {
                break;
            }
            System.out.printf("%20s", cardArray[row][0]);
        }
        
        System.out.println();
    }
    
    public String[][] getAllCardArray(){
        return cardArray;
    }
    
    public int getTotalCardCalculation(){
        int totalCalculation = 0;
        
        for(int row = 0; row < getNumberOfHoldingCard(); row++){
            totalCalculation += Integer.valueOf(cardArray[row][1]);
        }
        
        return totalCalculation;
    }
    
    public boolean isBust(){
        boolean ret = false;
        
        if(getTotalCardCalculation() > 21){
            ret = true;
        }
        
        return ret;
    }
    
    public boolean isBlackJack(){
        boolean ret = false;
        
        if(getTotalCardCalculation() == 21){
            ret = true;
        }
        
        return ret;
    }
}
