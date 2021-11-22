package at.htl.boundary;

import at.htl.control.ClubRepository;
import at.htl.entity.Club;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ClubResource {

    @Inject
    ClubRepository clubRepository;

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveClub(Club club){
        clubRepository.save(club);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Club> getClubs(){
        return clubRepository.findAll();
    }

    @GET
    @Path("")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getClubPerJsonb(
            @QueryParam("n") @DefaultValue("") String club_name
    ){
        return Response.ok(new Club(club_name)).build();
    }
}
