package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class UserCounter implements HttpSessionListener {
    private static final AtomicInteger activeSessions = new AtomicInteger();

    public static int getActiveSessions() {
        return activeSessions.get();
    }

    @Override
    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
        //System.out.println("-- HttpSessionListener#sessionCreated invoked --");
        //HttpSession session = event.getSession();
        //System.out.println("session id: " + session.getId());
    }
    @Override
    public void sessionDestroyed(final HttpSessionEvent event) {
        activeSessions.decrementAndGet();
    }
}
