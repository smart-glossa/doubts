package gender;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/genServlet")
public class genServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("add")) {
			String gender = request.getParameter("gender");
			JSONObject jj = new JSONObject();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajith", "root",
						"root");
				Statement stat = connection.createStatement();
				String query = "insert into gender(gender)values('" + gender + "')";
				stat.execute(query);
				jj.put("status", 1);

			} catch (Exception e) {
				// TODO: handle exception
				jj.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(jj);
		}
	}

}
