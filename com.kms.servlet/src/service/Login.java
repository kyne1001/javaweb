package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import dao.DataReader;

/**
 * Servlet implementation class Login
 */
@WebServlet(description = "Login servlet", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //http://www.journaldev.com/1973/servlet-exception-and-error-handling-example-tutorial
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    JSONObject jsonObject = null;
	    String sql = "select count(*) as 'exists' from users where name = ? and password = ?";
	    try {
	        JSONArray jsonArray = DataReader.getDataInJSONArray(sql, new String[] {name, password});
//            PrintWriter printWriter = response.getWriter();
//            printWriter.write(jsonArray.toString());
            jsonObject = jsonArray.getJSONObject(0);
            int ok = jsonObject.getInt("exists");
            PrintWriter printWriter = response.getWriter();
            if (ok == 1) {
                Cookie cookie = new Cookie("user", name);
                response.addCookie(cookie);
                printWriter.write("Login successful");
            } else {
                response.setStatus(400);
                printWriter.write("Login failed");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}
