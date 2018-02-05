package org.yurovnik.germes.app.infra.exception.flow;

import org.yurovnik.germes.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * @author YurovnikMV
 *
 */

public class InvalidParameterException extends FlowException {
    private static final long serialVersionUID = 2889607185988464072L;

    public InvalidParameterException(String message) {
        super(message);
    }
}
