![Logo](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/banner.png)
<p align="center">
    <a href="https://github.com/sungbin5304/
AndroidUtils/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/badge/License-MIT-important"/></a>
    <a href='https://bintray.com/sungbin5304/maven/androidutils/_latestVersion'><img src='https://api.bintray.com/packages/sungbin5304/maven/androidutils/images/download.svg'></a>
    <a href="https://codebeat.co/projects/github-com-sungbin5304-androidutils-master"><img alt="codebeat badge" src="https://codebeat.co/badges/213185fa-52cb-43c6-9d69-86bd57e19c03" /></a><br/>
     <code>iOS</code> version will be open ;)
</p>

----

# Download
```Gradle
dependencies {
  coming soon
}
```
# - Usage - [[old-readme]](https://github.com/sungbin5304/AndroidUtils/blob/master/jitpack-readme.md)
# Listener
```kotlin
OnSwipeListener(context: Context): View.OnTouchListener
    fun onSwipeLeftToRight()
    fun onSwipeRightToLeft()
    fun onSwipeBottomToTop()
    fun onSwipeTopToBottom()
```

-----

# Extensions
```kotlin
ImageView.setTint(color: Int)

Int.toColorStateList()

String.replaceLast(findText: String, replaceText: String): String
String.isUpperCase(): Boolean
String.isLowerCase(): Boolean
String?.toEditable(): Editable

EditText.isEmpty()
EditText.isBlank()
EditText.isNotEmpty()
EditText.isNotBlank()
EditText.showKeyboard()
EditText.hideKeyboard()
EditText.setEndDrawableClickEvent(action: (View) -> Unit)
EditText.beforeTextChange(action: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)
EditText.afterTextChanged(action: (s: Editable?) -> Unit)
EditText.onTextChanged(action: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)

TextView.clear()

<T> Array<T>.join(separator: CharSequence): String
<T> Iterable<T>.join(separator: CharSequence): String

View.show()
View.hide(isGone: Boolean = false)

RecyclerView.setFab(fab: View)
RecyclerView.toBottomScroll()

@Deprecated("Custom Toast was Deprecated at Android R")
Activity.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType)
Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT)
Activity.alert(title: String?, message: String, closeMessage: String = "", closeEvent: ((DialogInterface, Int) -> Unit)? = null)
Activity.startActivity<T>(isNewTask: Boolean = false, vararg extras: Pair<String, *>)

@Deprecated("Custom Toast was Deprecated at Android R")
Fragment.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType)
Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT)
Fragment.alert(title: String?, message: String, closeMessage: String = "", closeEvent: ((DialogInterface, Int) -> Unit)? = null)
Fragment.startActivity<T>(isNewTask: Boolean = false, vararg extras: Pair<String, *>)

doDelay(ms: Int, action: () -> Unit)

@RequiresApi(Build.VERSION_CODES.M)
Icon.toBitmap(context: Context): Bitmap

[operator] <T : View> View.get(@IdRes id: Int, clazz: Class<T>): T
```

-----

# Util
```kotlin
getAppVersionName(activity: Activity): String
copy(context: Context, text: String, showToast: Boolean = true)
error(context: Context, exception: Exception, at: String)
getHtml(address: String): String?
readAsset(context: Context, name: String): String
makeRandomUUID(onlyNumber: Int = false): String
dp2px(context: Context, dp: Float): Float
```

# BatteryUtil
```kotlin
isIgnoringBatteryOptimization(context: Context): Boolean
requestIgnoreBatteryOptimization(context: Context)
```

# DataUtil
```kotlin
readData(context: Context, name: String, _null: String?
saveData(context: Context, name: String, value: String)
clearData(context: Context)
```

# DialogUtil
```kotlin
show(activity: Activity, title: String, message: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
showOnce(activity: Activity, title: String, message: String, id: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
showLicense(activity: Activity, title: String, projects: List<Project>)
```

## Project
`Project(val name: String, val link: String, val license: License)`

## License
### Default
```
MIT
BSD
Apache2
GPL3
LGPL3
```

### Custom
```
CUSTOM(name: String)
```

# DownloadUtil
```kotlin
download(path: String, url: String, downloadDoneAction: () -> Unit)
```

# MediaUtil
```kotlin
scanning(context: Context, path: String)
```

# NetworkUtil
```kotlin
isNetworkAvailable(context: Context): Boolean
```

