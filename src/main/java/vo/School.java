package vo;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Created by promoscow on 08.04.17.
 */
public class School {
    private String name;
    private ArrayList<String> address;
    private String phone;
    private String director;
    private String metro;
    private String rating;
    private String depRating;
    private boolean in100;

    public void setIn100(boolean in100) {
        this.in100 = in100;
    }

    public boolean isIn100() {

        return in100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDepRating(String depRating) {
        this.depRating = depRating;
    }

    public String getName() {

        return name;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDirector() {
        return director;
    }

    public String getMetro() {
        return metro;
    }

    public String getRating() {
        return rating;
    }

    public String getDepRating() {
        return depRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (in100 != school.in100) return false;
        if (name != null ? !name.equals(school.name) : school.name != null) return false;
        if (address != null ? !address.equals(school.address) : school.address != null) return false;
        if (phone != null ? !phone.equals(school.phone) : school.phone != null) return false;
        if (director != null ? !director.equals(school.director) : school.director != null) return false;
        if (metro != null ? !metro.equals(school.metro) : school.metro != null) return false;
        if (rating != null ? !rating.equals(school.rating) : school.rating != null) return false;
        return depRating != null ? depRating.equals(school.depRating) : school.depRating == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (metro != null ? metro.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (depRating != null ? depRating.hashCode() : 0);
        result = 31 * result + (in100 ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address=" + showAddress(address) +
                ", phone='" + phone + '\'' +
                ", director='" + director + '\'' +
                ", metro='" + metro + '\'' +
                ", rating='" + rating + '\'' +
                ", depRating='" + depRating + '\'' +
                ", in100=" + in100 +
                '}';
    }

    private String showAddress(ArrayList<String> address) {
        StringBuilder builder = new StringBuilder();
        for (String s : address) {
            builder.append(s);
            builder.append(" / ");
        }
        return builder.toString().trim();
    }

    public String getFormattedAddress(ArrayList<String> address) {
        StringBuilder builder = new StringBuilder();
        for (String addres : address) {
            builder.append(addres);
            builder.append("\n");
        }
        return builder.toString();
    }
}
