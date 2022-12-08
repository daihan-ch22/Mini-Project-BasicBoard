package MiniProject.BasicBoard.V1.member.controller;

import MiniProject.BasicBoard.V1.member.dto.MemberGradeDto;
import MiniProject.BasicBoard.V1.member.dto.MemberPatchDto;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    MemberPostDto memberPostDto;
    MemberPostDto memberPostDto1;
    MemberPatchDto memberPatchDto;


    @BeforeEach
    public void testInit(){
        //1
        String name = "name1";
        String password = "12345";
        String email = "email";
        memberPostDto = new MemberPostDto(name, password, email);

        //2
        String name1 = "name2";
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
        Optional<Member> memberTest = memberRepository.findById(memberId);


        //then
        assertThat(memberTest.get().getName()).isEqualTo("name1");
    }

    @Test
    void getMember() {
        //given
        Long memberId = memberService.createMember(memberPostDto);
        Long memberId1 = memberService.createMember(memberPostDto1);

        //when
        Member memberTest = memberService.getMember(memberId1);

        //then
        assertThat(memberTest.getName()).isEqualTo("name2");
    }

    @Test
    void updateMember() {
        //given
        Long memberId = memberService.createMember(memberPostDto);

        String name = "changed!";
        String password = "changedPassword";
        String email = "abc@gmail.com";
        memberPatchDto = new MemberPatchDto(name,password,email);

        //when
        memberService.updateMember(1L, memberPatchDto);
        Member memberTest = memberService.getMember(1L);

        //then
        assertThat(memberTest.getName()).isEqualTo("changed!");
    }

    @Test
    void deleteMember() {
        //given
        Long memberId = memberService.createMember(memberPostDto);
        assertThat(memberService.getMember(memberId).getName()).isEqualTo("name1");

        //when
        memberService.memberGradeToSleep(memberId);
        memberService.deleteMember(memberId);

        //then
        assertThrows(IllegalArgumentException.class, () -> memberService.getMember(1L));
    }

    @Test
    void memberGrade() {
        //given
        Long memberId = memberService.createMember(memberPostDto);

        //when
        memberService.memberGradeToSleep(memberId);

        //then
        assertThat(memberService.getMember(memberId).getMemberRole()).isEqualTo(MemberRoleType.SLEEP);
    }
}