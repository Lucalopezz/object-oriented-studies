package Try2.domain;

public class EntityAlreadyExists extends RuntimeException {
    public EntityAlreadyExists(String message) {
        super(message);
    }
}
