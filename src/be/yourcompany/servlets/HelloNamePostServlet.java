package be.yourcompany.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloNamePostServlet
 */
@WebServlet("/servlet/HelloNamePostServlet")
public class HelloNamePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar date = new GregorianCalendar();
		String dateString = sdf.format(date.getTime());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		if (!((firstName == null) && (lastName == null))) {
			printNameParagraph(out, firstName, lastName);
		}
		out.println("<p>" + dateString + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	private void printNameParagraph(PrintWriter out, String firstName,
			String lastName) {
		out.print("<p>");
		if (firstName != null) {
			out.println(firstName);
		}
		if (lastName != null) {
			out.print(lastName);
		}
		out.println("</p>");
	}

}
