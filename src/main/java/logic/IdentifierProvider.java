package logic;

public class IdentifierProvider {
    static int id = 0;

    public int getId() {
        return ++id;
    }
}
