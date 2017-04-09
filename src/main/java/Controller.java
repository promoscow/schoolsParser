import model.Provider;
import vo.School;

import java.util.Arrays;
import java.util.List;

/**
 * Created by promoscow on 08.04.17.
 */
public class Controller {
    private Provider[] providers;
    private Model model;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            List<School> list = null;
            for (Provider provider : providers) {
                List<School> schools = provider.getMoscowSchools("");
                for (School school : schools) {
                    list.add(school);
                }
            }
            System.out.println(list.size());
        } catch (NullPointerException e) {
            System.out.println(0);
        }
    }
}
