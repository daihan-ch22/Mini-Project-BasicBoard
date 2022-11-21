package MiniProject.BasicBoard.V1.board.entity;

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
