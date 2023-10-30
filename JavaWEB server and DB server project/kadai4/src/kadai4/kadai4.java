package kadai4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class kadai4
 */
@WebServlet("/kadai4")
public class kadai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kadai4() {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType
		("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		ServletContext context = this.getServletContext();
		if( id==null || pass==null || pass.isEmpty() || id.isEmpty() ) {
			response.sendRedirect("./error.jsp");
			return;
		}
		if(request.getServletContext().getAttribute("bean")==null) {
			String path=request.getServletContext().getRealPath("WEB-INF/id_data.txt");
			request.getServletContext().setAttribute("bean", new FileBean(path)); }
			FileBean fb=
			(FileBean)request.getServletContext().getAttribute("bean");
			
		if(fb.loadData(id+","+pass)) {
			RequestDispatcher dispatcher
			= context.getRequestDispatcher("/Success.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else {
			RequestDispatcher dispatcher
			= context.getRequestDispatcher("/fail.jsp");
			dispatcher.forward(request, response);
			return;
		}

		
	}

}
