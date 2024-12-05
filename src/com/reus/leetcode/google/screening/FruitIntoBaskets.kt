package com.reus.leetcode.google.screening

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
class FruitIntoBaskets {
    fun totalFruit(fruits: IntArray): Int {
        if (fruits.size == 1) {
            return 1
        }
        var left = 0
        var right = 1
        var fruitToQty = mutableMapOf<Int, Int>()
        fruitToQty[fruits[left]] = 1
        var result = 0

        while (left < right && right <= fruits.size - 1) {
            fruitToQty[fruits[right]] = (fruitToQty[fruits[right]] ?: 0) + 1
            if (fruitToQty.size > 2) {
                while (fruitToQty.size > 2) {
                    fruitToQty[fruits[left]] = fruitToQty[fruits[left]]!! - 1
                    if (fruitToQty[fruits[left]]!! == 0) {
                        fruitToQty.remove(fruits[left])
                    }
                    left++
                }
            } else {
                result = Math.max(result, right - left + 1)
            }
            right++
        }
        return result
    }
}
