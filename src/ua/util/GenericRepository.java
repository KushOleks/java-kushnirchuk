package ua.util;

import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T> {
    private static final Logger logger = Logger.getLogger(GenericRepository.class.getName());
    private final List<T> storage = new ArrayList<>();
    private final IdentityExtractor<T> identityExtractor;

    public GenericRepository(IdentityExtractor<T> identityExtractor) {
        this.identityExtractor = identityExtractor;
    }

    public void add(T item) {
        logger.info("Adding: " + item);
        storage.add(item);
    }

    public void remove(T item) {
        logger.info("Removing: " + item);
        storage.remove(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(storage);
    }

    public T findByIdentity(String identity) {
        for (T item : storage) {
            if (identityExtractor.extractIdentity(item).equals(identity)) {
                logger.info("Found: " + item);
                return item;
            }
        }
        logger.warning("Object with identity '" + identity + "' not found");
        return null;
    }
}