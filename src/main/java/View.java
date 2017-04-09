import vo.School;

import java.util.List;


/**
 * Created by promoscow on 09.04.17.
 */
public interface View {

    void update(List<School> schools);
    void setController(Controller controller);
}
