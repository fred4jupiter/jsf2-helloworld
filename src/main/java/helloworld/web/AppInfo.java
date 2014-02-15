package helloworld.web;

import java.io.Serializable;

public class AppInfo implements Serializable {

    private String activeProfiles;

    private String buildDate;

    private String appVersion;

    public String getActiveProfiles() {
        return activeProfiles;
    }

    public void setActiveProfiles(String activeProfiles) {
        this.activeProfiles = activeProfiles;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
