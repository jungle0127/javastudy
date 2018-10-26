package sms.filestore;

import sms.module.Entity;
import sms.persistent.PersistenceService;

import java.util.List;
import java.util.Optional;

public class PersistenceServiceImpl implements PersistenceService {
    @Override
    public <T extends Entity> List<T> list(Class<T> type) {
        return null;
    }

    @Override
    public <T extends Entity> Optional<T> get(Class<T> type, String id) {
        return Optional.empty();
    }

    @Override
    public void save(Entity entity) {

    }

    @Override
    public <T extends Entity> void delete(Class<T> type, String id) {

    }
}
