package be.yourcompany.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SpyServlet
 */
@WebServlet("/servlet/SpyServlet")
public class SpyServlet extends HttpServlet {
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
		Map<String, String[]> paramMap = request.getParameterMap();
		String[] values = null;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Parameter names in this request</h1");

		out.println("<ul>");
		for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
			out.print("<li>");
			out.print(entry.getKey());
			out.print(" = ");
			values = entry.getValue();
			for (int i = 0; i < values.length; i++) {
				out.print(values[i]);
				if ((values.length > 1) && (i < values.length - 1)) {
					out.print(", ");
				}
			}
			out.println("</li>");
		}
		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");
	}

}
