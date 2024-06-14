import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchingTest {
	public static double convertToNumeric(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
	 static String searchChallenge(String[] strArr) {
		// code goes here
		//ArrayList<ArrayList<String>> strAL = new ArrayList<ArrayList<String>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strArr.length; i++) {
			String str[] = strArr[i].split(":");
			for(int j = 1; j < str.length; j++) {
				int x = Integer.parseInt(str[j]);
				if(map.containsKey(str[j-1])) {
					int y = map.get(str[j-1]);
					map.put(str[j-1], y+x);
				}
				else{
					map.put(str[j-1], x); 
				}
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return strArr[0];	
	}
	
	public static void main(String[] args) {
		String string[] = {"X:1","Y:1", "X:-4","B:3" ,"X:5"};
		searchChallenge(string);
	}
}