import java.util.ArrayList;
import java.util.Scanner;

public class main {

	private static String message1 = "Input the first value:";
	private static String message2 = "Input the second value:";
	private static String math1 = "Input one of the following:"
			+ "\n1) add"
			+ "\n2) multiply"
			+ "\n3) raise";
	private static String command;
	private static String value1;
	private static String value2;
	private static String temp;
	
	
	public static String getTemp() {
		return temp;
	}


	public static void setTemp(String temp) {
		main.temp = temp;
	}


	public static String getCommand() {
		return command;
	}


	public static void setCommand(String command) {
		main.command = command;
	}


	public static String getValue1() {
		return value1;
	}


	public static void setValue1(String value1) {
		main.value1 = value1;
	}


	public static String getValue2() {
		return value2;
	}


	public static void setValue2(String value2) {
		main.value2 = value2;
	}


	
	
	
	public static void Input(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(message1);
		setValue2(scanner.nextLine());
		System.out.println(message2);
		setValue2(scanner.nextLine());
		System.out.println(math1);
		setCommand(scanner.nextLine());
		
	}
	
	
	
	
	
	public static String add(String value1, String value2){
		int carry =0;
		int length1 = value1.length();
		int length2 = value2.length();
		int max ;
		if (length1> length2){
			max = length1;
		}else{
			max= length2;
		}
		
		
		
		
		
		int sum;
		String StringR = "";
		int num1;
		int num2;
		
		for (int i=0; i<max; i++){
			try{
				num1 = new Integer (value1.charAt(length1-i-1)-48);
			}catch(StringIndexOutOfBoundsException ex){
				num1=0;
			}
			
			try{
			num2 =  new Integer (value2.charAt(length2-i-1)-48);
			}catch(StringIndexOutOfBoundsException ex){
				num2 = 0;
			}
			
			if (num1 +num2 +carry >=10){
				sum = (num1+num2 +carry)-10;
				carry =1;
			}else{
				sum  =  num1 +num2 +carry;
				carry  = 0;
			}
			
			
			StringR = sum +StringR;
			
		}
		
		if (carry ==0){
			StringR = StringR;
		}else{
		StringR = carry +StringR;
		}
		
		return StringR;
		
		
	}
	
	
	
	
	
	public static String karatasuba (String value1, String value2){

		int length1 = value1.length();
		int length2 = value2.length();

		//If one value has more digits than the other, add zeroes to the front...

		

		int temp1;
		int temp2;
		int multiply;
		
		if (Integer.parseInt(value1)<10|| Integer.parseInt(value2)<10 ){
			temp1 = Integer.parseInt(value1);
			temp2 = Integer.parseInt(value2);
			multiply = temp1*temp2;
			return multiply +"" ;
		}else if (length1 ==0 || length2 ==0){
			return "0";
		}



			int firstHalf = length1/2;
			int secondHalf = length1 - firstHalf;

			String value1First = value1.substring(0, firstHalf);
			String value1Second = value1.substring(firstHalf, secondHalf);


			String value2First = value2.substring(0, firstHalf);
			String value2Second = value2.substring(firstHalf, secondHalf);

			String ac = karatasuba (value1First, value2First);
			String ad = karatasuba (value1First, value2Second);
			String bc = karatasuba(value1Second, value2First);
			String bd = karatasuba(value1Second, value2Second);

			String zeroesToAdd= "";
			String zeroesToAdd2 = "";
			for (int i=0; i<length1; i++){
				zeroesToAdd = "0"+ zeroesToAdd;
			}
			for (int i=0; i<length1/2; i++){
				zeroesToAdd2 = "0"+ zeroesToAdd2;
			}

			String firstPart = ac + zeroesToAdd;
			String secondPart = (add(ad,bc))+zeroesToAdd2;
			String thirdPart = bd;

			String add1 = add(firstPart, secondPart);
			System.out.println(firstPart);
			System.out.println(secondPart);
			System.out.println(thirdPart);
			
			
		



			return add(add1, thirdPart);
		}





	

	
	
