package by.project.courierexchange.command;

import by.project.courierexchange.command.impl.LoginCommand;
import by.project.courierexchange.command.impl.LogoutCommand;
import by.project.courierexchange.command.impl.CourierRegisterCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTER{
        {
            this.command = new CourierRegisterCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}