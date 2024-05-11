package harsha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispData
 */
public class DispData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispData() {
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
		 try {
			 String id=request.getParameter("id");
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	            PreparedStatement ps = con.prepareStatement("select * from zoo where id=?");
	            ps.setString(1,id);
	            out.print("<table style='width: 80%; border-collapse: collapse; margin: 20px auto;' border='1'>");
	            out.print("<caption style='font-weight: bold; font-size: 1.2em;'>Contact Information:</caption>");
	            ResultSet rs = ps.executeQuery();
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int total = rsmd.getColumnCount();
	            out.print("<tr>");
	            for (int i = 1; i <= total; i++) {
	                out.print("<th style='padding: 8px; text-align: center;'>" + rsmd.getColumnName(i) + "</th>");
	            }
	            out.print("</tr>");
	            while (rs.next()) {
	                out.print("<tr>");
	                for (int i = 1; i <= total; i++) {
	                    out.print("<td style='padding: 8px;'>" + rs.getString(i) + "</td>");
	                }
	                out.print("</tr>");
	            }
	            out.print("</table>");
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        } finally {
	            out.close();
} 
	}
}