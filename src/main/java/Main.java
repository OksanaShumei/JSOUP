import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{

        ArrayList<Integer> list = new ArrayList<Integer>();

        //отримуємо html-код сторінки
        Document document = Jsoup.connect("https://free-proxy-list.net/").get();

        //знаходимо таблицю в документі
        Element table = document.select("table").first();

        //розбиваємо на рядки по тегу <tr>
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++){
            Element row = rows.get(i); // по номеру індексу отримуємо рядок
            Elements cols = row.select("td"); // розбиваємо отриманий рядок по тегу <td> на стовпці
            System.out.println(cols.get(0).text()); // IP Address
            System.out.println(cols.get(1).text()); // Port
            System.out.println();
        }
    }
}
