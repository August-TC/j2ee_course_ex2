package lesson.j2ee.ex2;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class BookAddedListener
 *
 */
public class BookAddedListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public BookAddedListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
    	HttpSession session = event.getSession();
    	Integer itemCount=(Integer)session.getAttribute("itemCount");
    	
    	if (itemCount==null)
			itemCount=new Integer(0);
    	itemCount++;
    	String order = "item"+itemCount;
    	String name = (String) session.getAttribute(order);
    	
    	System.out.println(order+": "+name+" || ItemCount: "+itemCount);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
