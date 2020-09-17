# Deprecated version(v1~v3) usage
# Extensions
```kotlin
- View.hide(isGone: Boolean = false)
- View.show()
- View.get(@IdRes id: Int): View (View.findViewById(id))
- View.setOnTouchListener(object : OnSwipeListener(context!!) {
    override fun onSwipeLeftToRight() {
      //TODO
    }
    override fun onSwipeRightToLeft() {
      //TODO
    }
    override fun onSwipeBottomToTop() {
      //TODO
    }
    override fun onSwipeTopToBottom() {
      //TODO
    }
  })
- TextView += String (TextView.text = String)
- TextView.clear() (TextView.text = "")
- TextView.beforeTextChange(s: CharSequence?, start: Int, count: Int, after: Int) 
- TextView.afterTextChanged(s: Editable?)
- TextView.onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
- EditText.setEndDrawableClickEvent(action: (View) -> Unit)
- String?.toEditable(): Editable
- String.isUpperCase(): Boolean
- String.isLowerCase(): Boolean
- String.replaceLast(origin: String, replaceMent: String): String
- ImageView.setTint(color: Int)
```

# Utils
## LayoutUtils
```kotlin
- putMargin(layout: ViewGroup): FrameLayout
```

## NotificationUtils [[Help Page]](https://github.com/sungbin5304/NotificationManager)
```kotlin
- setGroupName(name: String)
- createChannel(context: Context, name: String, description: String)
- showNormalNotification(context: Context, id: Int, title: String, content: String, icon: Int)
- showInboxStyleNotification(context: Context, id: Int, title: String, content: String, boxText: List<String>, icon: Int)
- deleteNotification(context: Context, id: Int)
```

## DataUtils
```kotlin
- readData(ctx: Context, name: String, _null: String): String
- saveData(ctx: Context, name: String, value: String)
- clearData(ctx: Context)
```
 
## DialogUtils
```kotlin
- show(ctx: Context, title: String, message: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
- showOnce(ctx: Context, title: String, message: String, id: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
- showLicense() //todo
```

## LogUtils [[More Guide]](https://github.com/sungbin5304/PrettyLogger)
### Logging with Default Tag
``` Kotlin
- w(any: Any?)
- v(any: Any?)
- d(any: Any?)
- e(any: Any?)
- i(any: Any?)
```
### PrettyLogger is supported `Iterable`, `Array` and `Map` logging.
``` Kotlin
val map = HashMap<String, String>()
map["A"] = "BCD"
map["E"] = "FGH"
map["I"] = "JKL"
LogUtils.d("Map Content", map)
LogUtils.i("Iterable Content", arrayListOf("T", "", "E", "", "S", "T", "", "above data is empty value."))
LogUtils.e(null)
LogUtils.w("This is my Pretty Log.")
LogUtils.setTag("Custom Tag")
LogUtils.v("Change Tag.")
```
![preview](https://github.com/sungbin5304/PrettyLogger/blob/master/images/PrettyLogger.png)

## PermissionUtils
```Kotlin
- request(act: Activity, message: String?, permission: Array<String>)
- requestReadNotification(act: Activity)
```

## ColorUtils
```Kotlin
- setStatusBarColor(act: Activity, color: Int)
- setNavigationBarColor(act: Activity, color: Int)
- setStatusBarIconColorGray(act: Activity)
```

## StorageUtils
```Kotlin
- sdcard
- createFolder(name: String): Boolean
- read(name: String, _null: String?): String?
- save(name: String, content: String): Boolean
- delete(name: String): Boolean
- deleteAll(name: String): Boolean
- getFileSize(file: File): String
```

## ToastUtils
```Kotlin
- show(context: Context, message: String, duration: Int, type: Int)

+ Duration List
- SHORT
- LONG

+ Type List
- INFO
- SUCCESS
- WARNING
- ERROR 
```

## Utils
```Kotlin
- copy(ctx: Context, text: String, showToast: Boolean = true)
- error(ctx: Context, e: Exception, at: String)
- setUserAgent(agent: String)
- getHtml(address: String): String?
- makeRandomUUID(numberOnly: Boolean = true): String
- getAppVersionName(act: Activity): String
```

## StringUtils
```kotlin
- toEditable(string: String): Editable (support string extensions; String.toEditable())
```

## ReadMoreUtils
```kotlin
- setReadMoreLine(view: TextView, text: String, maxLine: Int, expanedText: String = "...더보기", expanedTextColor: Int = Color.parseColor("#9E9E9E"))
- setReadMoreLength(view: TextView, text: String, maxLength: Int,expanedText: String = "...더보기", expanedTextColor: Int = Color.parseColor("#9E9E9E"))
```

# UI
## TagableRoundImageView [[More Guide]](https://github.com/sungbin5304/TagableRoundImageView)
### preview
![image](https://raw.githubusercontent.com/sungbin5304/TagableRoundImageView/master/banner.png)

### xml
```xml
<com.sungbin.sungbintool.ui.TagableRoundImageView
        android:id="@+id/image"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:src="@drawable/doraemon"
        app:triv_imageRadius="16dp"
        app:triv_tagText="gif"
        app:triv_tagPadding="8dp"
        app:triv_tagGravity="end|bottom" />
```

### `TagableRoundImageView` is supported GIF images.
