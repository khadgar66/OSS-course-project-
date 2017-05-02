package Assignment1Bo;

public class EncryptFunction {
	public String vigenereEncrypt(String text, String key){
		String cipher = "";
		String k = "";
		for(int i = 0; i < (text.length() / key.length() + 1); i++ ){
			k = k + key;
		}
		key = k;
			
		char data[] = new char[text.length()];
		for(int i = 0; i < text.length(); i++){
			if (text.charAt(i) + key.charAt(i) - 97 > 122){
				data[i] = (char) (text.charAt(i) + key.charAt(i) - 97 - 26);
			}else data[i] = (char) (text.charAt(i) + key.charAt(i) - 97);
		}
		cipher = String.copyValueOf(data);
		return cipher;
	}
	
	public String affineEncrypt(String text){
		
		int[] a = {1,3,5,7,9,11,15,17,19,21,23,25};
		int i = (int)(Math.random()*a.length);
		int firstKey = a[i];
	    int secondKey = (int)(Math.random()*26);
		int module = 26;
		System.out.println("The a equal to "+firstKey);
		System.out.println("The b equal to "+secondKey);
		
	    String cipher = "";
	    char data[] = new char[text.length()];
	    for (int in = 0; in < text.length(); in++) {
	        char character = text.charAt(in);
	        if (Character.isLetter(character)) {
	            data[in] = (char) ((firstKey * (character - 'a') + secondKey) % module + 'a');
	        }
	        cipher = cipher + String.valueOf(data[in]);
	    }
	    return cipher;
	}
	
}