package com.dooly.hellospring.repository;

import com.dooly.hellospring.domain.Member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트간의 의존관계가 있으므로 @AfterEach 어노테이션을 활용하여 각 단위테스트가 끝날 때마다 저장소를 클리어한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("무무");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("휴지");

        repository.save(member);

        Member result = repository.findByname("휴지").get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("휴지");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("마리");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
