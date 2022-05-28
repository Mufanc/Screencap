#!/usr/bin/env zx

const deploy_path = '/data/local/tmp/screencap.apk'

/* build apk */
await $`./gradlew build`
const apk_path = await $`find app -wholename **/*app-release*.apk`

/* deploy to device */
await $`adb push ${apk_path} ${deploy_path}`

/* run app_process */
await $`adb shell app_process -Djava.class.path=${deploy_path} /system/bin mufanc.tools.screencap.Main`
