package MiniProject.BasicBoard.V1.board.dto;

import MiniProject.BasicBoard.V1.board.entity.Board;
import lombok.Getter;


@Getter
public class BoardResponseDtoForOne {

    private Long id;
    private String title;
    private String body;

    public BoardResponseDtoForOne(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.body = board.getBody();
    }

}
