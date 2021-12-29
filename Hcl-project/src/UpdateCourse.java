

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
 * Servlet implementation class UpdateCourse
 */
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
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
		doGet(request, response);
		
		String courseID = request.getParameter("courseID");
		String grade = request.getParameter("grade");
		String courseName = request.getParameter("courseName");
		String months = request.getParameter("months");
		String lecture = request.getParameter("lecture");
		
		System.out.println(courseID + grade + courseName + months + lecture);
		
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			
			String sql = "update course_creation set courseName=?,lectureIC=?,grade=?,duration=? where Course_ID ='"+courseID+"'";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, courseName);
			pstm.setString(2, lecture);
			pstm.setString(3, grade);
			pstm.setString(4, months);
			
			int rowAffected = pstm.executeUpdate();
			System.out.println("Affected rows : " + rowAffected);
			
			pstm.close();
			statement.close();
			conn.close();
			
			request.getRequestDispatcher("/viewCourse.jsp").forward(request,response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}