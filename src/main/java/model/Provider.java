package model;

import vo.School;

import java.util.List;

/**
 * Created by promoscow on 08.04.17.
 */
public class Provider {
    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<School> getMoscowSchools(String searchString) {
        return null;
    }
}
