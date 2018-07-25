package scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Coded by Amdadul Bari Imad
 * Created at 25/7/18
 */
public class GoogleScraper {
    public void scrapResult(String query,int count){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.google.com/search?q="+query+"&num="+count).get();
            System.out.println(doc.title());
            Elements newsHeadlines = doc.select("h3.r>a");
            for (Element headline:newsHeadlines) {
                System.out.print("Title = "+headline.text());
                System.out.println(" Link = "+headline.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
