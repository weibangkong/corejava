package com.kwb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaxCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        int count = (int) sc.getAttribute("onLineCount");
        count++;
        sc.setAttribute("onLineCount", count);
        int maxCount = (int) sc.getAttribute("maxOnLineCount");
        if (count > maxCount) {
            sc.setAttribute("maxOnLineCount", count);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sc.setAttribute("date",df.format(new Date()));
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        int count = (int) sc.getAttribute("onLineCount");
        count--;
        sc.setAttribute("onLineCount",count);

    }
}
