package com.base.exception;

/**
 * Base Exception Class.
 *
 * @author components on 8/9/2022.
 * @version 1.0.0
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 3263046821289003394L;

    /**
     * Constructor.
     */
    public BaseException() {
        super();
    }

    /**
     * Constructor with args.
     *
     * @param message The message
     * @param cause The cause
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
