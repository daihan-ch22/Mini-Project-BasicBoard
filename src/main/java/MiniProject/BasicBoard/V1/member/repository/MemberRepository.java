package MiniProject.BasicBoard.V1.member.repository;

import MiniProject.BasicBoard.V1.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(x -> x.getId().equals(loginId))
                .findFirst();
    }
}
