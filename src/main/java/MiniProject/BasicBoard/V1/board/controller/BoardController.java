package MiniProject.BasicBoard.V1.board.controller;

import MiniProject.BasicBoard.V1.board.dto.BoardPatchDto;
import MiniProject.BasicBoard.V1.board.dto.BoardPostDto;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForAll;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForOne;
import MiniProject.BasicBoard.V1.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    //DI
    private final BoardService boardService;


    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody BoardPostDto postDto){

        log.debug("Successfully created new post, Post Id={}", boardService.createPost(postDto));
        return ResponseEntity.ok("새 게시물 등록 완료");
    }

    @PatchMapping("/{post-id}")
    public ResponseEntity modifyPost(@RequestBody BoardPatchDto patchDto, @PathVariable("post-id") Long id) {
        log.debug("Successfully patched Post Id={}", boardService.patchPost(patchDto, id));

        return ResponseEntity.ok("게시물 수정 완료");
    }

    @GetMapping("/{post-id}")
    @ResponseStatus(HttpStatus.OK)
    public BoardResponseDtoForOne getOnePost(@PathVariable("post-id") Long id) {

        log.debug("Get One Post! Post Id={}", id);

        return boardService.getOnePost(id);
    }

    @GetMapping("/all-posts")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDtoForAll> getPosts() {
        log.debug("get whole posts");

        return boardService.getAllPosts();
    }

    @DeleteMapping("/{post-id}")
    public ResponseEntity deletePost(@PathVariable("post-id") Long id){
        log.debug("deletePost");

        boardService.deletePost(id);
        return ResponseEntity.ok("Deletion completed");
    }


}
