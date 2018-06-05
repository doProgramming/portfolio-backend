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

}
