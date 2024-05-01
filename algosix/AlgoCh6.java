package algosix;
import java.util.Scanner;

public class AlgoCh6
{
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Scanner userQtyInput = new Scanner(System.in);
		FoodList foodClass = new FoodList();
		DrinkList drinkClass = new DrinkList();
		CalculateOrder calculate = new CalculateOrder();
		
		boolean isItemNameFound = false, isItemQtyInvalid = false;
		String category, userConfirm, itemNameInput;
		int itemQtyInput, itemIdChoosed;
		
		/*
		 * Create an array that combine the food and drink list, so it will be a 8x3 array
		 */
		String[][] userItemOrderArray = new String[foodClass.foodArray.length + drinkClass.drinkArray.length][3];
		
		/*
		 * Copy each of array into user order array
		 */
		for (int i = 0; i < 4; i++){
                    System.arraycopy(foodClass.foodArray[i], 0, userItemOrderArray[i], 0, 3);
		}
		for (int i = 0; i < 4; i++){
                    System.arraycopy(drinkClass.drinkArray[i], 0, userItemOrderArray[i + 4], 0, 3);
		}
		
            /*
             * nullify the number of every items
             */
            for (String[] userItemOrderArray1 : userItemOrderArray) {
                userItemOrderArray1[1] = "0";
            }
		
		while (true){
    		while (true){
        		System.out.println("Masukkan jenis barang yang akan dibeli (makanan/minuman)");
        		category = userInput.nextLine();
        		
        		/*
        		 * print all the food or drink list based on category input
        		 */
        		if (category.equalsIgnoreCase("makanan")) foodClass.getFoodListAll();
        		else if (category.equalsIgnoreCase("minuman")) drinkClass.getDrinkListAll();
        		
        		/*
        		 * if category is unknown, ask again to user about the category
        		 */
        		else {
        		    System.out.println("Kategori tidak diketahui, silakan masukkan kembali");
        		    continue;
        		}
        		
        		break;
    		}
    		
    		while (true){
    		    System.out.println("Masukkan nama barang");
        		itemNameInput = userInput.nextLine();
        		
        		System.out.println("Masukkan jumlah barang");
        		itemQtyInput = userQtyInput.nextInt();
        		
        		/*
        		 * Make sure the item name and the quantity is valid
        		 * by checking those input with item of category that choosed before
        		 */
    		    for (itemIdChoosed = 0; itemIdChoosed < 4; itemIdChoosed++){
    		        if (category.equalsIgnoreCase("makanan")){
        		        if (itemNameInput.equalsIgnoreCase(foodClass.foodArray[itemIdChoosed][0])){
        		            isItemNameFound = true;
        		            
        		            if(Integer.parseInt(foodClass.foodArray[itemIdChoosed][1]) - itemQtyInput < 0)
        		                isItemQtyInvalid = true;
    		                
    		                break;  // to get the precise item id, we immediately get out from the loop if item name is found
        		        }
    		        }
    		        
    		        else{
    		            if (itemNameInput.equalsIgnoreCase(drinkClass.drinkArray[itemIdChoosed][0])){
        		            isItemNameFound = true;
        		            
        		            if(Integer.parseInt(drinkClass.drinkArray[itemIdChoosed][1]) - itemQtyInput < 0)
        		                isItemQtyInvalid = true;
    		                
    		                break;  // to get the precise item id, we immediately get out from the loop if item name is found
        		        }
    		        }
    		    }
        		
        		/*
        		 * repeat the item name and qty input if not valid
        		 */
        		if (isItemQtyInvalid || !isItemNameFound) {
        		    System.out.println("Nama barang tidak ditemukan atau jumlah tidak mencukupi, silakan input kembali");
        		    isItemNameFound = false;
        		    isItemQtyInvalid = false;
        		    continue;
        		}
        		
        		break;
    		}
    		
    		while (true){
    		    System.out.println("Ketik \"Tambah\" jika ingin menambah barang lain, ketik \"Selesai\" jika ingin menyelesaikan pembelian");
        		userConfirm = userInput.nextLine();
        		
        		/*
        		 * repeat asking the user about the confirmation if the input is not valid
        		 */
        		if(!userConfirm.equalsIgnoreCase("tambah") && !userConfirm.equalsIgnoreCase("selesai")){
        		    System.out.println("Jawaban tidak diketahui, silakan input kembali");
        		    continue;
        		}
        		
        		/*
        		 * Edit the remaining qty for the item choosed by substract the food or drink array with number of qty input
        		 * And add the qty in user item order array based on qty input
        		 * It means the qty of item choosed is moved from food/drink array to user item order array
        		 */
                if (category.equalsIgnoreCase("makanan")) {
                    userItemOrderArray[itemIdChoosed][1] = 
                        String.valueOf(Integer.parseInt(userItemOrderArray[itemIdChoosed][1]) + itemQtyInput);
                    foodClass.foodArray[itemIdChoosed][1] = 
                        String.valueOf(Integer.parseInt(foodClass.foodArray[itemIdChoosed][1]) - itemQtyInput);
                }
                else {
                    userItemOrderArray[itemIdChoosed + 4][1] = 
                        String.valueOf(Integer.parseInt(userItemOrderArray[itemIdChoosed + 4][1]) + itemQtyInput);
                    drinkClass.drinkArray[itemIdChoosed][1] = 
                        String.valueOf(Integer.parseInt(drinkClass.drinkArray[itemIdChoosed][1]) - itemQtyInput);
                }
        		break;
    		}
    		
    		/*
    		 * repeat to category input if user choosed "tambah"
    		 */
    		if (userConfirm.equalsIgnoreCase("tambah")) {
                    } else break;
		}

        /*
         * print out the invoice.
         * the item that will be appeared on invoice are only the choosed items
         */
		System.out.println("Rincian Pembelian");
		System.out.printf("%15s%15s%15s\n", "Nama", "Jumlah", "Harga");
            for (String[] userItemOrderArray1 : userItemOrderArray) {
                if (Integer.parseInt(userItemOrderArray1[1]) > 0) {
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%15s", userItemOrderArray1[j]);
                    }
                    System.out.println();
                }
            }
        
        /*
         * display the total purchase
         */
		System.out.printf("total pembelian: %d", calculate.getTotalPurchase(userItemOrderArray));
		
	}
}

class FoodList {
    public String[][] foodArray = {
        {"Kacang",      "10",   "10000"},
        {"Semprong",    "15",   "20000"},
        {"Permen",      "25",   "5000"},
        {"Biskuit",     "8",    "25000"}
    };
    
    public void getFoodListAll(){
        System.out.printf("%15s%15s%15s\n", "Nama", "Jumlah", "Harga");
        for (String[] foodArray1 : foodArray) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%15s", foodArray1[j]);
            }
            System.out.println();
        }
    }
}

class DrinkList {
    public String[][] drinkArray = {
        {"Sprite",  "20",   "12000"},
        {"Coke",    "22",   "12000"},
        {"Badak",   "10",   "15000"},
        {"Fanta",   "15",   "12000"}
    };
    
    public void getDrinkListAll(){
        System.out.printf("%15s%15s%15s\n", "Nama", "Jumlah", "Harga");
        for (String[] drinkArray1 : drinkArray) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%15s", drinkArray1[j]);
            }
            System.out.println();
        }
    }
}

class CalculateOrder {
    private int totalPurchase = 0;
    public int getTotalPurchase(String[][] orderArray){
        for (String[] orderArray1 : orderArray) {
            totalPurchase += (Integer.valueOf(orderArray1[1]) * Integer.valueOf(orderArray1[2]));
        }
        return totalPurchase;
    }
}