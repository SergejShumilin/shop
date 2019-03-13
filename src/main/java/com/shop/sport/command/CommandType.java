package com.shop.sport.command;

import java.util.Arrays;

public enum CommandType {
    CREATE(CreateCommand.getINSTANCE()),
    DELETE(DeleteCommand.getINSTANCE()),
    TO_EDIT(ToEditCommand.getINSTANCE()),
    EDIT(EditCommand.getINSTANCE()),
    ALL(AllCommand.getINSTANCE());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public static Command findCommand(String name){
        return Arrays.stream(CommandType.values())
                .filter(type -> type.name().toLowerCase().equals(name))
                .map(type -> type.command)
                .findAny()
                .orElse(getDefault());
    }

    public static Command getDefault(){
        return ALL.command;
    }
}
