import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ag.util.AES;
import ag.util.FileHelper;
import ag.util.HttpClientUtil;

class TestAG {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAG t = new TestAG();
		t.Test();
	}
	
	public void Test() {
		//System.out.println();
		//System.out.println(HttpClientUtil.getString("http://www.server.com/dict"));
		//System.out.println(HttpClientUtil.getString("http://www.server.com/guess"));
		//System.out.println(HttpClientUtil.getString("http://www.server.com/guess?word=P"));
		
		//File file = new File(a);
		//GSApp app = new GSApp("http://www.server.com/dict", "http://www.server.com/guess");
		//System.out.println(app.startGuessing());
		
	    final String secretKey = "ssshhhhhhhhhhh!!";
	     
	    String originalString = "howtodoinjava.com";
	    String encryptedString = AES.encrypt(originalString, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);


		//String res = HttpClientUtil.get("http://www.server.con/guess?word=" + "Please");
		//System.out.println(res);
	}
}
