package product.portfoliosite.user.dto;
import product.portfoliosite.user.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**DTO class for
 * @see User
 * */
@Data
@NoArgsConstructor
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO(User bean) {
        super();
        BeanUtils.copyProperties(bean, this);
    }

}
