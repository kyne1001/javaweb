package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.DataReader;
import domain.User;

@Path("v1/")
public class Basic {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle() {
        return "<p>Java Web Service</p>";
    }
    
    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnVersion() {
        return "<p>Version 0.1.0</p>";
    }
    
    @Path("/users")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnUsers() throws Exception {
        List<User> users = DataReader.getUsers();
        String result = "";
        for (User user: users) {
           result += "<p>" + user.getId() + ", " + user.getName() + ".</p>";
        }
        return result;
    }
    
    @Path("/students")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnStudentsInJSONString() throws Exception {
        return DataReader.getDataInJSON("students").toString();
    }
}
