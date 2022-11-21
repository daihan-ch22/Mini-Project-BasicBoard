package MiniProject.BasicBoard.V1.board.repository;

import MiniProject.BasicBoard.V1.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT p from Board p ORDER BY p.id DESC")
    List<Board> findAllPostByOrder();

}
