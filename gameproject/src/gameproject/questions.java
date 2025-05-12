package gameproject;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;  
public class questions {
	public static String line = "";  
	public static String splitBy = ",";
	public static String questionNo = null;
	public static String questionCategory =null;
	public static String questiontext=null;
	public static String optiona=null;
	public static String optionb=null;
	public static String optionc=null;
	public static String optiond=null;
	public static String optionCorrect=null;	
	public static int points;
	


public static void questiongetter(int a){
{  
try   
{  
BufferedReader br = new BufferedReader(new FileReader("/Users/aslan/Desktop/tableConvert.csv")); 
List<String> lines = new ArrayList<>();
String line1 = null;
while ((line1 = br.readLine()) != null) {
    lines.add(line1);
}

String[] question = lines.get(a).split(splitBy);

questionNo=question[0];
questionCategory=question[1];
questiontext=question[2];
optiona=question[3];
optionb=question[4];
optionc=question[5];
optiond=question[6];
optionCorrect=question[7];


switch(optionCorrect.replaceAll("[^\\p{Print}]", "")){
case"a":
	optionCorrect=optiona;
	break;
case"b":
    optionCorrect=optionb;
    break;
case"c":
	optionCorrect=optionc;
	break;
case"d":
	optionCorrect=optiond;
	break;
}
System.out.println(optionCorrect);



}    
catch (IOException e)   
{  
e.printStackTrace();  
}  
}
}



public static Object getQuestionCategory() {
	
	return questionCategory ;
}
public static void getRandomQuestions(List<Integer> intList) {
	Random rndm = new Random();
    
    int rndmIndx = rndm.nextInt(intList.size());
    Integer randomint = intList.get(rndmIndx);
    questions.questiongetter(randomint-1);
    intList.remove(rndmIndx);
	
	
}
}
  