package kadai7;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset= utf-8");
		newRecord(request,response);
		}
		public void newRecord(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
			boolean result;
	    String[] userInfo= new String[9];
		userInfo[0] = request.getParameter("ID");
		userInfo[1] = request.getParameter("email");
		userInfo[2] = request.getParameter("password");
		userInfo[3] = request.getParameter("name");
		userInfo[4] = request.getParameter("name_kana");
		userInfo[5] = request.getParameter("name");
		userInfo[6] = request.getParameter("prefecture");
		userInfo[7] = request.getParameter("city");
		userInfo[8] = request.getParameter("address");
		
		for (int i=0; i<userInfo.length; i++) 
		{ 
		    if(userInfo[i].isEmpty() || userInfo[i].isEmpty()){
		    	request.getRequestDispatcher("/RegisterFail.jsp").forward(request, response);
		    	return;
		    }
		}
		
		result = new userDataBean().AddRecord(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4]
				,userInfo[5],	userInfo[6],userInfo[7],userInfo[8]);
		if(result)
			request.getRequestDispatcher("/RegisterSuccess.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/RegisterFail.jsp").forward(request, response);
		}
		
	}


