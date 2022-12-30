package MiniProject.BasicBoard.V1.member.controller;

import MiniProject.BasicBoard.V1.member.dto.LoginDto;
import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.service.MemberService;
import MiniProject.BasicBoard.V1.member.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;
    private final SessionManager sessionManager;

    public String login(@RequestBody LoginDto loginDto, HttpServletResponse response){

        Member loggedInMember = memberService.login(loginDto.getLoginId(), loginDto.getPassword());

        if(loggedInMember == null){
            return "Invalid login Info";
        }

        sessionManager.createSession(loggedInMember, response);
        return "LoggedIn";
    }
}
