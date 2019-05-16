import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ag.util.HttpClientUtil;

public class GSApp {
	private String dictUrl;
	private String guessUrl;
	
	private String res;
	
	private List<Integer> lens;
	private Map<Integer, Set<String>> wordDict;		
	
	
	/**
	 * @param dictUrl url to get Dictionary
	 * @param guessUrl url for guessing
	 */
	public GSApp(String dictUrl, String guessUrl) {
		this.dictUrl = dictUrl;
		this.guessUrl = guessUrl;		
	}	
	
	private void getAllWords() {
		String dictList = HttpClientUtil.getString(dictUrl);
		String[] words = dictList.split("\\s+");
		for(String w : words) {
			wordDict.computeIfAbsent(w.length(), s -> new HashSet<>()).add(w);	
		}
	}
	
	private void getWordLengths() {
		String lenStr = HttpClientUtil.getString(guessUrl);
		String[] lenStrs = lenStr.split("\\s+");
		for(String s : lenStrs) {
			lens.add(s.length());
		}
	}

	private void guess(int pos, String pre) {
		if(pos == lens.size()) {
			res = pre;
			return;
		}
		
		for(String s : wordDict.getOrDefault(lens.get(pos), new HashSet<>())) {
			String cur = pre.length() == 0 ? s : pre + "+" + s;
			if(guessWords(cur) == cur.length()) {
				guess(pos + 1, pre.length() == 0 ? s : pre + " " + s);
			}
			
			if(res != null)
				break;
		}
	}
		
	private int guessWords(String words) {
		String lenStr = HttpClientUtil.getString(guessUrl + "?word=" + words);
		if(lenStr == null || lenStr.length() == 0)
			return 0;
		
		return Integer.parseInt(lenStr);
	}
	
	private void intialize() {
		res = null;
		lens = new ArrayList<>();
		wordDict = new HashMap<>();
	}
	
	public String startGuessing() {		
		intialize();
		getAllWords();		
		getWordLengths();
		guess(0, "");
		
		return res;
	}
	
}
