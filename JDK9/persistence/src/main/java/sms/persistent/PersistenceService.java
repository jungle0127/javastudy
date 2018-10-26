package sms.persistent;

import sms.module.Entity;

import java.util.List;
import java.util.Optional;

public interface PersistenceService {
    <T extends Entity> List<T> list(Class<T> type) ;
    <T extends Entity> Optional<T> get(Class<T> type, String id);
    void save(Entity entity);
    <T extends Entity> void delete(Class<T> type,String id);
}
