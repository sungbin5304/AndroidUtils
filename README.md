![Logo](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/banner%20(1).png)
<p align="center">
    <a href="https://github.com/sungbin5304/
AndroidUtils/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/badge/License-Apache2-important"/></a>
  <a href="https://jitpack.io/#sungbin5304/SBT"><img alt="Title" src="https://jitpack.io/v/sungbin5304/SBT.svg"/></a>
  <a href="https://github.com/sungbin5304/
AndroidUtils"><img alt="Title" src="https://img.shields.io/badge/Utils-ANDROID-blueviolet"/></a>
  <a href="https://github.com/sungbin5304/
AndroidUtils"><img alt="Title" src="https://img.shields.io/badge/UI-ANDROID-9cf"/></a>
    <a href="https://codebeat.co/projects/github-com-sungbin5304-androidutils-master"><img alt="codebeat badge" src="https://codebeat.co/badges/213185fa-52cb-43c6-9d69-86bd57e19c03" /></a>
</p><br>
</p><br>

-----

# Download

```Gradle
repositories {
  mavenCentral()
  google()
  maven { 
    url 'https://jitpack.io' 
  }
}

dependencies {
  implementation 'com.github.sungbin5304:AndroidUtils:{version}'
  implementation 'org.jsoup:jsoup:1.12.1' (optional)
}
```

# Usage
# Extensions
```kotlin
- View.hide(isGone: Boolean = false)
- View.show()
- View.get(@IdRes id: Int): View (View.findViewById(id))
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
- getHtml(address: String): String? (need implementation jsoup library)
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
```gradle
android {
  packagingOptions {
      exclude 'META-INF/library_release.kotlin_module'
  }
}
```

# License
```
                    Copyright 2020 SungBin

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```


# Happy Coding :)
