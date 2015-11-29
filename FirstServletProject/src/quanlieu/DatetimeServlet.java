package quanlieu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatetimeServlet
 */
@WebServlet(description = "Servlet that resturn datetime", urlPatterns = { "/DatetimeServlet" })
public class DatetimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatetimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Date date = new Date();
	    response.setContentType("application/json");
	    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	    PrintWriter pWriter = response.getWriter();
	    //response.getWriter().write("Servlet is running");
	    pWriter.write(date.toString());
	}

}
