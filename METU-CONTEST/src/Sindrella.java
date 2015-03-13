import java.util.Scanner;

public class Sindrella {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		String numberStr = scan.next();
		//Key must be start with first char
		int sumOfDigits = numberStr.charAt(0) - '0';
		String key = "" + numberStr.charAt(0);
		
		int [] sevenRule = {3,2,-1,-3,-2,1};
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
				c = key.charAt(key.length()-1) - '0';
				if(c % 2 == 0){
					key += '0';
				}
				else{
					key += '2';
					sumOfDigits += 2;
				}
				break;
			case 7:
				int sum = 0;
				int kl = key.length();
				for(int j = kl-1; j >= 0;j--){
					sum += (key.charAt(j) - '0') * sevenRule[(kl-j-1)%6];
				}
				c = 0;
				while((sum + c) % 7 != 0){
					c++;
				}
				key += (char)(c + '0');
				sumOfDigits += c;
				break;
			case 8:
				if(numberStr.length() < 3){
					key += '6';
					sumOfDigits+= 6;
				}
				else{
					c = Integer.parseInt(key.substring(key.length()-2));
					c*= 10;
					while(c % 8 != 0){	
						c+=2;
					}
					int k = c %10;
					sumOfDigits += k;
					key += (char)(k + '0');
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
