package com.reus.leetcode.google.screening

class LicenseKeyFormatting {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val symbols = s.replace("-", "")
        var result = ""
        var counter = 0
        for (i in symbols.length - 1 downTo 0) {
            val toAdd = symbols[i].uppercase()
            result = toAdd + result
            counter++
            if (counter % k == 0 && i > 0) {
                result = "-${result}"
            }
        }
        return result
    }
}