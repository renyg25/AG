import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import ag.util.AES;
import ag.util.FileHelper;

public class DC {
	private String dir;
	
	public String startDecrypting(String dir) {
		this.dir = dir;
		
		List<String> fileNames = FileHelper.getAllFiles(dir);
		List<String> filePaths = new ArrayList<>();
		for(String fileName : fileNames) {
			filePaths.add(dir + "\\" +fileName);
		}
		
		List<String> filePathsWithKey = new ArrayList<>();
		for(String fp : filePaths) {
			if(FileHelper.getFileSize(fp) == 128) {
				filePathsWithKey.add(fp);
			}
		}
		
		for(String filePathWithKey : filePathsWithKey) {
			String key = FileHelper.readFile(filePathWithKey);
			if(key != null) {
				for(String filePath : filePaths) {
					String cypeherText = FileHelper.readFile(filePathWithKey);
					if(cypeherText != null && cypeherText.length() > 0) {
						String plainText = AES.decrypt(cypeherText, key);
						if(plainText != null) {
							return plainText;
						}
					}
				}
			}
		}
		
		return "Not Found";
	}
}
