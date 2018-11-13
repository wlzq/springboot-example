package org.allen.demo.domain;

public class Permission {

    private int permId;
    private String permName;
    private String permUrl;
    private String permType;
    private int permPid;
    private String permDesc;

    public Permission (){}

    public Permission(int permId, String permName, String permUrl, String permType, int permPid, String permDesc){
        this.permId = permId;
        this.permName =permName;
        this.permUrl = permUrl;
        this.permType = permType;
        this.permPid = permPid;
        this.permDesc = permDesc;
    }

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }

    public int getPermPid() {
        return permPid;
    }

    public void setPermPid(int permPid) {
        this.permPid = permPid;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }
}
