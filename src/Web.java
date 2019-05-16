import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Web {
	public void CreateRequest() {		
		try {
			URL url = new URL("http://www.djhub.net");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

//			Map<String, String> ps = new HashMap<>();
//			ps.put("user", "h");
//			
//			con.setDoOutput(true);
			InputStreamReader reader = new InputStreamReader(con.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
