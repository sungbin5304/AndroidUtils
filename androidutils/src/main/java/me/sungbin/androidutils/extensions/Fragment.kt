package me.sungbin.androidutils.extensions

import android.content.DialogInterface
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

fun Fragment.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType) =
    ToastUtil.show(requireContext(), message, duration, type)
