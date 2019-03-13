package com.shop.sport.command;

import javax.servlet.http.HttpServletRequest;

public class AllCommand extends AbstractCommand {
    private static final Command INSTANCE = new AllCommand();

    public AllCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        populateProducts(req);
        return "main.jsp";
    }
}
