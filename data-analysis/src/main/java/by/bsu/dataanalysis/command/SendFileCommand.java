package by.bsu.dataanalysis.command;

import by.bsu.dataanalysis.content.NavigationType;
import by.bsu.dataanalysis.content.RequestContent;
import by.bsu.dataanalysis.content.RequestResult;

public class SendFileCommand implements Command {
    @Override
    public RequestResult execute(RequestContent requestContent) {
        requestContent.setSessionAttributes("message", "hJHj");
        return new RequestResult("/index.jsp", NavigationType.FORWARD);
    }
}
