package MiniProject.BasicBoard.V1.board.controller;

import MiniProject.BasicBoard.V1.board.dto.BoardPatchDto;
import MiniProject.BasicBoard.V1.board.dto.BoardPostDto;
import MiniProject.BasicBoard.V1.board.entity.Board;
import MiniProject.BasicBoard.V1.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boardV1")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    //DI
    private final BoardService boardService;


    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody BoardPostDto postDto){

        log.debug("Successfully created new post, Post Id={}", boardService.savePost(postDto));
        return ResponseEntity.ok("새 게시물 등록 완료");
    }

    @PatchMapping("/{post-id}")
    public ResponseEntity modifyPost(@RequestBody BoardPatchDto patchDto, @PathVariable("post-id") Long id) {
        log.debug("Successfully patched Post Id={}", boardService.patchPost(patchDto, id));

        return ResponseEntity.ok("게시물 수정 완료");
    }

    @GetMapping("/{post-id}")
    public ResponseEntity getOnePost(@PathVariable("post-id") Long id) {

        log.debug("Get One Post!");

        return ResponseEntity.ok(boardService.getOnePost(id));
    }

    @GetMapping("/all-posts")
    public ResponseEntity getPosts() {
        log.debug("get whole posts");

        return ResponseEntity.ok("get whole posts");
    }

    @DeleteMapping("/{post-id}")
    public ResponseEntity deletePost(){
        log.debug("deletePost");

        return ResponseEntity.ok("delete post");
    }


}
