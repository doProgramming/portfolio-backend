package product.portfoliosite.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;


@Entity
@Audited
@Table(name = "userr",schema = "public")
@Data
//The problem is that entities are loaded lazily and serialization happens before they get loaded fully.
//So we need JsonIgnore annotation
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

   @Id
   @SequenceGenerator(name="seq",sequenceName="postgreseq")
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
   @Column(name = "id")
    private Integer id;

    @Column(name = "firstname",nullable = false)
    private String firstName;

    @Column(name = "lastname",nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
