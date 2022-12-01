package MiniProject.BasicBoard.V1.member.controller;

import MiniProject.BasicBoard.V1.member.dto.MemberPatchDto;
import MiniProject.BasicBoard.V1.member.dto.MemberPostDto;
import MiniProject.BasicBoard.V1.member.entity.Member;
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

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity createMember(@RequestBody MemberPostDto memberPostDto){
        log.info("Successfully created new Member, Member Id={}", memberService.createMember(memberPostDto));
        return new ResponseEntity<>("회원 가입 성공", HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable(name = "member-id") Long memberId){
        log.info("Successfully found member detail, Member name={} ", memberService.getMember(memberId));
        return new ResponseEntity<>("회원 조회 성공",HttpStatus.OK);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity updateMember(@PathVariable(name = "member-id") Long memberId,
                             @RequestBody MemberPatchDto memberPatchDto){
        log.info("Successfully updated new Member, Member Id={}", memberService.updateMember(memberId,memberPatchDto));

        return new ResponseEntity<>("회원 정보 업데이트 성공", HttpStatus.OK);
    }

    @PostMapping("/{member-id")
    public ResponseEntity sleepMember(@PathVariable(name = "member-id") Long memberId){
        log.info("Member status has changed USER -> SLEEP, Member Id={}", memberId);
        memberService.memberGradeToSleep(memberId);

        return new ResponseEntity<>("회원 등급 변경 USER -> SLEEP", HttpStatus.OK);
    }

    //delete member -> make deactivate, not removing member data
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable(name = "member-id") Long memberId){
        log.info("Member details are terminated. Member Id={}", memberId);
        memberService.deleteMember(memberId);
        return new ResponseEntity<>("회원 정보 완전 삭제 완료", HttpStatus.NO_CONTENT);
    }


}
