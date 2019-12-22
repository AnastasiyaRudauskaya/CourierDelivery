package by.project.courierexchange.command;

import by.project.courierexchange.logic.LoginLogic;
import by.project.courierexchange.resource.ConfigurationManager;
import by.project.courierexchange.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
