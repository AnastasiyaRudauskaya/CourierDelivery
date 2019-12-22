package by.project.courierexchange.command.impl;

import by.project.courierexchange.command.ActionCommand;
import by.project.courierexchange.logic.LoginLogic;
import by.project.courierexchange.resource.ConfigurationManager;
import by.project.courierexchange.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
// проверка логина и пароля
        if (LoginLogic.checkLogin(login, pass)) {
            request.setAttribute("user", login);
// определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
