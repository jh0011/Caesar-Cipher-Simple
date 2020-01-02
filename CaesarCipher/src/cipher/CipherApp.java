package cipher;

import java.util.Scanner;

public class CipherApp {
	
	public static void main(String[] args){
		boolean isAuto = true; 
		
		if (isAuto){ //no manual input needed
			for (int i=0; i<26; i++){
				int key = i;
				String cipherText = "htatri iwt utaxct";
				Cipher myCipher = new Cipher();
				String plainText = myCipher.decrypt(cipherText, key);
				System.out.println("Key is: " + key + "========================");
				System.out.println("The ciphertext is: " + cipherText);
				System.out.println("The plaintext is: " + plainText);
				System.out.println();
			}
		}
		
		else{ //manual input needed
			boolean loopBreaker = false;
			while (loopBreaker == false){
				int key;
				String cipherText;
				String plainText;
				
				Cipher myCipher = new Cipher();
				
				System.out.println("===========MENU==============");
				System.out.println("1. Encrypt the plaintext");
				System.out.println("2. Decrypt the ciphertext");
				System.out.println("=============================");
				System.out.println();
				
				System.out.println("Choose the option.");
				Scanner sc1 = new Scanner(System.in);
				int option = sc1.nextInt();
				switch(option){
				case 1:
					System.out.println("Enter the plaintext: ");
					Scanner sc2 = new Scanner(System.in);
					plainText = sc2.nextLine();
					System.out.println("Enter the integer key: ");
					key = sc2.nextInt();
					if (isKey(key)){
						cipherText = myCipher.encrypt(plainText, key);
						System.out.println("Key is: " + key + "========================");
						System.out.println("The cipher text is: " + cipherText.toUpperCase());
						System.out.println("The plain text is: " + plainText.toUpperCase());
						System.out.println();
					}
					else{
						System.out.println("Invalid key! Please try again.");
						System.out.println();
					}
					break;
					
				case 2:
					System.out.println("Enter the ciphertext: ");
					Scanner sc3 = new Scanner(System.in);
					cipherText = sc3.nextLine();
					System.out.println("Enter the integer key: ");
					key = sc3.nextInt();
					if (isKey(key)){
						plainText = myCipher.decrypt(cipherText, key);
						System.out.println("Key is: " + key + "========================");
						System.out.println("The cipher text is: " + cipherText.toUpperCase());
						System.out.println("The plain text is: " + plainText.toUpperCase());
						System.out.println();
					}
					else{
						System.out.println("Invalid key! Please try again.");
						System.out.println();
					}
					break;
					
				default:
					loopBreaker = true;
					break;
					
				}
			}
			
			System.out.println("Program terminated successfully.");
		}
		
		
		
	}
	
	public static boolean isKey(int key){
		if (key >= 0 && key < 26){
			return true;
		}
		else{
			return false;
		}
	}

}
