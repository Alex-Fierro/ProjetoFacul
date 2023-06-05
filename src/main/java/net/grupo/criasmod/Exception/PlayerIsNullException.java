package net.grupo.criasmod.Exception;

public class PlayerIsNullException extends NullPointerException {

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        throw new PlayerIsNullException();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }


}
