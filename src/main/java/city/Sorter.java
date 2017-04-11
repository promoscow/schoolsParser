package city;

import java.util.ArrayList;

/**
 * Created by promoscow on 12.04.17.
 */
public class Sorter {
    public static ArrayList<ArrayList<City>> sort(ArrayList<City> companies) {
        ArrayList<ArrayList<City>> towers = new ArrayList<>();
        ArrayList<City> neva = new ArrayList<>();
        ArrayList<City> afimoll = new ArrayList<>();
        ArrayList<City> fed = new ArrayList<>();
        ArrayList<City> stol = new ArrayList<>();
        ArrayList<City> nab = new ArrayList<>();
        ArrayList<City> merc = new ArrayList<>();
        ArrayList<City> imp = new ArrayList<>();
        ArrayList<City> evo = new ArrayList<>();
        ArrayList<City> evr = new ArrayList<>();
        ArrayList<City> sev = new ArrayList<>();
        ArrayList<City> b2000 = new ArrayList<>();
        ArrayList<City> iq = new ArrayList<>();
        ArrayList<City> oko = new ArrayList<>();
        ArrayList<City> bagr = new ArrayList<>();
        ArrayList<City> expo = new ArrayList<>();
        ArrayList<City> novo = new ArrayList<>();
        for (City company : companies) {
            if (company.getTower().equals("Neva towers")) neva.add(company);
            if (company.getTower().equals("Афимолл")) afimoll.add(company);
            if (company.getTower().equals("Комплекс Федерация")) fed.add(company);
            if (company.getTower().equals("Город Столиц")) stol.add(company);
            if (company.getTower().equals("Башня на набережной")) nab.add(company);
            if (company.getTower().equals("Меркурий Сити Тауэр")) merc.add(company);
            if (company.getTower().equals("Комплекс \"Империя\"")) imp.add(company);
            if (company.getTower().equals("Башня Эволюция")) evo.add(company);
            if (company.getTower().equals("Башня Евразия")) evr.add(company);
            if (company.getTower().equals("Северная башня")) sev.add(company);
            if (company.getTower().equals("Башня 2000")) b2000.add(company);
            if (company.getTower().equals("Башня IQ центр")) iq.add(company);
            if (company.getTower().equals("Башня Око")) oko.add(company);
            if (company.getTower().equals("Мост Багратион")) bagr.add(company);
            if (company.getTower().equals("Экспоцентр")) expo.add(company);
            if (company.getTower().equals("Новотель")) novo.add(company);
        }
        towers.add(neva);
        towers.add(afimoll);
        towers.add(fed);
        towers.add(stol);
        towers.add(nab);
        towers.add(merc);
        towers.add(imp);
        towers.add(evo);
        towers.add(evr);
        towers.add(sev);
        towers.add(b2000);
        towers.add(iq);
        towers.add(oko);
        towers.add(bagr);
        towers.add(expo);
        towers.add(novo);
        return towers;
    }
}
