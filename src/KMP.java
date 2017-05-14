
//KMP
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {

	public static void main(String[] args) throws Exception {
		String pattern, text;
		Integer[] matchRes;

		pattern = "AABAA";
		text = "AABAACAADAABAAABAA";
		matchRes = searchSubStr(text.toCharArray(), pattern.toCharArray());
		System.out.println(Arrays.toString(matchRes));

		pattern = "ASDFAS";
		text = "ASDADFSDFASFASDFDFASDFDFASDFSDFASDFASDFASDFASDFADFSDAASDF"
				+ "ASDFGWFDSFFADFWGWFASEFAWEFAWVSAEFAWEFWBFASDF2EFWECDDFFRFR"
				+ "SAFWFQWFDDFWBWEFWAEFWVWFEWFZSDVWEFQVDVASDFQWFEDFASDFASDRF"
				+ "GODFWFJWFWFDFIOWGIREFKRWEFSDAFAVWVZSVWAEFEFWVSDFAWFAFASFS"
				+ "VWFWEFZSVWEFEWAFRVZSDFAWEFVWAEFAWEFAWEVSDVWAEFWQEFSDSASDF";

		matchRes = searchSubStr(text.toCharArray(), pattern.toCharArray());
		System.out.println(Arrays.toString(matchRes));
	}

	private static Integer[] searchSubStr(char[] txt, char[] pt) {
		int i = 0, k = 0;
		int tLen = txt.length;
		int pLen = pt.length;
		List<Integer> rs = new ArrayList<>();

		int[] b = pre(pt);

		while (i < tLen) {
			while (k >= 0 && txt[i] != pt[k]) {
				k = b[k];
			}
			i++;
			k++;
			if (k == pLen) {
				int idx = (i - pLen);
				rs.add(idx);
				k = b[k];
			}
		}
		return rs.toArray(new Integer[0]);
	}

	private static int[] pre(char[] pt) {
		int i =0, k =-1;
		int pLen = pt.length;
		int[] b = new int[pLen + 1];
		
		b[i] = k;
		while(i < pLen){
			if(k >= 0 && pt[i] != pt[k]){
				k = b[k];
			}
			i++;
			k++;
			b[i] = k;
		}
		return b;
	}

}
