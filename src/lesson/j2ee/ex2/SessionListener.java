package lesson.j2ee.ex2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event) {
        // TODO Auto-generated method stub
    	Date date = new Date();
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	System.out.println("New Session ("+format.format(date)+")");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event) {
        // TODO Auto-generated method stub
    	Date date = new Date();
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	System.out.println("Destroyed Session ("+format.format(date)+")");
    }
	
}
