package lesson.j2ee.ex2;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		String name = req.getParameter("name");
		String checked = req.getParameter("store");
		String pw = req.getParameter("password");
		boolean judge = true;
		Cookie cookies[] = req.getCookies();
	    if (cookies != null)
	    {

	    	for (int i = 0; i < cookies.length; i++)
	        {
	            switch (cookies[i].getName())
                {
                    case "name":
                        cookies[i].setValue(name);
                        judge = false;
                        break;
                    case "pw":
                        cookies[i].setValue(pw);
                        judge = false;
                        break;
                    case "store":
                        cookies[i].setValue(checked);
                        judge = false;
                        break;
                }

	        }

	    }
	    
	    if(judge)
	    {
	    	if ("checked".equals(checked))
            {
                Cookie cks[] = new Cookie[3];
                cks[0] = new Cookie("name", name);
                cks[1] = new Cookie("pw", pw);
                cks[2] = new Cookie("store",checked);
                //不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
                for (Cookie cookie :
                        cks)
                {
                    cookie.setMaxAge(24 * 60 * 60);
                    res.addCookie(cookie);
                }
                cookies = cks;
            }
	    }
	    
	    PrintWriter out=res.getWriter();
		res.setContentType("text/html");

		out.println("<html>");
		out.println("<title>");
		out.println("User list");
		out.println("</title>");
		out.println("<body><h4>User List:</h4><hr><br><br>");
	    if (cookies != null)
	    {
	        for (int i = 0; i < cookies.length; i++)
	        {
	            if (cookies[i].getName().equals("name"))
	            {
	            	out.print(cookies[i].getValue());
	            }
	        }
	    }
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}