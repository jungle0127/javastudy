module sms.filestore {
    requires sms.module;
    requires sms.persistence;
    provides sms.persistent.PersistenceService with sms.filestore.PersistenceServiceImpl;
}