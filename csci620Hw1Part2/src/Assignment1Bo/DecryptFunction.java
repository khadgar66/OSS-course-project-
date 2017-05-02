package Assignment1Bo;

public class DecryptFunction {
	public String vigenereDecrypt(String text, String key){
		String realDoc = "";
		
		String k = "";
		for(int i = 0; i < (text.length() / key.length() + 1); i++ ){
			k = k + key;
		}
		key = k;
			
		char data[] = new char[text.length()];
		for(int i = 0; i < text.length(); i++){
			if (text.charAt(i) - key.charAt(i)+97 < 97)
				data[i] = (char) (text.charAt(i) - key.charAt(i) + 97 + 26);
			else data[i] = (char) (text.charAt(i) - key.charAt(i) + 97);
		}
		realDoc = String.copyValueOf(data);
		return realDoc;
	}
	
	public String affineDecrypt(String text, int firstkey, int secondKey){
		String realDoc = "";
		int module = 26;
		int invFirstKey = 0;
	    char data[] = new char[text.length()];
	    for(int i = 1; i < 26; i++){
	    	if((i*firstkey)%module ==1)
	    		invFirstKey = i;
	    }
	    
	    for (int in = 0; in < text.length(); in++) {
	        char character = text.charAt(in);
	        if (Character.isLetter(character)) {
	        	data[in] = (char)(invFirstKey*(character - 'a' - secondKey +26)% module +'a');
	            //data[in] = (char) ((firstkey * (character - 'a') + secondKey) % module + 'a');
	        }
	        realDoc = realDoc + String.valueOf(data[in]);
	    }
	    return realDoc;
		
	}	
}