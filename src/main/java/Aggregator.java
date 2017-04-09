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
        SchoolStrategy strategy = new SchoolStrategy();
        Provider provider = new Provider(strategy);
        Controller controller = new Controller(provider);
        strategy.getSchools("");
        System.out.println(controller);
        controller.scan();
    }
}
