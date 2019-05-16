package ag.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper {
	public static String readFile(String filePath) {
		if(filePath == null)
			return null;

		StringBuilder sb = new StringBuilder();
		try {			
			File file = new File(filePath);
			if(!file.exists())
				return null;
					
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public static List<String> getAllFiles(String dir){
		List<String> res = new ArrayList<>();
		if(dir == null)
			return res;
		
		File file = new File(dir);
		if(file.exists() && file.isDirectory()) {
			return Arrays.asList(file.list());
		}
		
		return res;
	}

	public static long getFileSize(String filePath) {
		if(filePath == null)
			return 0;
					
		Path path = Paths.get(filePath);
		if(Files.exists(path)) {
			try {
				return Files.size(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
}
