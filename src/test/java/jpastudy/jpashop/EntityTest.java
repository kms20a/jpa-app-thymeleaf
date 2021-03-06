package jpastudy.jpashop;

import jpastudy.jpashop.domain.*;
import jpastudy.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EntityTest {
    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void member_order_delivery_orderItem() throws Exception {
        Member member = new Member();
        member.setName("길동");
        Address address = new Address("서울", "성내로", "1234");
        member.setAddress(address);
        em.persist(member);

        Order order = new Order();
        order.setMember(member);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);
        order.setDelivery(delivery);

        Book item = new Book();
        item.setName("부트책");
        item.setStockQuantity(20);
        item.setPrice(2000);
        item.setAuthor("김부트");
        item.setIsbn("11111");
        em.persist(item);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(1000);
        orderItem.setCount(10);

        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        em.persist(order);
        /*
        Caused by: java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException:
        object references an unsaved transient instance - save the transient instance before flushing :
        jpastudy.jpashop.domain.Order.delivery -> jpastudy.jpashop.domain.Delivery
         */

    }

    @Test
    @Rollback(value = false)
    public void member_order_address_delivery() throws Exception {
        Member member = new Member();
        member.setName("길동");
        Address address = new Address("서울", "성내로", "1234");
        member.setAddress(address);
        em.persist(member);

        Order order = new Order();
        order.setMember(member);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);
        order.setDelivery(delivery);

        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());

        em.persist(order);
        /*
        Caused by: java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException:
        object references an unsaved transient instance - save the transient instance before flushing :
        jpastudy.jpashop.domain.Order.delivery -> jpastudy.jpashop.domain.Delivery
         */

    }

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