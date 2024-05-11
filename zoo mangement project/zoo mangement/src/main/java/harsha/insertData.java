package harsha;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertData
 */
public class insertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
		//PrintWriter out = response.getWriter(); 
		String id=request.getParameter("id");
		String name = request.getParameter("name");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String day = request.getParameter("day");
        String slot = request.getParameter("slot");
        String fee = request.getParameter("fee");
         
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root"); 
            PreparedStatement st = con.prepareStatement("INSERT INTO zoo (id,name, age, phone, day, slot, fee) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, age);
            st.setString(4, phone);
            st.setString(5, day);
            st.setString(6, slot);
            st.setString(7, fee);
           
            
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Ticket Generated</title><style>");
                out.println("body { font-family: Arial, sans-serif; }");
                out.println("h2 { color: #333; }");
                out.println("p { margin: 5px 0; }");
                out.println("</style></head><body>");
                out.println("<h2>Successfully Generated the Ticket</h2>");

                // Display ticket details
                out.println("<div style='background-color: #f9f9f9; border: 1px solid #ccc; padding: 10px;'>");
                out.println("<h2>Ticket Details:</h2>");
                out.println("<p><strong>ID:</strong> " + id + "</p>");
                out.println("<p><strong>Name:</strong> " + name + "</p>");
                out.println("<p><strong>Age:</strong> " + age + "</p>");
                out.println("<p><strong>Phone Number:</strong> " + phone + "</p>");
                out.println("<p><strong>Day:</strong> " + day + "</p>");
                out.println("<p><strong>slot</strong> " + slot + "</p>");
                out.println("<p><strong>fee</strong> " + fee + "</p>");
                out.println("</div></body></html>");
            }

            
            st.close();
            con.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
