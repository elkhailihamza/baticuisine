package Models;

public class Roles {
    private final long role_id;
    private String roleName;

    public Roles(long role_id, String roleName) {
        this.role_id = role_id;
        this.roleName = roleName;
    }

    public long getRole_id() {
        return role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
