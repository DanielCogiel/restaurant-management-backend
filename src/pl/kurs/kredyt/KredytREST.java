package pl.kurs.kredyt;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



@Path("/kredyt")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class KredytREST implements Kredyt {
	
	@EJB
	KredytEJB kredyt;
	
	@Override
	@GET
    @Path("/{kwota}")
	public double getRata(@PathParam("kwota") double kwota) {
		kredyt.setKwota(kwota);
		return kredyt.getRata();
	}
	
	
}
