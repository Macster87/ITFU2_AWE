package KassensystemKotlin

import java.util.*

@Throws(EANWrongChecksumException::class, EANException::class)
private fun main() = try {
    println(validChecksum(zahlEingeben()))
}
catch (e: EANWrongChecksumException) {
    println("Checksumme stimmt nicht")
}

private var scanner = Scanner(System.`in`)

@Throws(EANWrongChecksumException::class)
fun validChecksum(input: Long): Boolean {
    var checksum = 0
    val ean = input.toString()
    var drei = input.toString().length == 8
    for (digit in ean.toCharArray()) {
        val zahl = digit.toString().toInt()
        checksum = if (drei) {
            checksum + 3 * zahl
        } else {
            checksum + zahl
        }
        drei = !drei
    }

    if(checksum % 10 == 0) return true
    return false
}

private fun validLength(ean: Long): Boolean {
    return ean.toString().length == 8 || ean.toString().length == 13
}

@Throws(EANException::class)
private fun zahlEingeben(): Long {
    val ean: Long
    try {
        print("Zahl eingeben:")
        ean = scanner.nextLong()
        if (!validLength(ean)) {
            throw EANWrongLengthException()
        }
        if (!validChecksum(ean)) {
            throw EANWrongChecksumException()
        }
    } catch (e: InputMismatchException) {
        throw EANWrongDigitException()
    }
    return ean
}