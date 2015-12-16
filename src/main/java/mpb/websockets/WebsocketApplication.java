package mpb.websockets;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.websockets.WebsocketBundle;
import mpb.websockets.resource.MyResource;
import mpb.websockets.service.MyService;
import mpb.websockets.ws.MyWebsocket;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.websocket.server.ServerEndpoint;


public class WebsocketApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new WebsocketApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new WebsocketBundle(MyWebsocket.class));
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        final MyService myService = new MyService();
        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(myService).to(MyService.class);
            }
        });
        environment.jersey().register(MyResource.class);
    }

}
