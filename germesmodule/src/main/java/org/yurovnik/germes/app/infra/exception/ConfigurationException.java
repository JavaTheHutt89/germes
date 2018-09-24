package org.yurovnik.germes.app.infra.exception;


import org.yurovnik.germes.app.infra.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * @author YurovnikMV
 *
 */

public class ConfigurationException extends AppException{
    private static final long serialVersionUID = 2177284893894040026L;

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }
}
