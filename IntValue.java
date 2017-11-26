import javax.swing.JOptionPane;


public class IntValue {

	    private int[] digit;
	    private char[] charArray;
	    private String str;
		private boolean isPositive = true;
		private int[] sumArray;
		private StringBuilder sum;
		
		
		
		
	    public IntValue(String str) { //constructor
	        this.str = str;
	        
	       
	        
	        if (str.charAt(0) == '-') //if the first character in the string is "-", then the string will be considered negative.
	        { 
	        	this.isPositive = false;
	        	this.charArray = str.toCharArray(); //copies the string over to a character array
	          	int n=charArray.length-1;
	        	char [] newArray= new char[n];
	        	System.arraycopy(charArray,1,newArray,0,n); //copies the character array over without the first index("-")
	        	this.str = new String(newArray);
	        
	        	System.out.println(this.str);
	        	
	        }
	        
	        
	        
	    }  	    
	       
	        	    
	    
	    public int[] toIntArray(String s){
	    	int[] converted = new int[s.length()];
	    	
	    	for (int i = 0; i < s.length(); ++i) 
	        {
	            converted[i] = s.charAt(i) - '0';
	        }
	    	return converted;
	    }
	    
	    public static String padStringWithZeros(String s, int length){
	    	while (length > s.length()){
	    		s = "0" + s;
	    	}
			return s;
	    }
	    
	    //DONE DONT TOUCH
	    public StringBuilder toSB(int[] arr){  //converts array of ints into a StringBuilder
	    	int dig = 0;
	    	StringBuilder sb = new StringBuilder();
	    	for(int i = 0; i < arr.length; i++){
	    		dig = arr[i];
	    		sb.append(dig);
	    	}
	    	this.sum = sb;
	    	
			return sum;
	    }

	    //DONE DONT TOUCH
	    public String toString(StringBuilder sb) { //converts a Stringbuilder into a string
	        
	        this.str = sb.toString();
	        
	        return str;
	    }
	    
	    //DONE DONT TOUCH
	    public String removeLeadingZeros(String s){ //removes the leading zeros at the front of a given string (?!$) = negative lookahead
	    	String t = "";
	    	t = s.replaceFirst("^0+(?!$)", "");
	    	this.str = t;
	    	return t;
	    }   
	    
	    
	    public static int compareTo(int[] num1, int[] num2){ //DONE
	    	  	int compared = 0;
	    	
	    	
	    	
	    	
	    		for(int i = 0; i < num1.length; i++){
	    			if(num1[i] == num2[i]){
    					continue;
    				}
    				
    				else if(num1[i] > num2[i]){
    					return compared = 1;
    				}
    				
    				else if(num1[i] < num2[i]){
    					return compared = -1;
    				}
    			}
    			return compared;
	    		}
	    	
	    	
	    	
	    
            
