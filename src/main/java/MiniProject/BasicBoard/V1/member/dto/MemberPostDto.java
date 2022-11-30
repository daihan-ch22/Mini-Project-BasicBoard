package MiniProject.BasicBoard.V1.member.dto;

import MiniProject.BasicBoard.V1.member.entity.Member;
import MiniProject.BasicBoard.V1.member.entity.MemberRoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberPostDto {

    private String name;
    private String password;
    private String email;
    private MemberRoleType roleType; //사용자 생성시 기본값

    @Builder
    public MemberPostDto(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
        this.roleType = MemberRoleType.USER;
    }

    public Member memberDtoToEntity(){
        return Member.builder()
                .name(name)
                .password(password)
                .email(email)
                .memberRole(roleType)
                .build();
    }

}
