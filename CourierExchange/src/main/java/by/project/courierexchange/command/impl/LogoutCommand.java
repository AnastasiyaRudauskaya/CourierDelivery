package by.project.courierexchange.command.impl;

import by.project.courierexchange.command.ActionCommand;
import by.project.courierexchange.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}