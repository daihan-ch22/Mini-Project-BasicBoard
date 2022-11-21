package MiniProject.BasicBoard.V1.member.entity;

import MiniProject.BasicBoard.V1.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberRoleType memberRole;

    @OneToMany(mappedBy = "member")
    private List<Board> posts = new ArrayList<>();


    @Builder
    public Member(Long id, String name, String email, MemberRoleType memberRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberRole = memberRole;
    }
}
