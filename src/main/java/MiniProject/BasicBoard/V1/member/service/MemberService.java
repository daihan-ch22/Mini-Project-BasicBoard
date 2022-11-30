package MiniProject.BasicBoard.V1.member.service;

import MiniProject.BasicBoard.V1.member.dto.MemberPostDto;
import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Long createMember(MemberPostDto memberPostDto){
        Member member = memberPostDto.memberDtoToEntity();
        return memberRepository.save(member).getId();
    }

}
