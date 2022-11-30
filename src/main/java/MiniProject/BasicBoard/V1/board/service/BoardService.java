package MiniProject.BasicBoard.V1.board.service;

import MiniProject.BasicBoard.V1.board.controller.BoardController;
import MiniProject.BasicBoard.V1.board.dto.BoardPatchDto;
import MiniProject.BasicBoard.V1.board.dto.BoardPostDto;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForAll;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForOne;
import MiniProject.BasicBoard.V1.board.entity.Board;
import MiniProject.BasicBoard.V1.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long createPost(BoardPostDto postDto){

        return boardRepository.save(postDto.dtoToBoardEntity()).getId();
    }

    @Transactional
    public Long patchPost(BoardPatchDto patchDto, Long id){

        //ID 검증 & 가져오기
        Board board = verifyingBoard(id);
        //ID로 Board Entity내용을 Builder로 수정
        board.update(patchDto.getTitle(), patchDto.getBody());

        return id;
    }

    @Transactional(readOnly = true)
    public BoardResponseDtoForOne getOnePost(Long id){

        Board targetBoard = verifyingBoard(id);
        return new BoardResponseDtoForOne(targetBoard);
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDtoForAll> getAllPosts(){
        return boardRepository.findAllPostByOrder().stream()
                .map(BoardResponseDtoForAll::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePost(Long id){
        Board targetBoard = verifyingBoard(id);
        boardRepository.delete(targetBoard);
    }

    //해당 id의 게시글이 존재하는지 먼저 확인
    private Board verifyingBoard(Long id){
        return
                boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: No Such post"));

    }



}
