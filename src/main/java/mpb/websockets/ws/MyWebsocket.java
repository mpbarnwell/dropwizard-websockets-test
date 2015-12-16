package mpb.websockets.ws;

import mpb.websockets.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class MyWebsocket {

    private static final Logger LOG = LoggerFactory.getLogger(MyWebsocket.class);

    @Inject
    private MyService myService;

    @OnOpen
    public void onOpen(Session session) {
        LOG.info("New WS connection. MyService hashcode: {}", myService.hashCode());
        session.getAsyncRemote().sendText(String.valueOf(myService.hashCode()));
    }

}
