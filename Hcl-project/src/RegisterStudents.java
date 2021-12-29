

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterStudents
 */
public class RegisterStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudents() {
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
		
		try {
			Connection conn = DBConnection.getConnection();
			
			Statement statement = conn.createStatement();
			
			String sql = "Insert into student_registration(Registration_Number,name,course,nic,phone_number,email,postal_address,joined_date,province,district) values(?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, registrationNumber);
			pstm.setString(2, studentName);
			pstm.setString(3, course);
			pstm.setString(4, nic);
			pstm.setString(5, phoneNumber);
			pstm.setString(6, email);
			pstm.setString(7, address);
			pstm.setString(8, date);
			pstm.setString(9, province);
			pstm.setString(10, district);
			
			int rowAffected = pstm.executeUpdate();
			System.out.println("Affected rows : " + rowAffected);
			
			pstm.close();
			statement.close();
			conn.close();
			
			request.getRequestDispatcher("/dash.jsp").forward(request,response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
