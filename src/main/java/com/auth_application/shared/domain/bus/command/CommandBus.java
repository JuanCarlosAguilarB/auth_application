package com.auth_application.shared.domain.bus.command;

public interface CommandBus {

    public void send(Command command);

}
