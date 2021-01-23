package jpastudy.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class User {
//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue
    private long id;

    private String username;
}
