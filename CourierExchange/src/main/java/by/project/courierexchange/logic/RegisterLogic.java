package by.project.courierexchange.logic;

import by.project.courierexchange.entity.User;

public class RegisterLogic {
    public static User getPersonsData(String enterLogin, String enterPass){
        return new User(enterLogin,enterPass);// FIXME: 28.10.2019
    }
}
