package MiniProject.BasicBoard.V1.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRoleType {

    GUEST("ROLE_GUEST", "방문자"),
    USER("ROLE_USER", "일반 사용자"),
    SLEEP("ROLE_SLEEP", "휴면 사용자"); //계정 삭제시 바로 삭제 X

    private final String key;
    private final String title;

}
