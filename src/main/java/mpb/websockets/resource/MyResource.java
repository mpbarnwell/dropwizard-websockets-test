package mpb.websockets.resource;

import mpb.websockets.service.MyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class MyResource {

    @Inject
    private MyService myService;

    @GET
    public String test() {
        return String.valueOf(myService.hashCode());
    }

}