# NotificationUtil
```kotlin
createChannel(context: Context, name: String, description: String)
getManager(context: Context): NotificationManager
showNormalNotification(context: Context, id: Int, title: String, content: String, icon: Int, isOnGoing: Boolean)
showInboxStyleNotification(context: Context, id: Int, title: String, content: String, boxText: Array<String>, icon: Int, isOnGoing: Boolean)
getNormalNotification(context: Context, title: String, content: String, icon: Int, isOnGoing: Boolean): Notification.Builder
getInboxStyleNotification(context: Context, title: String, content: String, boxText: Array<String>, icon: Int, isOnGoing: Boolean): Notification.Builder
deleteNotification(context: Context, id: Int)
```

# PermissionUtil
```kotlin
request(activity: Activity, message: String?, permission: Array<String>, requestCode: Int = 1)
requestReadNotification(activity: Activity)
checkPermissionsAllGrant(context: Context, permissions: List<String>): Boolean
```

# StorageUtil
```kotlin
[getter] sdcard

createFolder(path: String): Boolean
createFile(path: String): Boolean
getSize(size: Long): String
getFileSize(file: File): String
read(path: String, _null: String?): String?
save(path: String, content: String): Boolean
delete(path: String): Boolean
deleteAll(path: String): Boolean
```

# Logger [[More Guide](https://github.com/sungbin5304/PrettyLogger)]

![Preview](https://raw.githubusercontent.com/sungbin5304/PrettyLogger/master/images/PrettyLogger.png)

## Logging with Default Tag
``` Kotlin
w(any: Any?)
v(any: Any?)
d(any: Any?)
e(any: Any?)
i(any: Any?)
```

> `Logger` is supported `Iterable`, `Array` and `Map` logging.

# TextViewUtil
```kotlin
setReadMore(type: ReadMoreType, view: TextView, text: String, max: Int, expendText: String = "...더보기", expendTextColor: Int = Color.parseColor("#9E9E9E"))
```

### ReadMoreType
```kotlin
LINE
LENGTH
```

# ToastUtil
```kotlin
show(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT)
show(context: Context, message: String, duration: ToastLength, type: ToastType)
```

### ToastLength
``` kotlin
SHORT
LONG
```

### ToastType
``` kotlin
INFO
SUCCESS
WARNING
ERROR
```

-----

# UI

## TagableRoundImageView [[More Guide](https://github.com/sungbin5304/TagableRoundImageView)]

![banner](https://raw.githubusercontent.com/sungbin5304/TagableRoundImageView/master/banner.png)

### xml
```xml
<me.sungbin.androidutils.tagableroundimageview.TagableRoundImageView
        android:id="@+id/image"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:src="@drawable/doraemon"
        app:triv_imageRadius="16dp"
        app:triv_tagText="gif"
        app:triv_tagPadding="8dp"
        app:triv_tagGravity="end|bottom" />
```

### all attribute
| Attribute                 | Description                                                  | Default                            |
| ------------------------- | :----------------------------------------------------------- | ---------------------------------- |
| `triv_tagGravity`         | Set tag gravity (`top`, `bottom`, `left`, `right`, `start`, `end`) | `Gravity.END` and `Gravity.BOTTOM` |
| `triv_tagTextStyle`       | Set tag text style (`italic`, `normal`)                      | `NORMAL`                           |
| `triv_imageRadius`        | Set imageview radius                                         | `16dp`                             |
| `triv_tagRadius`          | Set tag layout radius                                        | `2dp`                              |
| `triv_tagPadding`         | Set tag layout padding                                       | `8dp`                              |
| `triv_tagTextSize`        | Set tag text size                                            | `15dp`                             |
| `triv_tagText`            | Set tag text                                                 | No value                           |
| `triv_tagBackgroundColor` | Set tag layout background color                              | `Color.WHITE`                      |

> `TagableRoundImageView` is supported GIF images.

-----

# Dimens
- `margin_twice_half` (4dp)
- `margin_half` (8dp)
- `margin_default` (16dp)
- `margin_twice` (32dp)
- `margin_twice_and_half` (56dp)

# Colors
![colors](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/colors.png)

-----

# Gradle Error
If you error at gradle `More than one file was found with OS independent path 'META-INF/library_release.kotlin_module'` this, add below code at your gradle.

### for `Groovy`
```gradle
packagingOptions {
  exclude 'META-INF/library_release.kotlin_module'
}
```

### for `Kotlin`
```gradle
packagingOptions {
  exclude("META-INF/library_release.kotlin_module")
}
```

# License
`AndroidUtils` license is under the [`MIT`](https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE).

# Happy Coding :)
