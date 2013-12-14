package helloworld;

import helloworld.web.AppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Properties;

@Component("appInfoProvider")
@Scope("session")
public class AppInfoProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppInfoProvider.class);

    @Autowired
    private Properties appInfoProperties;

    @Autowired
    private Environment environment;

    public AppInfo getAppInfo() {
        LOGGER.debug("getAppInfo");

        AppInfo appInfo = new AppInfo();

        if (environment.getActiveProfiles() == null || environment.getActiveProfiles().length == 0) {
            appInfo.setActiveProfiles("---");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String profile : environment.getActiveProfiles()) {
                stringBuilder.append(profile + " ");
            }
            appInfo.setActiveProfiles(stringBuilder.toString());
        }

        appInfo.setAppVersion(appInfoProperties.getProperty("Project-Version"));
        appInfo.setBuildDate(appInfoProperties.getProperty("Build-Date"));
        return appInfo;
    }

}
