package com.inflearn.springbasic;

import com.inflearn.springbasic.repository.MemberRepository;
import com.inflearn.springbasic.repository.MemoryMemberRepository;
import com.inflearn.springbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
