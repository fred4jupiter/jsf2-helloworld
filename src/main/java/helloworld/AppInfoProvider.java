package helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Component("appInfoProvider")
@Scope("session")
public class AppInfoProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppInfoProvider.class);

    @Autowired
    private Properties appInfoProperties;

    @Autowired
    private Environment environment;

    public String getManifestEntries() {
        LOGGER.debug("getManifestEntries");
        appInfoProperties.put("active profiles", Arrays.asList(environment.getActiveProfiles()));

        return appInfoProperties.toString();
    }

}
