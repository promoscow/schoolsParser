import model.Provider;
import vo.School;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by promoscow on 09.04.17.
 */
public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void setParams() {
        List<School> list = new ArrayList<School>();
        for (Provider provider : providers) list.addAll(provider.getMoscowSchools(""));
        view.update(list);
    }
}
