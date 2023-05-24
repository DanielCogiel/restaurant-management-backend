package pl.kurs.kredyt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/test")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class Test {

	@Path("/test")
	@GET
	public String test2(@QueryParam("x") int x) {
		System.out.println("x="+x);
		//return 12.2;
		return "test2="+x;
	}

}
