package mufanc.tools.screencap

fun String.execute(): ByteArray {
    return Runtime.getRuntime()
        .exec(this.split("\\s".toRegex()).toTypedArray())
        .inputStream.readBytes()
}

inline fun catch(block: () -> Unit) {
    try {
        block()
    } catch (err: Throwable) {
        err.printStackTrace()
    }
}
