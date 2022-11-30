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

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "member")
    private List<Board> posts = new ArrayList<>();




    @Builder
    public Member(Long id, String name, String email, String password, LocalDateTime createdAt, MemberRoleType memberRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.memberRole = memberRole;
    }
}
