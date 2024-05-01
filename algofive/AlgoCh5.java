package algofive;
import java.util.ArrayList;
import java.util.Scanner;

public class AlgoCh5
{
	@SuppressWarnings({ "resource", "static-access" })
    public static void main(String[] args) {
	    QnAManage qnaManagement = new QnAManage();
	    QnADisplay qnaDisplay = new QnADisplay();
	    Scanner userAnswer = new Scanner(System.in);
	    Scanner userAnswerConfirm = new Scanner(System.in);
	    
	    ArrayList<String> userAnswerList = new ArrayList<>();
	    
	    int totalCorrectAnswer = 0;
	    
	    while(true){
	        for(int i = 0; i < 5; i++){
    	        System.out.println(qnaDisplay.getQuestion(i));
    	        String userAnswerGet = userAnswer.nextLine();
    	        
    	        qnaManagement.saveUserAnswer(userAnswerList, userAnswerGet);
	        }
	    
    	    System.out.println("Ketik \"Submit\" " +
    	    "jika sudah yakin, atau ketik \"Edit\" jika mau mengubah jawaban: ");
    	    String userConfirm = userAnswerConfirm.nextLine();
    	    
    	    if (userConfirm.equalsIgnoreCase("submit")){
    	        totalCorrectAnswer = qnaDisplay.getCorrectAnswer(userAnswerList);
    	        break;
    	    }
    	    else if (userConfirm.equalsIgnoreCase("edit"))
    	        qnaManagement.deleteAnswer(userAnswerList);
    	    else {
    	        System.out.println("Konfirmasi gagal, mengulang pertanyaan");
    	        qnaManagement.deleteAnswer(userAnswerList);
    	    }
	    }
	    
		System.out.printf("Total jawaban benar: %d \nNilai: %.0f", 
		    totalCorrectAnswer, 
		    (((float) totalCorrectAnswer) / 5) * 100);
	}
}

class QnADisplay {
    public static String getQuestion(int questionId){
        /**
        * Array of question list
        */
        ArrayList<String> questionList = new ArrayList<>();
        questionList.add("1. Arti kata \"cat\" dalam Bahasa Indonesia? ");
        questionList.add("2. Arti kata \"bird\" dalam Bahasa Indonesia? ");
        questionList.add("3. Arti kata \"rabbit\" dalam Bahasa Indonesia? ");
        questionList.add("4. Arti kata \"sheep\" dalam Bahasa Indonesia? ");
        questionList.add("5. Arti kata \"cow\" dalam Bahasa Indonesia? ");
        
        return questionList.get(questionId);
    }
    
    public static int getCorrectAnswer(ArrayList<String> userAnswer){
        int totalCorrectAnswer = 0;
        
        /**
        * Array of answer list
        */
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add("Kucing");
        answerList.add("Burung");
        answerList.add("Kelinci");
        answerList.add("Domba");
        answerList.add("Sapi");
        
        for (int i = 0; i < 5; i++){
            if (userAnswer.get(i).equalsIgnoreCase(answerList.get(i))) 
                totalCorrectAnswer += 1;
        }
        
        return totalCorrectAnswer;
    }
}

class QnAManage{
    public static void saveUserAnswer(ArrayList<String> answerList, String userAnswerStr){
        answerList.add(userAnswerStr);
    }
    
    public static void deleteAnswer(ArrayList<String> answerList){
        answerList.clear();
    }
}