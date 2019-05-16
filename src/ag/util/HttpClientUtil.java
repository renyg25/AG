package ag.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientUtil {
	public static String getString(String url) {
		if(url == null)
			return null;
		
		if(url != null) {
			return get(url);
		}
		
		String res = null;
		try {
			URL Url = new URL(url);
			HttpURLConnection con = (HttpURLConnection) Url.openConnection();
			con.setRequestMethod("GET");
			InputStreamReader reader = new InputStreamReader(con.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			
			StringBuilder sb = new StringBuilder();
			
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
			}
			
			con.disconnect();
			br.close();			
			
			res = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	private static String get(String url) {
		//correct solution
		//Please reply to this email
		if(url.equals("http://www.server.com/dict")) {
			return "at go school to Please server dict guess what word index reply to this email";
		}			
		
		if(url.equals("http://www.server.com/guess"))
			return "------ ----- -- ---- -----";
		
		if(url.startsWith("http://www.server.com/guess?word=")) {
			String ans = "Please reply to this email";
			String p = url.substring(url.indexOf("=") + 1);
			
			int count = 0;
			for(int i = 0; i < Math.min(ans.length(), p.length()); i++) {
				char a = ans.charAt(i), b = p.charAt(i);
				if(a == b || (a == ' ' && b == '+')) {
					count++;
				}
			}
			
			return "" + count;
		}
			
		
		return null;
	}
}
