package MiniProject.BasicBoard.V1.board.dto;

import MiniProject.BasicBoard.V1.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardPostDto {

    private String title;
    private String body;

    @Builder
    public BoardPostDto(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Board dtoToBoardEntity() {
        return Board.builder()
                .title(title)
                .body(body)
                .build();
    }

}
