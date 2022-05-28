package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface IPackageManager extends IInterface {

    String[] getPackagesForUid(int uid);

    abstract class Stub extends Binder implements IPackageManager {
        public static IPackageManager asInterface(IBinder binder) {
            throw new RuntimeException("Stub!");
        }
    }
}
