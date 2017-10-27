package pro.christianmtr.tesis.ws.services;

import com.google.gson.Gson;
import pro.christianmtr.tesis.ws.models.DAOCrimesChicago;
import pro.christianmtr.tesis.ws.models.EntityCrimesChicago;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("crimes_chicago")
@Produces(MediaType.APPLICATION_JSON)
public class CrimesChicago {
    @GET
    @Path("/all")
    public String crimesChicago() {
        DAOCrimesChicago controller = new DAOCrimesChicago();
        List<EntityCrimesChicago> crimes = controller.getAllCrimesChicago();

        Gson encoder = new Gson();
        return encoder.toJson(crimes);
    }

    @GET
    @Path("/some_crimes/{limit}")
    public String crimesChicago(@PathParam("limit") int limit) {
        DAOCrimesChicago controller = new DAOCrimesChicago();
        List<EntityCrimesChicago> crimes = controller.getSomeCrimesChicago(limit);

        Gson encoder = new Gson();
        return encoder.toJson(crimes);
    }

    @GET
    @Path("/one_crime/{id}")
    public String crimesChicago(@PathParam("id") String id) {
        DAOCrimesChicago controller = new DAOCrimesChicago();
        EntityCrimesChicago one_crime = controller.getOneCrimeChicago(id);

        Gson encoder = new Gson();
        return encoder.toJson(one_crime);
    }


}
