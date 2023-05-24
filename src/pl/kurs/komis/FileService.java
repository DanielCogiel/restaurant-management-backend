package pl.kurs.komis;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/file")
public class FileService {
   private static final String basePath = "c:/take/";
   @GET
   @Path("{filepath: .*}")
   @Produces("text/plain")
   public File getFile(@PathParam("filepath") String path) {
      return new File(basePath + path);
   }
}