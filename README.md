![Logo](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/banner%20(1).png)

-----

# Download [![](https://jitpack.io/v/sungbin5304/AndroidUtils.svg)](https://jitpack.io/#sungbin5304/AndroidUtils)

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
## LayoutUtils
```kotlin
- putMargin(ctx: Context, layout: ViewGroup): FrameLayout
```

## NotificationUtils [[Help Page]](https://github.com/sungbin5304/NotificationManager)
```kotlin
- setGroupName(name: String)
- createChannel(context: Context, name: String, description: String)
- showNormalNotification(context: Context, id: Int, title: String, content: String, icon: Int)
- showInboxStyleNotification(context: Context, id: Int, title: String, content: String, boxText: List<String>, icon: Int)
- deleteNotification(context: Context, id: Int)
```

## DataUtils (SharedPreferencesUtils)
```kotlin
- readData(ctx: Context, name: String, _null: String): String
- saveData(ctx: Context, name: String, value: String)
- clearData(ctx: Context)
```
 
## DialogUtils
```kotlin
- show(ctx: Context, title: String, message: String, listener: DialogInterface.OnClickListener?)
- showOnce(ctx: Context, title: String, message: String, id: String, listener: DialogInterface.OnClickListener?)
```

## PermissionUtils
```Kotlin
- request(act: Activity, message: String, permission: Array<String>)
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
- createFolder(name: String)
- read(name: String, _null: String): String
- save(name: String, content: String)
- delete(name: String)
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
- copy(ctx: Context, text: String)
- error(ctx: Context, e: Exception, at: String)
- setUserAgent(agent: String)
- getHtml(address: String): String? (need implementation jsoup library)
```

-----

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
