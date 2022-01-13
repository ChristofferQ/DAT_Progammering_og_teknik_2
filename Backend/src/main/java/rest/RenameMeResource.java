package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RaceDTO;
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

import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class RenameMeResource {


    Gson gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

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



    // For Race

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response

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
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("createRace")
//    public String createRace(String race){
//        RaceDTO r = gson.fromJson(race, RaceDTO.class);
//        Race rAdded = Facade.createRace
//    }





}