package android.os;

public interface IPowerManager extends IInterface {

    boolean isInteractive();

    abstract class Stub extends Binder implements IPowerManager {
        public static IPowerManager asInterface(IBinder binder) {
            throw new RuntimeException("Stub!");
        }
    }
}
