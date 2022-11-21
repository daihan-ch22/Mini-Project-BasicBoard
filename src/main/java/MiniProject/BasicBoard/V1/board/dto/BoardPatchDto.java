package MiniProject.BasicBoard.V1.board.dto;

import MiniProject.BasicBoard.V1.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardPatchDto {

    private String title;
    private String body;

    @Builder
    public BoardPatchDto(String title, String body) {
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
