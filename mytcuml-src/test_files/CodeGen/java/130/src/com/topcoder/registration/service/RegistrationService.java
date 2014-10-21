package com.topcoder.registration.service;
/**
*/
public interface RegistrationService{
/**
 * @param Return 
 * @param id 
 * @return 
*/
public Contest getContest(long id) {
    return null;
}
/**
 * @param Return 
 * @return 
*/
public List<Contest> getAllContests() {
    return null;
}
/**
 * @param Return 
 * @return 
*/
public List<Contest> getOpenContests() {
    return null;
}
/**
 * @param type 
 * @param Return 
 * @return 
*/
public List<Contest> getOpenContestsByType(ContestType type) {
    return null;
}
/**
 * @param filter 
 * @param Return 
 * @return 
*/
public List<Contest> searchContests(Filter filter) {
    return null;
}
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
*/
public void register(Contest contest, User user, ContestRole role) {
}
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
*/
public void unregister(Contest contest, User user, ContestRole role) {
}
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
 * @return 
*/
public boolean validateRegistration(Contest contest, User user, ContestRole role) {
    return false;
}
/**
 * @param contest 
 * @param user 
 * @param role 
 * @param Return 
 * @return 
*/
public boolean validateUnregistration(Contest contest, User user, ContestRole role) {
    return false;
}
/**
 * @param Return 
 * @return 
*/
public List<Role> getAllRoles() {
    return null;
}
/**
 * @param Return 
 * @return 
*/
public List<ContestType> getAllContestTypes() {
    return null;
}
/**
 * @param contest 
 * @param user 
 * @param validate 
 * @param role 
 * @param alertEventHandlers 
 * @param Return 
*/
public void register(Contest contest, User user, ContestRole role, boolean validate, boolean alertEventHandlers) {
}
/**
 * @param contest 
 * @param user 
 * @param validate 
 * @param role 
 * @param alertEventHandlers 
 * @param Return 
*/
public void unregister(Contest contest, User user, ContestRole role, boolean validate, boolean alertEventHandlers) {
}
}

