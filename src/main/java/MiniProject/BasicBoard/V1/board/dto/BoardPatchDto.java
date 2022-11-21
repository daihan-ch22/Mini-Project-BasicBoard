package MiniProject.BasicBoard.V1.board.dto;

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
}
