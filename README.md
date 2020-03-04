# SBT
Android Utils by SungBin.

![Logo](https://raw.githubusercontent.com/sungbin5304/SBT/master/sbt.png)

-----

# Download [![gitpack](https://jitpack.io/v/sungbin5304/SBT.svg)](https://jitpack.io/#sungbin5304/SBT)

```Gradle
repositories {
  mavenCentral()
  google()
  maven { 
    url 'https://jitpack.io' 
  }
}

dependencies {
  implementation 'com.github.sungbin5304:SBT:{version}'
  implementation 'com.github.Shashank02051997:FancyToast-Android:0.1.6'
  implementation 'org.jsoup:jsoup:1.12.1'
}
```

### Use Library
[[jsoup: Java HTML Parser]](https://github.com/jhy/jsoup) <br>
[[FancyToast-Android]](https://github.com/Shashank02051997/FancyToast-Android)

# Usage
## DialogUtils
```kotlin
- makeMarginLayout(ctx: Context, layout: LinearLayout): FrameLayout
```

## NotificationManager [[GitHub Page]](https://github.com/sungbin5304/NotificationManager)
```kotlin
- setGroupName(name: String)
- createChannel(context: Context, name: String, description: String)
- showNormalNotification(context: Context, id: Int, title: String, content: String, icon: Int)
- showInboxStyleNotification(context: Context, id: Int, title: String, content: String, boxText: List<String>, icon: Int)
- deleteNotification(context: Context, id: Int)
```

## Utils
```kotlin
- sdcard (return external storage path string)
- createFolder(name: String)
- read(name: String, _null: String): String
- save(name: String, content: String)
- delete(name: String)
- readData(ctx: Context, name: String, _null: String): String?
- saveData(ctx: Context, name: String, value: String)
- clearData(ctx: Context)
- copy(ctx: Context, text: String)
- error(ctx: Context, e: Exception, at: String)
- toast(ctx: Context, txt: String, length: Int, type: Int) (use fancytoast)
- getHtml(adress: String): String? (use jsoup)
```

-----

# Happy Coding :)
