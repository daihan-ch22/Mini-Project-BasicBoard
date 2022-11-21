package MiniProject.BasicBoard.V1.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @PostMapping("/signup")
    public void signUp() {

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
