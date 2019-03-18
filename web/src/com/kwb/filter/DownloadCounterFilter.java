package com.kwb.filter;

import com.sun.deploy.security.ruleset.RuleId;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadCounterFilter implements Filter {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Properties downloadLog = null;
    private File logFile = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filePath = filterConfig.getServletContext().getRealPath("/");
        logFile = new File(filePath, "downloadLog.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String uri = request.getRequestURI();
        executorService.execute(() ->{
            String value = downloadLog.getProperty(uri);
            if (null == value) {
                downloadLog.setProperty(uri, "1");
            } else {
                int count = Integer.parseInt(value);
                downloadLog.setProperty(uri, String.valueOf(count++));
            }

            try {
                downloadLog.store(new FileWriter(logFile),"");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                filterChain.doFilter(servletRequest,servletResponse);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
