package MiniProject.BasicBoard.V1.member.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    private static final String SESSION_COOKIE_NAME = "sessionId";
    private Map<String, Object> sessionStorage = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response){
        String sessionId = UUID.randomUUID().toString() ;
        sessionStorage.put(sessionId,value);

        Cookie mySessionCookie= new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);
    }
}
