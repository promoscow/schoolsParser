package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import view.ExcellView;
import vo.School;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by promoscow on 08.04.17.
 */
public class SchoolStrategy implements Strategy {
    private final String URL_FORMAT = "http://schools.mel.fm/school/gimnazii?page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private static final String REFERRER = "none";

    private final String filePath = "./src/" + String.valueOf(this
            .getClass()
            .getPackage()
            .getName()
            .replace(".", "/") + "/schools-test.html");

    protected Document getDocument(int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, page)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }

    public void getSchools(String searchString) {
        ArrayList<School> schools = new ArrayList<School>();
        try {
            for (int i = 0; true; i++) {
                Document document = null;
                try {
                    document = getDocument(i);
                } catch (IOException e) {
                    System.out.println("Oops!");
                }
                if (document == null) continue;
                List<Element> list = document.getElementsByAttributeValue("class",
                        "i-control b-sm-item b-sm-item_stendhal b-sm-item-list__item b-sm-item_type_school  b-sm-item_entity");
                if (list.isEmpty()) break;
                for (Element element : list) {
                    if (!element.getElementsByAttributeValue("class",
                            "i-control b-sm-link b-sm-link_stendhal b-sm-link_dark-theme b-sm-item__link-name  b-sm-link_size_7xl")
                            .text().contains("Гимназия") &&
                            !element.getElementsByAttributeValue("class",
                                    "i-control b-sm-link b-sm-link_stendhal b-sm-link_dark-theme b-sm-item__link-name  b-sm-link_size_7xl")
                                    .text().contains("Лицей")) continue;
                    String personalPage = "http://schools.mel.fm" + element.getElementsByAttributeValue("class",
                            "i-control b-sm-link b-sm-link_stendhal b-sm-link_dark-theme b-sm-item__link-name  b-sm-link_size_7xl")
                            .attr("href");
                    School school = getSchoolData(personalPage);
                    schools.add(school);
                    System.out.println(school);
                }
            }
            ExcellView.process(schools);

        } catch (IOException e) {
            System.out.println("Oops!");
        }
    }

    private School getSchoolData(String personalPage) throws IOException {
        School school = new School();
        Document document = null;
        try {
            document = Jsoup.connect(personalPage).userAgent(USER_AGENT).referrer(REFERRER).get();
        } catch (IOException e) {
            return null;
        }
        List<Element> addresses = document.getElementsByAttributeValue("class", "b-data-block__item-content-address");
        ArrayList<String> ads = new ArrayList<String>();
        for (Element address : addresses) {
            ads.add((address.getElementsByAttributeValue("class", "b-data-block__item-content-address").text()));
        }
        school.setAddress(ads);
        school.setName(document.getElementsByAttributeValue("class", "l-school__name").text());
        school.setPhone(validatePhone(document.getElementsByAttributeValue("class", "b-data-block__content").text()));
        school.setDirector(validateDirector(document.getElementsByAttributeValue("class", "b-data-block__content").text()));
        school.setMetro(document.getElementsByAttributeValue("class",
                "i-control g-icon g-icon_stendhal b-data-block__metro-icon  g-icon_svg g-icon_img_metro").text());
        school.setRating(validateRating(document.getElementsByAttributeValue("class", "b-mark__mark").text()));
//            school.setDepRating(document.getElementsByAttributeValue("class", "").text());
//            BufferedWriter writer = new BufferedWriter(new FileWriter("sc1.html"));
//            System.out.println(document.html());
//            writer.write(document.html());
//            writer.close();

        return school;
    }

    private String validateRating(String string) {
        StringTokenizer st = new StringTokenizer(string, " ");
        return st.nextToken();
    }

    private String validateDirector(String string) {
        StringTokenizer st = new StringTokenizer(string, " ");
        StringBuilder builder = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("Директор")) {
                st.nextToken();
                for (int i = 0; i < 3; i++) {
                    builder.append(st.nextToken());
                    builder.append(" ");
                }
                return builder.toString();
            }
        }
        return null;
    }

    private String validatePhone(String string) {
        StringTokenizer st = new StringTokenizer(string, " ");
        StringBuilder builder = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals("Телефоны8")) {
                builder.append(s.substring(8));
                builder.append(" ");
                builder.append(st.nextToken());
                builder.append(" ");
                builder.append(st.nextToken());
            }
        }
        return builder.toString();
    }
}
