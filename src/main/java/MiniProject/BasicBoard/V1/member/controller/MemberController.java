package MiniProject.BasicBoard.V1.member.controller;

import MiniProject.BasicBoard.V1.member.dto.MemberPostDto;
import MiniProject.BasicBoard.V1.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity createMember(@RequestBody MemberPostDto memberPostDto){
        log.info("Successfully created new Member, Member Id={}", memberService.createMember(memberPostDto));
        return ResponseEntity.ok("회원 가입 성공");
    }

    @GetMapping("/{member-id}")
    public void getMember(@PathVariable(name = "member-id") Long memberId){

    }

    @PatchMapping("/{member-id}")
    public void updateMember(@PathVariable(name = "member-id") Long memberId){

    }

    //delete member -> make deactivate, not removing member data
    @DeleteMapping("/{member-id}")
    public void deleteMember(@PathVariable(name = "member-id") Long memberId){

    }


}
