package MiniProject.BasicBoard.V1.member.service;

import MiniProject.BasicBoard.V1.member.dto.MemberPatchDto;
import MiniProject.BasicBoard.V1.member.dto.MemberPostDto;
import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.entity.MemberRoleType;
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

    public Long updateMember(Long id,MemberPatchDto memberPatchDto){
        Member member = verifyingMember(id);
        member.update(memberPatchDto.getName(), memberPatchDto.getPassword(), memberPatchDto.getEmail());

        return memberRepository.save(member).getId();
    }

    public Member getMember(Long id){
        return verifyingMember(id);
    }

    //회원 삭제로 바로 가지 않고 휴면으로 거침
    public void memberGradeToSleep(Long id) {
        Member member = verifyingMember(id);
        member.changeGrade(MemberRoleType.SLEEP);
    }

    //휴면 상태인 사용자만 최종 삭제 가능
    public void deleteMember(Long id){
        Member member = verifyingMember(id);
        if(member.getMemberRole().equals(MemberRoleType.SLEEP)){
            memberRepository.delete(member);
        } else {
            memberGradeToSleep(id);
        }
    }

    //멤버 가입 여부 반별
    private Member verifyingMember(Long id){
        return memberRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
