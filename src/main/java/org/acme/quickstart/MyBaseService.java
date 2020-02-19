package org.acme.quickstart;

import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MyBaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBaseService.class);

    /**
     * A matcher for any account.
     */
    protected static final String ANY_ACCOUNT = ".*";

    @Inject
    @ConfigProperty(name = "platform.endpoint")
    Optional<String> platformEndpoint;

    @Inject
    @ConfigProperty(name = "sdm.application.private.key")
    Optional<String> sdmAppPrivateKey;

    @Inject
    @ConfigProperty(name = "sdm.application.id")
    Optional<String> sdmAppId;

    @Inject
    @ConfigProperty(name = "config-store.endpoint", defaultValue = "http://config-store/data/config/v1")
    String configStoreEndpoint;

    abstract String getKeyPrefix();

    @PostConstruct
    public void init() {
        LOGGER.info("init");

    }

    public String getConfigStoreEndpoint() {
        return configStoreEndpoint;
    }
}
