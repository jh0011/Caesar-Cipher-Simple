package cipher;

import java.util.ArrayList;

public class Cipher {
	
	private int key;
	private String plainText;
	private String cipherText;
	
	public void setKey(int key){
		this.key = key;
	}
	
	public void setPlain(String plain){
		plainText = plain;
	}
	
	public void setCipher(String cipher){
		cipherText = cipher;
	}
	
	public int getKey(){
		return key;
	}
	
	public String getPlain(){
		return plainText;
	}
	
	public String getCipher(){
		return cipherText;
	}
	
	
	public String decrypt(String cipherText, int key){
		String lowerCasePlain = cipherText.toUpperCase();
		char[] chars = lowerCasePlain.toCharArray();
		
		//convert to numbers
		//add the key
		//mod the numbers
		ArrayList<Integer> plainInt = new ArrayList<Integer>();
		for (int j=0; j<chars.length; j++){
			if (String.valueOf(chars[j]).equals(" ")){ //newPos of " " is -1
				plainInt.add(-1);
			}
			else{
				int pos = chars[j] - 'A' + 1;
				if (key >= pos){
					key = key - 26;
				}
				int newPos = (pos - key) % 26;
				plainInt.add(newPos); //newPos is between 0 to 25, inclusive
			}
			
		}
		
		
		//convert to String
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphaArray = alphabets.toCharArray(); 
		String plainArray = "";
		for (int k=0; k<plainInt.size(); k++){
			int posNum = plainInt.get(k);
			char alphabet;
			if (posNum > 0){
				alphabet = alphaArray[posNum - 1];
				String alphaString = String.valueOf(alphabet);
				plainArray = plainArray.concat(alphaString);
			}
			else if (posNum == 0){
				alphabet = 'Z';
				String alphaString = String.valueOf(alphabet);
				plainArray = plainArray.concat(alphaString);
			}
			else{
				plainArray = plainArray.concat(" ");
			}
			
		}
		
		return plainArray;
	}
	
	public String encrypt(String plainText, int key){
		String plainLower = plainText.toUpperCase();
		char[] plainCharArr = plainLower.toCharArray();
		
		ArrayList<Integer> cipherInt = new ArrayList<Integer>();
		for (int i=0; i<plainCharArr.length; i++){
			int pos;
			String charSpace = String.valueOf(plainCharArr[i]);
			if (charSpace.equals(" ")){
				pos = -1; //for a space char
			}
			else{
				pos = (plainCharArr[i] - 'A' + 1 + key) % 26; //minus wrt to the 'A' in the ASCII
				if (pos == 0){
					pos = 27; //for letter Z
				}
			}
			cipherInt.add(pos);
		}
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] alphaArray = alphabets.toCharArray(); 
		String cipherArray = "";
		for (int j=0; j<cipherInt.size(); j++){
			int posNum = cipherInt.get(j);
			if (posNum == -1){
				cipherArray = cipherArray.concat(" ");
			}
			else if (posNum == 27){
				cipherArray = cipherArray.concat("Z");
			}
			else{
				String alphabet = String.valueOf(alphaArray[posNum - 1]);
				cipherArray = cipherArray.concat(alphabet);
			}
		}
		return cipherArray;
	}

}
