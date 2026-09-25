package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PingService {

    public String ping(String name) {
        return "Hello " + name + ". Ping!";
    }
}
