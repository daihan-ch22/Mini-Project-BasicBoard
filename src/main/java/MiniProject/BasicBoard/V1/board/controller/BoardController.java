package MiniProject.BasicBoard.V1.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boardV1")
@Slf4j
public class BoardController {

    @PostMapping("/board/post")
    public ResponseEntity createPost(){
        log.debug("createPost");

        return ResponseEntity.ok("post");
    }

    @PatchMapping("/{post-id}")
    public ResponseEntity modifyPost() {
        log.debug("patchPost");

        return ResponseEntity.ok("patch");
    }

    @GetMapping("/{board-id}")
    public ResponseEntity getPost() {
        log.debug("getPost");

        return ResponseEntity.ok("get one post");
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
