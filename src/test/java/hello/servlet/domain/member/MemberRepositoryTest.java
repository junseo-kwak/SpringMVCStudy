package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        Member findMember = memberRepository.findById(savedMember.getId());
        //then
        assertThat(savedMember).isEqualTo(findMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("junseo", 30);
        Member member2 = new Member("mikyong",30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> memberList = memberRepository.findAll();
        //then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1,member2);

    }




}
