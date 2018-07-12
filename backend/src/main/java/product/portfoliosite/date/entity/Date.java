package product.portfoliosite.date.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "date")
@Entity
@Audited
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Date {

    @Column(name = "id")
    @Id
    @SequenceGenerator(name="seq",sequenceName="date_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @NotNull
    private int id;

    @Column(name = "hour")
    private int hour;

    @Column(name = "minutes")
    private int minutes;

    @Column(name = "user_fk")
    private int userForeignkey;

    @OneToMany(mappedBy = "userForeignkey")
    private Collection<Date> users = new ArrayList<Date>();

    public int getUserForeignkey() {
        return userForeignkey;
    }

    public void setUserForeignkey(int userForeignkey) {
        this.userForeignkey = userForeignkey;
    }

    public Collection<Date> getUsers() {
        return users;
    }

    public void setUsers(Collection<Date> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
