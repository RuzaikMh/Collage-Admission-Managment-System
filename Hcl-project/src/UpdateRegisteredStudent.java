

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateRegisteredStudent
 */
public class UpdateRegisteredStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRegisteredStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		PrintWriter writer = response.getWriter();
		
		String studentName = request.getParameter("studentName");
		String registrationNumber = request.getParameter("registrationNumber");
		String course = request.getParameter("course");
		String nic = request.getParameter("nic");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String date = request.getParameter("date");
		String province = request.getParameter("province");
		String district = request.getParameter("district");
		
		System.out.println(studentName + registrationNumber + course + nic + phoneNumber + email + address + date + province + district);
		
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			
			String query = "update student_registration set name=?,course=?,nic=?,phone_number=?,email=?,postal_address=?,joined_date=?,province=?,district=? where Registration_Number ='"+registrationNumber+"'";
			
			PreparedStatement pstatement = conn.prepareStatement(query);
			pstatement.setString(1, studentName);
			pstatement.setString(2, course);
			pstatement.setString(3, nic);
			pstatement.setString(4, phoneNumber);
			pstatement.setString(5, email);
			pstatement.setString(6, address);
			pstatement.setString(7, date);
			pstatement.setString(8, province);
			pstatement.setString(9, district);
			
			int Results = pstatement.executeUpdate();
			System.out.println("Updated rows : " + Results);
			
			pstatement.close();
			conn.close();
			
			request.getRequestDispatcher("/viewRegisteredStudents.jsp").forward(request,response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
