import java.util.Scanner;

public class Sindrella {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String numberStr = scan.next();
		int sumOfDigits = numberStr.charAt(0) - '0';
		String key = "" + numberStr.charAt(0);
		
		
		for(int i = 1; i < n;i++){
			
			int divisor = numberStr.charAt(i) - '0';
			int c;
			switch(divisor){
				
			case 6:
			case 3:
				c = (3 - (sumOfDigits % 3)) % 3;
				if(divisor == 6 && c % 2 != 0){
					c+= 3;
				}
				key += (char)(c + '0');
				sumOfDigits+= c;
				break;
			case 4:
				if(numberStr.length() < 2){
					key += '4';
					sumOfDigits+= 4;
				}
				else{
					int number = key.charAt(key.length()-1) - '0';
					if(number % 2 == 0){
						key += '0';
					}
					else{
						key += '2';
						sumOfDigits += 2;
					}
				}
				break;
			case 7:
				key += '5';
				sumOfDigits += 5;
				break;
			case 8:
				if(numberStr.length() < 2){
					key += '8';
					sumOfDigits+= 8;
				}
				else{
					int number = Integer.parseInt(key.substring(key.length()-2));
					if(number % 2 == 0){
						key += '0';
					}
					else{
						key += '2';
						sumOfDigits += 2;
					}
				}
				break;
			case 9:
				c = 9 - (sumOfDigits % 9);
				key += (char)(c + '0');
				sumOfDigits+= c;
				break;
			case 1:
			case 2:
			case 5:
				key += '0';
				break;
			}
		}
		System.out.println(key);

	}

}
