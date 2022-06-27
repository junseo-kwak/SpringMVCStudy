package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void save(){
        //given
        Member member = new Member("name",30);

        //when
        Member savedMember = memberRepository.save(member);
        //then

        Member findMember = memberRepository.findById(savedMember.getId());


        Assertions.assertThat(savedMember).isEqualTo(findMember);
    }




}
