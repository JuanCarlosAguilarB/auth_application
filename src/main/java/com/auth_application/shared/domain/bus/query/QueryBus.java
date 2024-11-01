package com.auth_application.shared.domain.bus.query;

public interface QueryBus {

    public <T extends Response> T ask(Query query);

}
