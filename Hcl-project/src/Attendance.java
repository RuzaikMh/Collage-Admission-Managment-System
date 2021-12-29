

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Attendance
 */
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
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
		
		String registrationNumber = request.getParameter("registrationNumber");
		String studentName = request.getParameter("studentName");
		String date = request.getParameter("date");
		String attendance = request.getParameter("attendance");
		
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			
			String sql = "Insert into student_attendence(Registration_Number,name,attendance,dates) values(?,?,?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, registrationNumber);
			pstm.setString(2, studentName);
			pstm.setString(3, attendance);
			pstm.setString(4, date);
			
			int rowAffected = pstm.executeUpdate();
			System.out.println("Affected rows : " + rowAffected);
			
			pstm.close();
			statement.close();
			conn.close();
			
			request.getRequestDispatcher("/attendance.jsp").forward(request,response);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
