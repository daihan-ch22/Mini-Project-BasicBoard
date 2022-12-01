package MiniProject.BasicBoard.V1.member.dto;

import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.entity.MemberRoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberGradeDto {

    private MemberRoleType memberRoleType;

    @Builder
    public MemberGradeDto(MemberRoleType memberRoleType){
        this.memberRoleType = memberRoleType;
    }

    public Member memberGradeDtoToEntity(){
        return Member.builder()
                .memberRole(memberRoleType)
                .build();
    }
}
