package Assignment1Bo;

import java.util.Scanner;

import Assignment1Bo.DecryptFunction;
import Assignment1Bo.EncryptFunction;

import java.io.*;

public class RunProcess {

	private static Scanner eorDcrypt;

	public static void main(String[] args)throws IOException {
		
		//FileReader in = null;
	    FileWriter out = null;
	    
		System.out.println("Please choose encrypt or decrypt, type 1 for encrypt and 2 for decrypt: ");
		eorDcrypt = new Scanner(System.in);
		String userDecide = eorDcrypt.nextLine();
		
		//for encrypt function
		if(userDecide.equals("1")){

			//System.out.print("Pleast input name of file:  >");
			Scanner scanner = new Scanner( new File("text.txt") );
			String value;
			value = scanner.nextLine();
			
			System.out.println("Choose the method to encrypt text: type 1 for vingenere, 2 for affine");
			@SuppressWarnings("resource")
			Scanner choose = new Scanner(System.in);
			String userChoose = choose.nextLine();
			
			EncryptFunction ef = new EncryptFunction();
			
			if(userChoose.equals("1")){//vigenere encrypt
				
				String key = "mage";
				String cipher1 ="";
				String delims = "[ .,?!]+";
				String data[] = value.split(delims);
				for(int j = 0; j < data.length; j++){
					//if( 97 <= value.charAt(j)&& value.charAt(j) <= 122 ){
					cipher1 = cipher1 + ef.vigenereEncrypt(data[j], key)+ " ";
				}
				System.out.println(cipher1);
				out = new FileWriter("output.txt");
				out.write(cipher1);
				if(out != null)
					out.close();
			}
			
			else if(userChoose.equals("2")){
				
				String cipher2 ="";
				String delims = "[ .,?!]+";
				String data[] = value.split(delims);
				
				for(int j = 0; j < data.length; j++){
					//if( 97 <= value.charAt(j)&& value.charAt(j) <= 122 ){
					cipher2 = cipher2 + ef.affineEncrypt(data[j]) + " ";
				}
				System.out.println(cipher2);
				out = new FileWriter("output.txt");
				out.write(cipher2);
				if(out != null)
					out.close();
			}
			else
				System.out.println("Type only 1 or 2 to choose algorithm");
			
			scanner.close();		
			}
		//for decrypt function
		else if(userDecide.equals("2")){
			
			DecryptFunction df = new DecryptFunction();
			Scanner scanner = new Scanner( new File("output.txt") );
			String value= scanner.nextLine();
			System.out.println(value);
			
			System.out.println("Choose the method to Decrypt text: type 1 for vingenere, 2 for affine");
			@SuppressWarnings("resource")
			Scanner choose = new Scanner(System.in);
			String userChoose = choose.nextLine();
			
			if(userChoose.equals("1")){
				
				String cs[] ={"because", "these", "there", "most", "than", "some", "with", "even", 
				"would"};
				String plKey[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
						"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
				
				for(int fk = 0; fk < plKey.length; fk++){
					for(int sk = 0; sk < plKey.length; sk++){
						String document2 = df.vigenereDecrypt(value, plKey[fk]+plKey[sk]);
						for(int k =0; k <cs.length; k++){
							if(document2.contains(cs[k])){
								System.out.println(document2);
								out = new FileWriter(plKey[fk]+plKey[sk]+".txt");
								out.write(document2);
							}else{
								break;
							}
						}
						for(int tk = 0; tk < plKey.length; tk++){
							String document3 = df.vigenereDecrypt(value,
									plKey[fk]+plKey[sk]+plKey[tk]);
							for(int k =0; k <cs.length; k++){
								if(document3.contains(cs[k])){
									System.out.println(document3);
									out = new FileWriter(plKey[fk]+plKey[sk]+plKey[tk]+".txt");
									out.write(document3);
								}else{
									break;
								}
							}for(int fok = 0; fok < plKey.length; fok++){
								String document4 = df.vigenereDecrypt(value,
										plKey[fk]+plKey[sk]+plKey[tk]+plKey[fok]);
								for(int k = 0; k < cs.length; k++){
									if(document4.contains(cs[k])){
										System.out.println(document4);
										out = new FileWriter(plKey[fk]+plKey[sk]+plKey[tk]+plKey[fok]+".txt");
										out.write(document4);
									}else{
										break;
									}
								}
								
							}
							
						}
						
					}
				}
				if(out!=null)
					out.close();
				/*String document1 = df.vigenereDecrypt(value, key);
				System.out.println(document1);
				out = new FileWriter("decrytext.txt");
				out.write(document1);
				if(out != null)
					out.close();
				*/
			}
			else if(userChoose.equals("2")){
				/*
				//System.out.println("Please type keyA and keyB to decrypt: ");
				@SuppressWarnings("resource")
				Scanner fKey = new Scanner(System.in);
				int firstkey = fKey.nextInt();
				@SuppressWarnings("resource")
				Scanner sKey = new Scanner(System.in);
				int secondkey = sKey.nextInt();
				*/
				String cs[] ={"because", "these", "there", "most", "than", "some", "with", "even", 
						"would"};
				int[] firstKey = {1,3,5,7,9,11,15,17,19,21,23,25};
				
				for(int i = 0; i < firstKey.length; i++){
					for(int secondKey=1; secondKey < 26; secondKey++){
						String document3 = df.affineDecrypt(value, firstKey[i], secondKey);
						for(int k =0; k <cs.length; k++){
							if(document3.contains(cs[k])){
								System.out.println(document3);
								out = new FileWriter(firstKey[i]+secondKey+".txt");
								out.write(document3);
							}
						}
					}
				}
				if(out != null)
					out.close();
				
			}
			else
				System.out.println("Type only 1 or 2 to choose algorithm");
			scanner.close();
		}
		
	}
}