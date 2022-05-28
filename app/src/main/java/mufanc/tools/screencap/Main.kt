package mufanc.tools.screencap

import android.app.IActivityManager
import android.content.Context
import android.os.IPowerManager
import android.os.ServiceManager
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString

object Main {

    private val activityManager: IActivityManager by lazy {
        IActivityManager.Stub.asInterface(ServiceManager.getService(Context.ACTIVITY_SERVICE))
    }

    private val powerManager: IPowerManager by lazy {
        IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE))
    }

    @JvmStatic
    fun main(vararg argv: String) {
        if (argv.isEmpty()) {
            println("usage: app_process -Djava.class.path=<apk_path> /system/bin mufanc.tools.screencap.Main <output_dir>")
        } else {
            while (true) {
                catch {
                    Thread.sleep(30 * 1000)
                    if (!powerManager.isInteractive) return@catch
                    activityManager.getTasks(1)[0].topActivity?.packageName?.let {
                        screencap(argv[0], it)
                    }
                }
            }
        }
    }

    private fun screencap(outputDir: String, current: String) {
        val image = "screencap -p".execute()
        val path = Path(outputDir, "${System.currentTimeMillis()}-${current}.png")
        path.toFile().writeBytes(image)
    }
}
