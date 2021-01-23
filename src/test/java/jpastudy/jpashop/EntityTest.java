package jpastudy.jpashop;

import jpastudy.jpashop.domain.Member;
import jpastudy.jpashop.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EntityTest {
    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void member_order() {
        Member member = new Member();
        member.setName("부트");
        em.persist(member);

        Order order = new Order();
        order.setMember(member);
    }
}