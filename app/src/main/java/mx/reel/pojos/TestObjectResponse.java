package mx.reel.pojos;

public class TestObjectResponse {
    String message;
    String[] words;
    TestUser user;
}

class TestUser {
    String name;
    String birthdate;
    int properties;
    Rol[] roles;
}

class Rol {
    String name;
}
