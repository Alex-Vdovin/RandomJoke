import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Joke {

	public static void main(String[] args) throws IOException {
		String url = "https://www.anekdots.com/%D0%A1%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D1%8B%D0%B9_%D0%B0%D0%BD%D0%B5%D0%BA%D0%B4%D0%BE%D1%82/";
		Document page = Jsoup.parse(new URL(url), 3000);
		randomJoke(page);
	}
	public static void randomJoke(Document page) {
		formatString(page.select("table[cellspacing = 5]").select("div[class = marg10]").text());
	}
	
	public static void formatString(String string) {
		int limit = 30;
		String[] strings = string.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String str : strings) {
			sb = checkLimit(sb.append(str).append(" "), limit);
		}
		System.out.println(sb);
	}
	public static StringBuilder checkLimit(StringBuilder sb, int limit) {
		if(sb.length() > limit) {
			System.out.println(sb);
			sb.delete(0, sb.length());
			return sb;
		}
		return sb;
	}

}
