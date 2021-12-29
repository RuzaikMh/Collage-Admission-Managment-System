

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
 * Servlet implementation class UpdateFee
 */
public class UpdateFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFee() {
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
		String paymentId = request.getParameter("paymentId");
		String paymentAmount = request.getParameter("paymentAmount");
		String studentName = request.getParameter("studentName");
		String purposeOfPayment = request.getParameter("purposeOfPayment");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			Statement statement = conn.createStatement();
			
			String sql = "update student_fees set Registration_Number=?, name=?,phone_number=?,payment_amount=?,purpose_of_payment=?,email=? where Payment_Id ='"+paymentId+"'";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, registrationNumber);
			pstm.setString(2, studentName);
			pstm.setString(3, phoneNumber);
			pstm.setString(4, paymentAmount);
			pstm.setString(5, purposeOfPayment);
			pstm.setString(6, email);
			
			int rowAffected = pstm.executeUpdate();
			System.out.println("Affected rows : " + rowAffected);
			
			pstm.close();
			statement.close();
			conn.close();
			
			request.getRequestDispatcher("/viewFees.jsp").forward(request,response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
