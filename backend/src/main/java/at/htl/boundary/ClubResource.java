package at.htl.boundary;

import at.htl.control.ClubRepository;
import at.htl.entity.Club;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/club")
public class ClubResource {

    @Inject
    ClubRepository clubRepository;

    @Inject
    Validator validator;

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

    @Path("/manual-validation")
    @POST
    public Result tryMeManualValidation(Club club) {
        Set<ConstraintViolation<Club>> violations = validator.validate(club);
        if (violations.isEmpty()) {
            return new Result("Club is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result tryMeEndPointMethodValidation(@Valid Club club) {
        return new Result("Club is valid! It was validated by end point method validation.");
    }

    @Path("/service-method-validation")
    @POST
    public Result tryMeServiceMethodValidation(Club club) {
        try {
            clubRepository.validateClub(club);
            return new Result("Club is valid! It was validated by service method validation.");
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }


    public static class Result {

        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }

    }
}
