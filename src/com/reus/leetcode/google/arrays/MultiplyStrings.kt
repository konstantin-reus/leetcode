package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/multiply-strings
 */
class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }
        val (shorter, longer) = getShorterLonger(num1, num2)
        val subSums = getSubSums(shorter = shorter, longer = longer)

        return subSums.reduce { accumulator, subSum ->
            getSum(accumulator, subSum)
        }
    }

    private fun getSum(s1: String, s2: String): String {
        if (s1.isBlank()) {
            return s2
        } else if (s2.isBlank()) {
            return s1
        }
        val (shorter, longer) = getShorterLonger(s1, s2)
        val shorterArr = shorter.toCharArray()
        val longerArr = longer.toCharArray()
        var result = ""
        var carry = 0
        for (i in shorterArr.size - 1 downTo 0) {
            val first = Integer.valueOf(shorterArr[i].toString())
            val diff = longerArr.size - shorterArr.size
            val second = Integer.valueOf(longerArr[i + diff].toString())
            val summed = first + second + carry
            carry = 0
            result += "${summed % 10}"
            carry = summed / 10
        }
        for (i in longerArr.size - shorterArr.size - 1 downTo 0) {
            val digit = Integer.valueOf(longerArr[i].toString()) + carry
            carry = 0
            result += digit % 10
            carry = digit / 10
        }
        if (carry != 0) {
            result += "${carry}"
        }
        return result.reversed()

    }

    private fun getSubSums(shorter: String, longer: String): List<String> {
        var subSums = mutableListOf<String>()
        val shorterArr = shorter.toCharArray()
        val longerArr = longer.toCharArray()
        for (i in shorterArr.size - 1 downTo 0) {
            var carry = 0
            val first = Integer.valueOf(shorterArr[i].toString())
            var iResult = ""
            (longerArr.size - 1 downTo 0).map { Integer.valueOf(longerArr[it].toString()) }.forEach { second ->
                val multiplied = first * second + carry
                if (multiplied > 9) {
                    carry = multiplied / 10
                } else {
                    carry = 0
                }
                iResult += "${multiplied % 10}"
            }
            if (carry != 0) {
                iResult += "${carry}"
            }
            subSums += iResult.reversed()
        }
        return subSums.mapIndexed { index, subSum -> subSum + "0".repeat(index) }
    }

    private fun getShorterLonger(s1: String, s2: String): Pair<String, String> {
        return when {
            s1.length <= s2.length -> s1 to s2
            s1.length > s2.length -> s2 to s1
            else -> throw IllegalStateException("Can never happen")
        }
    }
}

fun main() {
    println(MultiplyStrings().multiply("999", "99"))

}