	public static String multiply(String value1 , String value2){
	
		if (value2.length() > value1.length()){
			setTemp(value2);
			value2 = value1;
			value1 = getTemp();
		}
		 
		
		int length1  =  value1.length();
		int length2 = value2.length();
		int max;
		int min;
		String temp9;
		if (length1 >= length2){
			
			max = length1;
			min =length2;
		}else{
		
			max = length2;
			min = length1;
		}
		int num1;
		int num2;
		int multiply;
		int subtractor;
		int finalizer;
		int carry =0;
		int carry2 =0;
		ArrayList<String> table = new ArrayList<String>();
		ArrayList<String> table2 = new ArrayList<String>();
		String forTable="";
		String zeroes="";
		String toReturn ="";
		String toPut="";
		String temp;
		int temp1;
		int temp2;
		for (int i=0; i<min;i++){
			if (i>=1){
				zeroes += "0";
			}
			
			for (int j=0; j<max; j++){
				try{
					num1 = new Integer (value1.charAt(length1-j-1)-48);
				}catch(StringIndexOutOfBoundsException ex){
					num1=0;
				}

				try{
					num2 =  new Integer (value2.charAt(length2-i-1)-48);
				}catch(StringIndexOutOfBoundsException ex){
					num2 = 0;
				}	



				if ((num1*num2) + carry <10){
					multiply = num1*num2 +carry;
					toReturn =  (multiply)+ toReturn;
					carry=0;
					if(j==max-1){
						if (carry != 0){
							toReturn = carry+""+toReturn;
							carry=0;
						}
						table.add(toReturn+zeroes);
						toReturn = "";
					}
				}else{
					multiply = (num1*num2) + carry;
					subtractor = multiply/10;
					subtractor = subtractor*10;
					finalizer = multiply - subtractor; 
					toReturn =  finalizer+ toReturn; 
					carry = subtractor/10;
					if(j==max-1){
						if (carry != 0){
							toReturn = carry+""+toReturn;
							carry=0;
						}  
						table.add(toReturn+zeroes);
						toReturn = "";
					}





				}

			}
		}
		
		
		
		
		String addition = "";
		
		for (int i=0; i<table.size();i++){
			addition = add(addition, table.get(i));
		}
		return addition;
		
		
		
		
	}
			
		
	
	public static String power(String value1, String value2 ){
		
		long number = Long.parseLong(value2);
		String toHold ="1";
		
			for (long i=0; i<(number);i++){
			toHold = multiply(value1, toHold );
			}
			
	
			
			return toHold;
			
			
			
			
		}
		
		
	  
		 
		
		
	
	
	
	
	
	
	
	public static void main(String[] args){
		while (true){
		System.out.println("----------------------------");
		Scanner scanner = new Scanner(System.in);
		System.out.println(message1);
		
		
		setValue1(scanner.nextLine());
		System.out.println(message2);
		setValue2(scanner.nextLine());
		System.out.println(math1);
		setCommand(scanner.nextLine());
		
		if (getCommand().equals("add")||getCommand().equals("1")){
		System.out.println("                       ");
		System.out.println(getValue1()+ "  +  " +getValue2());
		System.out.println( add(getValue1(), getValue2()));
		}
		
		if (getCommand().equals("multiply")||getCommand().equals("2")){
			int length1 = getValue1().length();
			int length2 = getValue2().length(); 
			String value1;
			String value2;
			if (length2>length1){
				value1 = getValue2();
				value2 =getValue1();
			}else{
				value1 = getValue1();
				value2 = getValue2();
			}
			System.out.println("                       ");
			System.out.println(getValue1()+ "  *  " +getValue2());
			System.out.println("The Result is:   " + multiply(value1, value2));
			}
		if(getCommand().equals("power")||getCommand().equals("3")){
			System.out.println("                       ");
			System.out.println(getValue1()+ "  ^  " +getValue2());
			System.out.println("The Result is:   " +power(getValue1(), getValue2()));
		}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
