package com.auth_application.shared.domain.bus.command;

public interface CommandHandler<T extends Command> {

    public void handle(T command);

}