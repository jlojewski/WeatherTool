package dal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="native"
    )
    private Integer id;

    @Column(name = "default_number_of_days", nullable = false)
    private Integer defaultNumberOfDays;

    @Column(name = "default_city", nullable = false)
    private String defaultCity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDefaultNumberOfDays() {
        return defaultNumberOfDays;
    }

    public void setDefaultNumberOfDays(Integer defaultNumberOfDays) {
        this.defaultNumberOfDays = defaultNumberOfDays;
    }

    public String getDefaultCity() {
        return defaultCity;
    }

    public void setDefaultCity(String defaultCity) {
        this.defaultCity = defaultCity;
    }
}
