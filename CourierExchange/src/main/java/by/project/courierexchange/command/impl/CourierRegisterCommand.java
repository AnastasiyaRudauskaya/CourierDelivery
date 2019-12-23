package by.project.courierexchange.command.impl;
import by.project.courierexchange.command.ActionCommand;
import by.project.courierexchange.entity.User;
import by.project.courierexchange.resource.ConfigurationManager;
import by.project.courierexchange.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class CourierRegisterCommand implements ActionCommand {
private final static String REDIRECT_PATH = "/final/index.jsp";
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(SessionRequestContent content) throws CommandException {
        String page = PageName.REGISTRATION;
        Map<String, String> userValue = new HashMap<>();
        userValue.put(EMAIL, XSSSecurity.secure(content.getRequestParameters().get(EMAIL)[0]));
        userValue.put(FIRST_NAME, XSSSecurity.secure(content.getRequestParameters().get(FIRST_NAME)[0]));
        userValue.put(LAST_NAME, XSSSecurity.secure(content.getRequestParameters().get(LAST_NAME)[0]));
        userValue.put(PASSWORD, XSSSecurity.secure(content.getRequestParameters().get(PASSWORD)[0]));
        userValue.put(CONFIRM_PASSWORD, XSSSecurity.secure(content.getRequestParameters().get(CONFIRM_PASSWORD)[0]));
        RoleType role = null;
        if (content.getRequestParameters().get(SELECT) != null) {
            userValue.put(ROLE, content.getRequestParameters().get(SELECT)[0]);
            role = RoleType.valueOf(userValue.get(ROLE).toUpperCase());
        }
        content.getRequestAttributes().put(USER_VALUE, userValue);
        ValidatorPersonalData validator = new ValidatorPersonalData();
        if (!validator.validateEmail(userValue.get(EMAIL))) {
            content.getRequestAttributes().put(ERROR_REGISTRATION_EMAIL, true);
            return page;
        }
        if (!validator.validateName(userValue.get(FIRST_NAME))) {
            content.getRequestAttributes().put(ERROR_REGISTRATION_FIRST_NAME, true);
            return page;
        }
        if (!validator.validateName(userValue.get(LAST_NAME))) {
            content.getRequestAttributes().put(ERROR_REGISTRATION_LAST_NAME, true);
            return page;
        }
        if (!userValue.get(PASSWORD).equals(userValue.get(CONFIRM_PASSWORD)) || !validator.validatePassword(userValue.get(PASSWORD))) {
            content.getRequestAttributes().put(ERROR_REGISTRATION_PASSWORD, true);
            return page;
        }
        if (content.getRequestParameters().get(SELECT) == null) {
            content.getRequestAttributes().put(ERROR_REGISTRATION_ROLE, true);
            return page;
        }
        try {
            UserServiceImpl userService = new UserServiceImpl();
            if (userService.checkByEmail(userValue.get(EMAIL))) {
                content.getRequestAttributes().put(ERROR_REGISTRATION_EMAIL, true);
                return page;
            }
            User user = new User();
            user.setEmail(userValue.get(EMAIL));
            user.setFirstName(userValue.get(FIRST_NAME));
            user.setLastName(userValue.get(LAST_NAME));
            String password = userService.codingPassword(userValue.get(PASSWORD));
            user.setRole(role);
            userService.insert(user, password);
        } catch (ServiceException e) {
            logger.error("execute ", e);
            throw new CommandException("execute ", e);
        }
        content.getRequestParameters().put(REDIRECT, new String[]{REDIRECT_PATH});
        return PageName.INDEX;
    }
}
