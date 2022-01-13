package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RaceDTO;
import dtos.RacesDTO;
import entities.Race;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.PathParam;

import facades.IRaceFacade;
import facades.RaceFacade;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class RenameMeResource {


    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private final RaceFacade raceFacade = RaceFacade.getRaceFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login() {
        return "{\"msg\": \"this is our login page: " + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public List<User> GetInfoFromUser() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <User> query = em.createQuery("SELECT u from User u where u.userName=:username", entities.User.class);
        List<User> result = query.getResultList();
        return result;
    }



    // Endpoints For Race

    /* Tried adding GET, POST and PUT for race using DTOs, this doesn't work and breaks the other endpoints.

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("race")
//    //Outcommented while working
//    @RolesAllowed("user")
    public String getAllRaces(){
        RacesDTO races = new RacesDTO(raceFacade.getAllRaces());
        return gson.toJson(races.getAll());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addRace")
//    //Outcommented while working
//    @RolesAllowed("admin")
    public Response addRace(String race) throws Exception{
        RaceDTO r = gson.fromJson(race, RaceDTO.class);
        r = raceFacade.addRace(r.getId(), r.getName(), r.getDate(), r.getTime(), r.getLocation());
        return Response.ok(gson.toJson(r),MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("editRace")
    public Response editRace (int id, String race) throws Exception{
        RaceDTO r = gson.fromJson(race, RaceDTO.class);
        r.setId(id);
        r = raceFacade.editRace(r);
        return Response.ok(gson.toJson(r), MediaType.APPLICATION_JSON).build();
    }

    */

    // This fetches from the database without using DTOs. It's working, but isn't the right way to do things.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("race")
    //Outcommented while working
    //@RolesAllowed("user")
    public List<Race> ShowAllRaces() throws SQLException {
        EntityManager em = EMF.createEntityManager();
        TypedQuery <Race> query = em.createQuery("SELECT r FROM Race r", Race.class);
        List<Race> result = query.getResultList();
        return result;
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("addrace")
//    public void addRace(){
//        RaceDTO rDTO = gson.fromJson(rDTO, RaceDTO.class);
//        raceFacade.createRace(rDTO);
//    }

}