package city;

/**
 * Created by promoscow on 11.04.17.
 */
public class City {
    private String name;
    private String tower;
    private String description;
    private String phone;
    private String site;
    private String email;

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (tower != null ? !tower.equals(city.tower) : city.tower != null) return false;
        if (description != null ? !description.equals(city.description) : city.description != null) return false;
        if (phone != null ? !phone.equals(city.phone) : city.phone != null) return false;
        if (site != null ? !site.equals(city.site) : city.site != null) return false;
        return email != null ? email.equals(city.email) : city.email == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tower != null ? tower.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", tower='" + tower + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", site='" + site + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
