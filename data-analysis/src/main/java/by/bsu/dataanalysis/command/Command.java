package by.bsu.dataanalysis.command;


import by.bsu.dataanalysis.content.RequestContent;
import by.bsu.dataanalysis.content.RequestResult;
import by.bsu.dataanalysis.exception.ServiceException;

public interface Command {
    RequestResult execute(RequestContent requestContent) throws ServiceException;
}
