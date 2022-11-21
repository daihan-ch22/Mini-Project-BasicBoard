package MiniProject.BasicBoard.V1.board.dto;

import MiniProject.BasicBoard.V1.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDtoForAll {

    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDtoForAll(Board boardEntity){
        this.id = boardEntity.getId();
        this.title = boardEntity.getTitle();
        this.body = boardEntity.getBody();
        this.createdAt = boardEntity.getCreatedAt();
        this.modifiedAt = boardEntity.getModifiedAt();
    }

}
