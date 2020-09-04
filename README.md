![Logo](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/banner.png)
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
}
```

# Usage

> goto [v1~v3](https://github.com/sungbin5304/AndroidUtils/blob/master/v1-3_usage.md) usage **[deprecated version]**

# Listener

```kotlin
OnSwipeListener(ctx: Context) : View.OnTouchListener
    - fun onSwipeLeftToRight()
    - fun onSwipeRightToLeft()
    - fun onSwipeBottomToTop()
    - fun onSwipeTopToBottom()
```

-----

# Extensions

```kotlin
ImageView.setTint(color: Int)

Int.toColorStateList()

String.replaceLast(findText: String, replaceText: String): String
String.isUpperCase(): Boolean
String?.toEditable(): Editable

EditText.showKeyboard()
EditText.hideKeyboard()
EditText.setEndDrawableClickEvent(action: (View) -> Unit)
EditText.beforeTextChange(action: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)
EditText.afterTextChanged(action: (s: Editable?) -> Unit)
EditText.onTextChanged(action: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)


[operator] TextView.plusAssign(text: String)
TextView.clear()

View.show()
View.hide(isGone: Boolean = false)
[operator] View.get(@IdRes id: Int): View
```

-----

# UI

## TagableRoundImageView [[More Guide](https://github.com/sungbin5304/TagableRoundImageView)]

![banner](https://raw.githubusercontent.com/sungbin5304/TagableRoundImageView/master/banner.png)



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