	    public IntValue plus(IntValue other) {
	    	
	    	int signum; // value of 1 if num1> num2, 0 if num1 = num2, 1 if num1 < num2
	    	String sumString = "";
	    	StringBuilder sb = new StringBuilder();
	    	
	    	if (this.str.length() > other.str.length()){
	    		other.str = padStringWithZeros(other.str, str.length()); //pads the smaller string with zeros to make the same size
	    	}
	    	
	    	else if (this.str.length() < other.str.length()){
	    		this.str = padStringWithZeros(str, other.str.length());
	    	}
	    	
	    	this.digit = toIntArray(str);
	    	other.digit = toIntArray(other.str);
	    	
	    	
	    	
	    	//if they are both positive, just apply the regular addition to both
	    	if(this.isPositive == true && other.isPositive == true)
	    	{	    		
	    		signum = compareTo(this.digit,other.digit);
		    	
		    	
		    //apply addition
	    		if (signum == 1){
	    			    		
		    		this.sumArray = sum(this.digit,other.digit);
		    		
		    		}
		    	
		    	else if (signum == 0){
		    		this.sumArray = sum(this.digit,other.digit);
		    		
		    		}
		    	
		    	else if (signum == -1){
//		    		
		    		this.sumArray = sum(other.digit,this.digit);
		    		
		    		}
		    	
		    	toSB(this.sumArray);
	    		toString(sum);
	    		removeLeadingZeros(this.str);
	    	}
	    	
	    	else if (this.isPositive == false && other.isPositive == false) //if both are negative
	    	{
	    		signum = compareTo(this.digit,other.digit);	    
	    		
		    	//apply addition
			    if (signum == 1){
		    			    		
			    		this.sumArray = sum(this.digit,other.digit);
			    		
			    		}
			    	
			    	else if (signum == 0){
			    		this.sumArray = sum(this.digit,other.digit);
			    		
			    		}
			    	
			    	else if (signum == -1){
//			    		
			    		this.sumArray = sum(other.digit,this.digit);
			    		
			    		}
			    	
			    	this.sum = toSB(this.sumArray);
		    		sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str = "-" + sumString;
		    	}
	    	
	    	else if( (isPositive == true && other.isPositive == false)) //if num1 is positive and num2 is negative
	    	{
	    		signum = compareTo(digit,other.digit);
	    		if (signum == 1){
		    		
	    			this.sumArray = minus(this.digit,other.digit);
	    			this.sum = toSB(this.sumArray);
	    			sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str =sumString;
		    		
		    		}
		    	
		    	else if (signum == 0){
		    		
		    		sb.append(0);
		    		this.sum = sb;
		    		sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str = sumString;
		    		
		    		}
		    	
		    	else if (signum == -1){
//		    		
		    		this.sumArray = minus(other.digit,digit);
		    		this.sum = toSB(sumArray);
		    		sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str =  "-" + sumString;
		    		} 		 		    	
	    		}
	    	
	    	
	    	else if (isPositive == false && other.isPositive == true){ //if num1 is negative and num2 is positive
	    		signum = compareTo(digit,other.digit);
	    		
	    		if (signum == 1){
		    		
	    			this.sumArray = minus(this.digit,other.digit); //subtracts the 2 numbers, bigger-smaller
	    			this.sum = toSB(this.sumArray); //converts the int array to a StringBuilder
	    			sumString = toString(sum); //converts the SB to a string
		    		sumString = removeLeadingZeros(sumString); //removes leading zeros
		    		this.str = "-" + sumString; //adds a negative number to the beginning of the answer.
		    		
		    		}
		    	
		    	else if (signum == 0){
		    		this.sumArray = minus(digit,other.digit);
		    		this.sum = toSB(this.sumArray);
		    		sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str = sumString;
		    		
		    		}
		    	
		    	else if (signum == -1){
//		    		
		    		this.sumArray = minus(other.digit,digit);
		    		this.sum = toSB(this.sumArray);
		    		sumString = toString(sum);
		    		sumString = removeLeadingZeros(sumString);
		    		this.str = sumString;
		    		} 		 	
	    		    		
	    		
	    		
	    		
	    		
	    	}
	    		   	   
	    	return this; 
	        
	    	}
	    
	    public IntValue times(IntValue other){
	    	int signum;
	    	String sumString = "";
	    	StringBuilder sb = new StringBuilder();
	    	
	    	if (this.str.length() > other.str.length()){
	    		other.str = padStringWithZeros(other.str, this.str.length());
	    	}
	    	
	    	else if (this.str.length() < other.str.length()){
	    		this.str = padStringWithZeros(this.str, other.str.length());
	    	}
	    	
	    	this.digit = toIntArray(this.str);
	    	other.digit = toIntArray(other.str);
	    	
	    	//CONDITION: MULTIPLICATION OF MIXED SIGN-INTEGERS
	    	if ((isPositive == false && other.isPositive == true) || (isPositive == true && other.isPositive == false))
	    	{
	    		this.sumArray = product(digit, other.digit);
	    		
	    		this.sum = toSB(this.sumArray);
	    		sumString = toString(sum);
	    		sumString = removeLeadingZeros(sumString);
	    		this.str = "-" + sumString;
	    	}
	    	
	    	else
	    	{
	    		this.sumArray = product(digit, other.digit);
	    		
	    		this.sum = toSB(this.sumArray);
	    		sumString = toString(sum);
	    		sumString = removeLeadingZeros(sumString);
	    		this.str = sumString;
	    	}
	    	
	    	
	    	
			return this;
	    }
	    
	    
	    //HAVENT GOTTEN TO WORK YET
//	   public IntValue exponentiate(IntValue exponent){  
//		   str = removeLeadingZeros(str);
//		   exponent.str = removeLeadingZeros(exponent.str);
//		   this.digit = toIntArray(this.str);
//	       exponent.digit = toIntArray(exponent.str);
//		   if(exponent.isPositive == false){ //if the exponent is negative, all powers will be flipped
//			   if (digit.length == 1 && digit[0] == 0 ){
//				   this.str = "1";
//				   return this;
//			   }
//			   else if (digit.length == 1 && digit[0] == 0 ){
//				   return this;
//			   }
//			   
//			   else{
//				   System.out.println("The answer to this will be less than 1 and not an integer.");				   
//			   }
//			   
//			   
//		   }
//		   
//		   else{
//			   this.sumArray = pow(digit, exponent.digit);
//		   }
//		return exponent;
//		   
//	   }
	    
	    
	    
