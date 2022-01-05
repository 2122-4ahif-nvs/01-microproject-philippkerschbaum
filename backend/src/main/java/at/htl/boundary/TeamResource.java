package at.htl.boundary;

import at.htl.control.TeamRepository;
import at.htl.entity.Team;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/team")
public class TeamResource {

    @Inject
    TeamRepository teamRepository;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance team(Team team);
        public static native TemplateInstance teamSimple(String name);
    }

    @Path("/simpleQute")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getTxt(@QueryParam("name") String name){
        return Templates.teamSimple(name);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name")String name){
        return Templates.team(teamRepository.getTeamByName(name));
    }


    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> findAll(){
        return teamRepository.getAll();
    }
}
