package helloworld.web;

import helloworld.AppInfoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean
@Component("helloBean")
@Scope("session")
public class HelloBean {

    @Autowired
    private AppInfoProvider appInfoProvider;

    private String firstname;

    private String lastname;

    private AppInfo appInfo;

    public AppInfo getAppInfo() {
        if (appInfo == null) {
            appInfo = appInfoProvider.getAppInfo();
        }
        return appInfo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
