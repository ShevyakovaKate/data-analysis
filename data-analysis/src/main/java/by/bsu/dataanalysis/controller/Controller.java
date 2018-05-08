package by.bsu.dataanalysis.controller;

import by.bsu.dataanalysis.command.Command;
import by.bsu.dataanalysis.command.factory.FactoryCommand;
import by.bsu.dataanalysis.content.HttpRequestHelper;
import by.bsu.dataanalysis.content.NavigationType;
import by.bsu.dataanalysis.content.RequestContent;
import by.bsu.dataanalysis.content.RequestResult;
import by.bsu.dataanalysis.exception.ServiceException;/*
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;*/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        RequestContent requestContent = new RequestContent();
        HttpRequestHelper httpRequestHelper = new HttpRequestHelper(requestContent);
        httpRequestHelper.getDataFromHttpRequest(request);

        FactoryCommand factoryCommand = new FactoryCommand();
        String commandName = requestContent.getCommandName();
        Command command = factoryCommand.createCommand(commandName);

        RequestResult requestResult;
        String page;
        NavigationType navigationType;

        try {
            requestResult  = command.execute(requestContent);
            page = requestResult.getPage();
            navigationType = requestResult.getNavigationType();
        } catch (ServiceException e) {
            throw new ServletException("Problem when process request: ", e);
        }

        httpRequestHelper.addDataToHttpRequest(request);

        forwardOrRedirect(request, response, page, navigationType);
    }

    private void forwardOrRedirect(HttpServletRequest request, HttpServletResponse response,
                                   String page, NavigationType navigationType) throws ServletException, IOException {
        //**here will be logic of forward or redirect*//*
        response.sendRedirect(page);

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}