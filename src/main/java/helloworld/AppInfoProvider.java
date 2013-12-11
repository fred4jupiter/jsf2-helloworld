package helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component("appInfoProvider")
@Scope("session")
public class AppInfoProvider {

    @Autowired
    private Properties appInfoProperties;

    public String getManifestEntries() {
        return appInfoProperties.toString();
    }

}
