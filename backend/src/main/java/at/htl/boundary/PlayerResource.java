package at.htl.boundary;

import at.htl.control.PlayerRepository;
import at.htl.entity.Club;
import at.htl.entity.Player;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/player")
public class PlayerResource {

    @Inject
    PlayerRepository playerRepository;

    @RolesAllowed("admin")
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveClub(Player player){
        playerRepository.save(player);
    }

    @RolesAllowed("user")
    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getClubs(){
        return playerRepository.getAllPlayers();
    }

    @RolesAllowed("dev")
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(Player player){
        playerRepository.delete(player);
    }
}
