
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
		int tlen = txt.length;
		int plen = pt.length;
		List<Integer> rs = new ArrayList<>();

		int[] b = pre(pt);

		while (i < tlen) {
			while (k >= 0 && txt[i] != pt[k]) {
				k = b[k];
			}
			i++;
			k++;
			if (k == plen) {
				int idx = i - plen;
				rs.add(idx);
				k = b[k];
			}
		}

		return rs.toArray(new Integer[0]);
	}

	private static int[] pre(char[] pt) {
		int i = 0;
		int k = -1;
		int plen = pt.length;

		int[] b = new int[plen + 1];

		b[i] = k;
		while (i < plen) {
			if (k >= 0 && pt[i] != pt[k]) {
				k = b[k];
			}
			i++;
			k++;
			b[i] = k;
		}

		return b;
	}

}
