package com.dooly.hellospring.service;

import com.dooly.hellospring.domain.Member;
import com.dooly.hellospring.repository.MemoryMemberRepository;
import com.dooly.hellospring.repository.MemoryMemberRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findedMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(findedMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}