package city;

import com.sun.org.apache.regexp.internal.RE;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by promoscow on 11.04.17.
 */
public class CityStrategy {
    private final String URL_FORMAT = "http://mymoscowcity.com/companies/alphabet/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    protected Document getDocument() throws IOException {
        return Jsoup.connect(URL_FORMAT).userAgent(USER_AGENT).referrer(REFERRER).get();
    }

    public void getCityData() {
        ArrayList<City> companies = new ArrayList<>();
        try {
            Document document = getDocument();
            List<Element> list = document.getElementsByAttributeValue("class", "companies-list-text");
            for (Element element : list) {
                if (element.getElementsByAttributeValue("class", "companies-list-text").attr("href").equals("/companies/%2Fcompanies%2F7/")) continue;
                String page = "http://mymoscowcity.com" + element.getElementsByAttributeValue("class", "companies-list-text").attr("href");
                String name = element.getElementsByAttributeValue("class", "companies-list-text-title").text();
                String desc = element.getElementsByAttributeValue("class", "companies-list-text").text();
                String desc1 = desc.replace(element.getElementsByAttributeValue("class", "companies-list-text-title").text() + " ", "");
                String description = desc1.replace(" подробнее", "");
                String contactPage = page.replace("companies/", "companies/contacts/");
                City company = getCompany(contactPage, name, description);
                companies.add(company);
                System.out.println(company);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Companies: " + companies.size());
        ExcellCityView.process(Sorter.sort(companies));
    }

    private City getCompany(String page, String name, String description) {
        City company = new City();
        Document document = null;
        try {
            document = Jsoup.connect(page).userAgent(USER_AGENT).referrer(REFERRER).get();
//            System.out.println(page);
//            BufferedWriter writer = new BufferedWriter(new FileWriter("cont.html"));
//            writer.write(document.html());
//            writer.close();
            company.setName(name);
            company.setTower(document.getElementsByAttributeValueStarting("href", "/towers/").first().text());
//            company.setDescription(document.getElementsByAttributeValue("class", "company-text").text());
            company.setDescription(description);

            String contacts = document.getElementsByAttributeValue("class", "company-text").text();

            Matcher matcher = Pattern.compile("(Телефон: ).+(Сайт)").matcher(contacts);
            if (matcher.find()) company.setPhone(matcher.group().replace("Телефон: ", "").replace(" Сайт", ""));

            Matcher siteMatcher = Pattern.compile("(Сайт: ).+(Адрес почты:)").matcher(contacts);
            if (siteMatcher.find()) company.setSite(siteMatcher.group().replace("Сайт: ", "").replace(" Адрес почты:", ""));

            Matcher emailMatcher = Pattern.compile("(Адрес почты: ).+").matcher(contacts);
            if (emailMatcher.find()) company.setEmail(emailMatcher.group().replace("Адрес почты: ", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return company;
    }
}
