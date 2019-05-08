package eu.activage.services.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Simlife.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.simlife.config.SimlifeProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
