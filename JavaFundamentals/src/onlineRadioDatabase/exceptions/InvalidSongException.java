package onlineRadioDatabase.exceptions;

import sun.plugin.dom.exception.InvalidStateException;

public abstract class InvalidSongException extends InvalidStateException {

    public InvalidSongException(String s) {
        super(s);
    }
}
