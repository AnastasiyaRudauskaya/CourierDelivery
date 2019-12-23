package by.project.courierexchange.command.impl;

import by.project.courierexchange.command.ActionCommand;
import by.project.courierexchange.logic.LoginLogic;
import by.project.courierexchange.resource.ConfigurationManager;
import by.project.courierexchange.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(SessionRequestContent content) throws CommandException {
        try {
            UserServiceImpl userService = new UserServiceImpl();
            String email = content.getRequestParameters().get(EMAIL)[0];
            if (!userService.checkByEmail(email)) {
                content.getRequestAttributes().put(ERROR, true);
                return PageName.LOGIN;
            }
            List<User> userList = userService.findByEmail(email);
            String password = userService.codingPassword(content.getRequestParameters().get(PASSWORD)[0]);
            String truePassword = userService.findPasswordById(userList.get(0).getId());
            if (!truePassword.equals(password)) {
                content.getRequestAttributes().put(ERROR, true);
                return PageName.LOGIN;
            }
            content.getSessionAttributes().put(USER, userList.get(0));
            content.getRequestAttributes().put(CABINET, ACTIVE);
            switch (userList.get(0).getRole()) {
                case ADMIN:
                    return PageName.ADMIN;
                case COURIER:
                    double rating = new RatingCourierServiceImpl().findByCourierId(userList.get(0).getId());
                    content.getSessionAttributes().put(RATING, rating);
                    return PageName.COURIER;
                case CLIENT:
                    return PageName.CLIENT;
                default:
                    return PageName.LOGIN;
            }
        } catch (ServiceException e) {
            logger.error("execute", e);
            throw new CommandException("execute", e);
        }
    }
}
