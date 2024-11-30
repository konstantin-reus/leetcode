package com.reus.leetcode.google.screening

/**
 * https://leetcode.com/problems/unique-email-addresses
 */
class UniqueEmailAddresses {
    fun numUniqueEmails(emails: Array<String>): Int {
        val uniqueEmails = mutableSetOf<String>()
        for (email in emails) {
            var localName = email.split('@')[0]
            if (localName.contains('+')) {
                localName = localName.substring(0, localName.indexOfFirst { it == '+' })
            }
            localName = localName.replace(".", "")
            val domain = email.split('@')[1]
            uniqueEmails.add(localName + '@' + domain)
        }
        return uniqueEmails.size
    }
}

fun main() {
    println(
        UniqueEmailAddresses().numUniqueEmails(
            arrayOf(
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
            )
        )
    )
}