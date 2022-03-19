package authentication.services;

import authentication.model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class UserAuthorization {
    public User getAuthenticatedUser(String username, String password){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findByUsername(username);
        if (user!=null && Objects.equals(user.getPassword(), getHash(password))){
            return user;
        }
        return null;
    }

    private String getHash(String string){
        StringBuilder hash= new StringBuilder();
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes =sha256.digest(string.getBytes());
            for (byte b:hashBytes){
                hash.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash.toString();
    }
}
