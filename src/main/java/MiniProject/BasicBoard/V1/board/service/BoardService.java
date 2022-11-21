package MiniProject.BasicBoard.V1.board.service;

import MiniProject.BasicBoard.V1.board.controller.BoardController;
import MiniProject.BasicBoard.V1.board.dto.BoardPatchDto;
import MiniProject.BasicBoard.V1.board.dto.BoardPostDto;
import MiniProject.BasicBoard.V1.board.dto.BoardResponseDtoForOne;
import MiniProject.BasicBoard.V1.board.entity.Board;
import MiniProject.BasicBoard.V1.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardPostDto postDto){

        return boardRepository.save(postDto.dtoToBoardEntity()).getId();
    }

    @Transactional
    public Long patchPost(BoardPatchDto patchDto, Long id){

        //ID 가져오기
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such post"));
        //ID로 Board Entity내용읠 Builder로 수정
        board.update(patchDto.getTitle(), patchDto.getBody());
        return id;
    }

    @Transactional(readOnly = true)
    public BoardResponseDtoForOne getOnePost(Long id){

        Board targetBoard = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No such post"));
        return new BoardResponseDtoForOne(targetBoard);
    }

}
