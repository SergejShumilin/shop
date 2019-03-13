package com.shop.sport.command;

import javax.servlet.http.HttpServletRequest;

public class DeleteCommand extends AbstractCommand{
    private static final Command INSTANCE = new DeleteCommand();

    public DeleteCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        long id = Long.valueOf(req.getParameter("id"));
        dao.delete(id);

        populateProducts(req);

        return "main.jsp";
    }
}
