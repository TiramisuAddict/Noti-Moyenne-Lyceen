package com.example.noti

import android.content.Context
import androidx.core.app.ActivityOptionsCompat

class Animations {
    fun swipeEffect(context: Context, string: String): ActivityOptionsCompat {
        if (string == "swipeRight") {
            return ActivityOptionsCompat.makeCustomAnimation(
                context,
                R.anim.slide_in_right,
                R.anim.slide_out_left,
            )
        }else{
            return ActivityOptionsCompat.makeCustomAnimation(
                context,
                R.anim.slide_in_left,
                R.anim.slide_out_right,
            )
        }
    }

}