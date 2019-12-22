package by.project.courierexchange.command.impl;
import by.project.courierexchange.command.ActionCommand;
import by.project.courierexchange.entity.User;
import by.project.courierexchange.resource.ConfigurationManager;
import by.project.courierexchange.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class CourierRegisterCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";



    @Override
    public String execute(HttpServletRequest request) {// FIXME: 28.10.2019 проверить на существующий?
        String page = null;
// извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
// нужно проверить логин на дубликат!!! если нет то
        User user = new User(login,pass);
// определение пути к main.jsp
            page = ConfigurationManager.getProperty("path.page.main");
/*        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }*/
        return page;
    }
}
