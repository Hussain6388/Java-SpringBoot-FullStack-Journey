package in.strinke.service;

import in.strinke.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    Map<Integer, User> usersDb;

    public UserService() {
        usersDb = new HashMap<>();
    }

    public User createUser(User userReq) {
        usersDb.put(userReq.getId(), userReq);
        return userReq;
    }

    public User getUserById(Integer id) {
        return usersDb.get(id);
    }

    public List<User> getAll() {
        return new ArrayList<>(usersDb.values());
    }

    public User updateUser(Integer id, User userReq) {
        usersDb.put(id, userReq);
        return usersDb.get(id);
    }

    public String deleteUser(Integer id) {
        if(usersDb.containsKey(id)) {
            usersDb.remove(id);
            return "User delete successfully";
        }
        return null;
    }
}
