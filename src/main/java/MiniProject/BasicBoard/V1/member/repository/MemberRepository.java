package MiniProject.BasicBoard.V1.member.repository;

import MiniProject.BasicBoard.V1.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
