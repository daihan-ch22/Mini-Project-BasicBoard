package MiniProject.BasicBoard.V1.board.entity;

import MiniProject.BasicBoard.V1.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;


    @Builder
    public Board(String title, String body){
        this.title = title;
        this.body = body;
    }

    public void update(String title, String body){
        this.title = title;
        this.body = body;
    }

}
