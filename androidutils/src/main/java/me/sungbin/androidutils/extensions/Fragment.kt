package me.sungbin.androidutils.extensions

import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.Fragment
import me.sungbin.androidutils.util.toastutil.ToastLength
import me.sungbin.androidutils.util.toastutil.ToastType
import me.sungbin.androidutils.util.toastutil.ToastUtil

/**
 * Created by SungBin on 2021-01-20.
 */

fun Fragment.alert(
    title: String?,
    message: String = "",
    closeMessage: String = "",
    closeEvent: ((DialogInterface, Int) -> Unit)? = null
) = requireActivity().alert(title, message, closeMessage, closeEvent)

@Deprecated(
    "Custom Toast was Deprecated at Android R",
    ReplaceWith(
        "toast(message)",
        "me.sungbin.androidutils.util.toastutil.ToastUtil"
    )
)
fun Fragment.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType) =
    ToastUtil.show(requireContext(), message, duration, type)

fun Fragment.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
    onToastShown: (() -> Unit)? = null,
    onToastHidden: (() -> Unit)? = null
) = ToastUtil.show(requireContext(), message, duration, onToastShown, onToastHidden)