	    public static int[] sum(int[] bigger, int[] smaller) {
	    	int carry=0;
	        int sumArray[] = new int[bigger.length + 1];
	       
	        
	        //sumArray arrays
	        for (int i = bigger.length - 1 ; i >= 0; --i) 
	        {
	            sumArray[i + 1] = (bigger[i] + smaller[i] + carry) % 10 ; //sumArray digits + carry; then extract last digit
	            carry = (bigger[i] + smaller[i] + carry) / 10; //Compute carry
	        }
	        
	        sumArray[0] = carry;
	        
	        
	        return sumArray;
	    }
	    
	    public static int[] minus(int[] bigger, int[] smaller){ //WORKS BUT RETOOL 
	    	// Allocate enough space to store the solution.
	    	int borrow = 0;
	    	int[] result = new int[bigger.length];
	    	for (int i = bigger.length - 1 ; i >= 0; i--) 
	    	{
	            result[i] = bigger[i] - smaller[i] - borrow;
	            
	            if (result[i] >= 0)
	            {
	                borrow = 0;
	            }
	            else {
	                result[i] += 10;
	                borrow = 1;
	            }
	            
	    	}
	    	return result;     
	    }
	    
	    
	    	
	    public static int[] product(int[] num1, int[] num2){
	        	int[] top, bot;	// top and bottom operands in long multiplication
	        	if (num1.length >= num2.length){
	        		top = num1;
	        		bot = num2;
	        	}
	        	else{
	        		top = num2;
	        		bot = num1;
	        	}
	        	int[] ans = new int[num1.length + num2.length]; //has to be at least as big as both put together.
	    		int offset = 0;								// right offset when adding the rows
	    		
	        	// for each digit in bot string from right to left
	        	for (int i=bot.length-1; i>=0; i--){
	            	int prodCarry = 0;				// carryover due to multiplication
	            	int addCarry = 0;					// carryover due to addition 
	            	
	            	// for each digit in top string from right to left
	            	for (int j=top.length-1; j>=0; j--){
	            		
	        			//product of 2 digits 
	            		int product = bot[i] * top[j] + prodCarry;	// multiply top digit with bottom digit and add with carryover
        		        prodCarry = product/ 10;					// carry over from product, int automatically rounds down
	        			product %= 10;								// product after forwarding carryover
	        			
	        			// add product to ans[] 
	        			int index = ans.length - (top.length - j) - offset;	// corresponding index in ans[]
	        			ans[index] += product + addCarry;
	        			addCarry = ans[index]/10;
	        			ans[index] = ans[index]%10;
	        		}
	            	
	            	// handle final carryovers
	        		if (prodCarry != 0 || addCarry != 0){
	        			
	        			int index = ans.length - (top.length + 1) - offset;
	        			ans[index] += prodCarry + addCarry;
	        		}
	        		offset++;	// pad one more '0' to the right of next row
	        	}
	        	return ans;
	        }
	                                        
//	    public static int[] pow(int[] base, int[] exponent){
//	    	int n = exponent.length;
//	    	int[] prodResult = new int[base.length + base.length];
//	    	int offset = 0;
//	    	int smallerPart;
//	    	ArrayList<int[]> holder = new ArrayList<int[]>();
//	    	for (int i = n - 1; i >= 0; i--){
//	    	smallerPart	= (int) (exponent[i] * Math.pow(10, offset));
//	    		prodResult = base;
//	    		for(int j = 0; i < smallerPart - 1; i++){
//	    			prodResult = product(prodResult,base);
//	    		}
//	    		holder.add(prodResult);
//	    	}
//	    	
//	    	for( int k = 1; k < holder.size(); k++){
//	    		prodResult = product(holder.get(k-1), holder.get(k));
//	    	}
//	    	
//	    	return prodResult;
//	    }
	    
	    
	    

	    	
	    
	    
	    

	    public static void main(String[] args){
	    	 IntValue a = new IntValue("-2");
	         IntValue b = new IntValue("4");
	         
	         
	         a.minus(a, b);
	         //even to subtract is a.plus(b);
	         //the addition, multiplication, and subtraction all output to a.str;
	         
	         System.out.println(a.str);
	         
	        
	         
	         
	         
	         
	    }
}
	    
	         
	         
	         
             
	        
	         
            
            
           
//             
//             
//             
//             
            
             

             
//             System.out.println("\n" + compareTo(a.digit,b.digit));
//              
//	         
             