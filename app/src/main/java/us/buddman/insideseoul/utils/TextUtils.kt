package us.buddman.insideseoul.utils

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Junseok Oh on 2017-06-21.
 */

object TextUtils {
    var colorPrimary = "#263C60"

    fun setPartialColor(textView: TextView, vararg target: String) {
        val builder = SpannableStringBuilder(textView.text.toString())
        val s = textView.text.toString()
        for (targetStr in target) {
            builder.setSpan(ForegroundColorSpan(Color.parseColor(colorPrimary)), s.indexOf(targetStr), s.indexOf(targetStr) + targetStr.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        textView.text = builder
    }

    fun isNotEmpty(vararg editTexts: EditText): Boolean {
        for (e in editTexts) {
            if (e.text.toString().trim { it <= ' ' } != "") return true
        }
        return false
    }


}
