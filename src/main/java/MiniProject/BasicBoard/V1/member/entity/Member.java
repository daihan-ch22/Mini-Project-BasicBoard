package MiniProject.BasicBoard.V1.member.entity;

import MiniProject.BasicBoard.V1.board.entity.Board;
import MiniProject.BasicBoard.V1.commons.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberRoleType memberRole;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Board> posts = new ArrayList<>();


    public void update(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void changeGrade(MemberRoleType memberRole){
        this.memberRole = memberRole;
    }

    @Builder
    public Member(Long id, String name, String email, String password, MemberRoleType memberRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.memberRole = memberRole;
    }
}
