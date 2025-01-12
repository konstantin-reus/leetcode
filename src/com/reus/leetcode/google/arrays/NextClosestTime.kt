package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/next-closest-time/
 */
class NextClosestTime {
    fun nextClosestTime(time: String): String {
        val (strHours, strMinutes) = time.split(":")
        val totalMinutes = strHours.toInt() * 60 + strMinutes.toInt()
        val allowedDigits = setOf(strHours[0], strHours[1], strMinutes[0], strMinutes[1])
        for (nextTime in totalMinutes + 1..totalMinutes + 60*24) {
            val hours = "%02d".format(nextTime / 60 % 24)
            val minutes = "%02d".format(nextTime % 60)
            if (allowedDigits.containsAll(setOf(hours[0], hours[1], minutes[0], minutes[1]))) {
                return "${hours}:${minutes}"
            }
        }
        return ""
    }
}
