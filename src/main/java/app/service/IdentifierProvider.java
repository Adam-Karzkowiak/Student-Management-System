package app.service;

import org.springframework.stereotype.Service;

@Service
public class IdentifierProvider {
    static int id = 0;

    public int getId() {
        return ++id;
    }
}
