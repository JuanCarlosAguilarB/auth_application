package com.auth_application.auth.domain;

public interface SecurityService {

    public String encode(String textToEncode);

    public Boolean matches(String textToEncode, String encodedText);

}
