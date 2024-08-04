package com.base.exception;

/**
 * Base Runtime Exception Class.
 *
 * @author alex on 8/9/2022.
 * @version 1.0.0
 */
public class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 3263046821289003394L;

    /**
     * Constructor with args.
     *
     * @param message The message
     * @param cause The cause
     */
    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
