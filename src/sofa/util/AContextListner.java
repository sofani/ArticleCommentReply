package sofa.util;


import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class AContextListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();      
		 
        // initialize the customer service email address that's used throughout the web site
       /* String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);*/

        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);
        
        // initialize the array of years that's used for the credit card year
      /*  ArrayList<String> creditCardYears = new ArrayList<String>();
        for (int i = 0; i < 8; i++)
        {
            int year = currentYear + i; 
            String yearString = Integer.toString(year);
            creditCardYears.add(yearString);
        }
        sc.setAttribute("creditCardYears", creditCardYears);*/
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
