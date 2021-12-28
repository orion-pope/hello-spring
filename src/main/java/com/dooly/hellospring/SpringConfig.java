package com.dooly.hellospring;

import com.dooly.hellospring.repository.JpaMemberRepository;
import com.dooly.hellospring.repository.MemberRepository;
import com.dooly.hellospring.repository.MemoryMemberRepository;
import com.dooly.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JpaMemberRepository(em);
//        return new JpaMemberRepository(em);
//    }
}
