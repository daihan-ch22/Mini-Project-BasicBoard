package MiniProject.BasicBoard.V1.board.controller;

import MiniProject.BasicBoard.V1.board.dto.BoardPatchDto;
import MiniProject.BasicBoard.V1.board.dto.BoardPostDto;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForAll;
import MiniProject.BasicBoard.V1.board.entity.Board;
import MiniProject.BasicBoard.V1.board.repository.BoardRepository;
import MiniProject.BasicBoard.V1.board.service.BoardService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BoardControllerTest {

    BoardPostDto boardPostDto;
    BoardPatchDto boardPatchDto;

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init(){
        String title = "testTitle";
        String body = "testBody";
        boardPostDto = new BoardPostDto(title, body);
    }

    @AfterEach
    public void deleteAllAfterTest() {
        boardRepository.deleteAll();
    }

    @Test
    @DisplayName("Create Post Test")
    void createPost() throws Exception {
        //given & when
        Long id = boardService.createPost(boardPostDto);

        //then
        assertThat(boardService.getOnePost(id).getTitle()).isEqualTo("testTitle");
        assertThat(boardService.getOnePost(id).getBody()).isEqualTo("testBody");

    }

    @Test
    void modifyPost() {
        //given
        Long id = boardService.createPost(boardPostDto);

        //when
        String title = "modifiedTitle";
        String body = "modifiedBody";
        boardPatchDto = new BoardPatchDto(title,body);
        boardService.patchPost(boardPatchDto, id);

        //then
        assertThat(boardService.getOnePost(id).getTitle()).isEqualTo("modifiedTitle");
        assertThat(boardService.getOnePost(id).getBody()).isEqualTo("modifiedBody");
    }

    @Test
    void getOnePost() {
        //given & when
        Long id = boardService.createPost(boardPostDto);

        boardPostDto = new BoardPostDto("secondTitle", "secondBody");
        boardService.createPost(boardPostDto);

        //then
        assertThat(boardService.getOnePost(id).getTitle()).isEqualTo("testTitle");
        assertThat(boardService.getOnePost(id+1).getBody()).isEqualTo("secondBody");

    }

    @Test
    void getAllPosts() {
        //given
        boardService.createPost(boardPostDto);
        boardService.createPost(boardPostDto);
        boardService.createPost(boardPostDto);

        //when
        List<BoardResponseDtoForAll> testList = boardService.getAllPosts();

        //then
        assertThat(testList.size()).isEqualTo(3);

    }

    @Test
    void deletePost() {
        //given
        Long targetId = boardService.createPost(boardPostDto);

        //when
        boardService.deletePost(targetId);

        //then (if the post is deleted, exception should be caused
        Assertions.assertThrows(IllegalArgumentException.class, () -> boardService.getOnePost(targetId));
    }
}