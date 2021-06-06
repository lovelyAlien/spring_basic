package com.inflearn.springbasic.repository;

import com.inflearn.springbasic.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository= new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    void save() {
        Member member= new Member();
        member.setName("spring");
        repository.save(member);

        Member result= repository.findById(member.getId()).get();
//        System.out.println("result= "+ (result==member));
        assertThat(member).isEqualTo(result);
    }
    @Test
    void findByName() {
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result= repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);
    }


    @Test
    void findAll() {
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);


        List<Member> result= repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
