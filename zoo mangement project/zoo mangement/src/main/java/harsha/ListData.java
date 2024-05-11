package harsha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListData
 */
public class ListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<html><head><title>List of Tickets</title></head><body>");
        out.println("<h2>List of Tickets</h2>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM zoo");
            ResultSet rs = ps.executeQuery();
            
            // Display ticket data in a table
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Age</th><th>Phone</th><th>Day</th><th>slot</th><th>fee</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("age") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("day") + "</td>");
                out.println("<td>" + rs.getString("slot") + "</td>");
                out.println("<td>" + rs.getString("fee") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        out.println("</body></html>");
    }
}
	
