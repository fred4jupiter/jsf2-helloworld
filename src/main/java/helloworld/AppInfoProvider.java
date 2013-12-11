package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Component("appInfoProvider")
@Scope("session")
public class AppInfoProvider {

    @Autowired
    private Properties appInfoProperties;

    @Autowired
    private Environment environment;

    public String getManifestEntries() {
        appInfoProperties.put("active profiles", Arrays.asList(environment.getActiveProfiles()));

        return appInfoProperties.toString();
    }

}
