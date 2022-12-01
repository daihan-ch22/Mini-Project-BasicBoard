package MiniProject.BasicBoard.V1.member.controller;

import MiniProject.BasicBoard.V1.member.dto.MemberPostDto;
import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.entity.MemberRoleType;
import MiniProject.BasicBoard.V1.member.repository.MemberRepository;
import MiniProject.BasicBoard.V1.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    MemberPostDto memberPostDto;
    MemberPostDto memberPostDto1;


    @BeforeEach
    public void testInit(){
        //1
        String name = "name1";
        String password = "12345";
        String email = "email";
        memberPostDto = new MemberPostDto(name, password, email);

        //2
        String name1 = "name1";
        String password1 = "123451";
        String email1 = "email1";
        memberPostDto1 = new MemberPostDto(name1, password1, email1);
    }

    @AfterEach
    public void deleteAllAfterMemberTest(){
        memberRepository.deleteAll();
    }

    @Test
    void createMember() {
        //given & when
        Long memberId = memberService.createMember(memberPostDto);
        Long memberId1 = memberService.createMember(memberPostDto1);

        //then
        Assertions.assertThat(memberId).isEqualTo(1L);
    }

    @Test
    void getMember() {
        //given
        Long memberId = memberService.createMember(memberPostDto);
        Long memberId1 = memberService.createMember(memberPostDto1);


    }

    @Test
    void updateMember() {
    }

    @Test
    void deleteMember() {
    }
}