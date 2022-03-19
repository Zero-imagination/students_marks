package authentication;

import authentication.model.Role;
import gui.boxes.BoxStudentInfo;

import java.util.Set;

public class UserPermissions {
    private static Set<Role> userRole = null;

    public static void setUserRole(Set<Role> userRole) {
        UserPermissions.userRole = userRole;
    }
    static public void createPermissions(){
        BoxStudentInfo.getBoxControlStudent().setVisible(true);
        for (Role role: userRole){
            if (role.getId()!=2)
                BoxStudentInfo.getBoxControlStudent().setVisible(false);
        }
    }
}
