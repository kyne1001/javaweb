package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import dao.DataReader;
import domain.User;

@Path("/v1")
public class Basic {
    
    //GET method without child path example, type /v1 in the URI
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle() {
        return "<p>Java Web Service</p>";
    }
    
    //GET method with child path examplet, type /v1/version in the URI
    @Path("/version")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnVersion() {
        return "<p>Version 0.1.0</p>";
    }
    
    //Read data to object example
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
    
    //Read data to json example
    @Path("/students")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnStudentsInJSONString() throws Exception {
        Response response = Response.ok(DataReader.getDataInJSONArray("students")).build();
        return response;
    }
    
    //QueryParam example: /v1/students-query-param?name="a name"
    //Ex: api/v1/students-query-param?name=para
    @Path("/students-query-param")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsInJSONStringByQueryParam(@QueryParam("name") String name) throws Exception {
        if (name == null) {
            String error = "Please specify a name";
            return Response.status(400).entity(error).build();
        }

        String sql = "select * from students where name = ?";
        String[] parameters = new String[] {name};
        JSONArray jsonArray = DataReader.getDataInJSONArray(sql, parameters);
        Response response = Response.ok(jsonArray).build();
        return response;
    }
    
    //PathParam example: /v1/students-path-param/"a name"
    //Ex: api/v1/students-path-param/para
    @Path("/students-path-param/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsInJSONStringByPathParam(@PathParam("name") String name) throws Exception {
        if (name == null) {
            String error = "Please specify a name";
            return Response.status(400).entity(error).build();
        }

        String sql = "select * from students where name = ?";
        String[] parameters = new String[] {name};
        JSONArray jsonArray = DataReader.getDataInJSONArray(sql, parameters);
        Response response = Response.ok(jsonArray).build();
        return response;
    }
    
    //Two PathParam example: /v1/class/"a class id"/"a name"
    //Ex: api/v1/class/7/mary
    @Path("/class/{classId}/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsInClassByPathParam(
            @PathParam("classId") int classId, @PathParam("name") String name) throws Exception {
        if (name == null) {
            String error = "Please specify a name";
            return Response.status(400).entity(error).build();
        }

        //Note: classId is integer, this isn't a good practice to cast it into string
        //      the result is correct in this case but would wrong in other cases like "classId > ?".
        String sql = "select * from students where classId = ? and name = ?";
        String[] parameters = new String[] { String.valueOf(classId), name };
        JSONArray jsonArray = DataReader.getDataInJSONArray(sql, parameters);
        Response response = Response.ok(jsonArray).build();
        return response;
    }
}
