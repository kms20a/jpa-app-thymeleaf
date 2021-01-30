package jpastudy.jpashop.service;

import jpastudy.jpashop.domain.Member;
import jpastudy.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("boot");
        //When
        Long saveId = memberService.join(member);
        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }


}