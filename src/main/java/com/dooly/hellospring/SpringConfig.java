package com.dooly.hellospring;

import com.dooly.hellospring.repository.MemberRepository;
import com.dooly.hellospring.repository.MemoryMemberRepository;
import com.dooly.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
