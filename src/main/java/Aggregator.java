import city.CityStrategy;
import model.Provider;
import model.SchoolStrategy;

/**
 * Created by promoscow on 08.04.17.
 */
public class Aggregator {
    public static void main(String[] args) {
//        View view = new ExcellView();
//        Model model = new Model(view);
//        Controller controller = new Controller(model);
//        view.setController(controller);

        /**
         * Школы с сайта "Мел"
         */
//        SchoolStrategy strategy = new SchoolStrategy();
//        Provider provider = new Provider(strategy);
//        Controller controller = new Controller(provider);
//        strategy.getSchools("");
//        System.out.println(controller);
//        controller.scan();

        /**
         * Москва — Сити
         */
        CityStrategy cityStrategy = new CityStrategy();
        cityStrategy.getCityData();
    }
}
