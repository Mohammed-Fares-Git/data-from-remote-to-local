package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon

import android.app.AlertDialog
import android.content.Context
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.R
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.ErrorBinding
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.LoadingBinding
import java.text.SimpleDateFormat
import java.util.Date

object Constante {

    const val API_ENDPOINT = "/047e7d73-8ae1-4212-be4e-e573235993f7"
    const val API_BASE_URL = "https://run.mocky.io/v3"
    const val DATE_FORMAT = "dd MMMM yyyy"

    fun getUnixTimestampFromDate(dateString: String, dateFormat: String): Long {
        val formatter = SimpleDateFormat(dateFormat)
        val date = formatter.parse(dateString)
        return date.time / 1000
    }

    fun getDateFromUnixTimestamp(timestamp: Long, dateFormat: String): String {
        val date = Date(timestamp * 1000)
        val formatter = SimpleDateFormat(dateFormat)
        return formatter.format(date)
    }


    fun getRemainingTime(timestamp: Long): String {


        var remaningTime: String = "Epires after : "


        val secondsInMinute = 60L
        val secondsInHour = secondsInMinute * 60
        val secondsInDay = secondsInHour * 24
        val secondsInMonth = secondsInDay * 30
        val secondsInYear = secondsInDay * 365


        val years = timestamp / secondsInYear
        val months = (timestamp % secondsInYear) / secondsInMonth
        val days = ((timestamp % secondsInYear) % secondsInMonth) / secondsInDay


        if (years > 0 ) {
            remaningTime += "${years} year"
        }

        if (months > 0 ) {
            remaningTime += "${if(years > 0) "," else ""} ${months} months"
        }


        if (days > 0 ) {
            remaningTime += "${if(months > 0 || years > 0) "," else ""} ${days} year"
        }


        return remaningTime
    }

    fun showErrorDialog(
        context: Context,
        dialogBinding: ErrorBinding,
        image: Int = R.drawable.netwok_error,
        message: String
    ) {
        val builder = AlertDialog.Builder(context)
        val view = dialogBinding.root
        builder.setView(view)
        val dialog = builder.create()
        dialogBinding.dialogImage.setImageResource(image)
        dialogBinding.dialogMessage.text = message
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        //dialog.window?.setBackgroundDrawableResource(R.drawable.auth_forms_bg)

        dialog.show()
    }

    fun showLoadingDialog(
        context: Context,
        dialogBinding: LoadingBinding,
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
        val view = dialogBinding.root
        builder.setCancelable(false)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.show()
        return dialog
    }
}