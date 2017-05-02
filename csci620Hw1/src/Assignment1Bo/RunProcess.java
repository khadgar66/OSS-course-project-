package Assignment1Bo;

import java.util.Scanner;

public class RunProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Please choose encrypt or decrypt, type 1 for encrypt and 2 for decrypt: ");
		Scanner eorDcrypt = new Scanner(System.in);
		String userDecide = eorDcrypt.nextLine();
		
		//for encrypt function
		if(userDecide.equals("1")){

			System.out.println("Please type text need to encrypt: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String value = sc.nextLine();
			System.out.println("Choose the method to encrypt text: type 1 for vingenere, 2 for affine");
			Scanner choose = new Scanner(System.in);
			String userChoose = choose.nextLine();
			
			EncryptFunction ef = new EncryptFunction();
			if(userChoose.equals("1")){//vigenere encrypt
				
				System.out.println("Please type key encrypt: ");
				@SuppressWarnings("resource")
				Scanner keyy = new Scanner(System.in);
				String key = keyy.nextLine();
				String cipher1 = ef.vigenereEncrypt(value, key);
				System.out.println("The result is: " + cipher1);
			}
			else if(userChoose.equals("2")){//affine encrypt
				String cipher2 = ef.affineEncrypt(value);
				System.out.println("The result is: " + cipher2);
			}
			else
				System.out.println("Type only 1 or 2 to choose algorithm");
		}
		//for decrypt function
		else if(userDecide.equals("2")){
			
			System.out.println("Please type text to decrypt: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String value = sc.nextLine();		
			DecryptFunction df = new DecryptFunction();
			
			System.out.println("Choose the method to Decrypt text: type 1 for vingenere, 2 for affine");
			Scanner choose = new Scanner(System.in);
			String userChoose = choose.nextLine();
			
			if(userChoose.equals("1")){
				System.out.println("Please type key to decrypt: ");
				@SuppressWarnings("resource")
				Scanner keyy = new Scanner(System.in);
				String key = keyy.nextLine();
				
				String document1 = df.vigenereDecrypt(value, key);
				System.out.println("The result is: " + document1);
				
			}
			else if(userChoose.equals("2")){
				System.out.println("Please type keyA and keyB to decrypt: ");
				Scanner fKey = new Scanner(System.in);
				int firstkey = fKey.nextInt();
				Scanner sKey = new Scanner(System.in);
				int secondkey = sKey.nextInt();
				
				String document2 = df.affineDecrypt(value, firstkey, secondkey);
				System.out.println("The result is: " + document2);
			}
			else
				System.out.println("Type only 1 or 2 to choose algorithm");
		}
		
	}
}