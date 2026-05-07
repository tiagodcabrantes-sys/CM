
package cm.exer_1

import kotlin.math.sqrt

data class Vec2(val x: Double, val y: Double) : Comparable<Vec2> {

    operator fun plus(other: Vec2): Vec2 {
        return Vec2(x + other.x, y + other.y)
    }

    operator fun minus(other: Vec2): Vec2 {
        return Vec2(x - other.x, y - other.y)
    }

    operator fun times(scalar: Double): Vec2 {
        return Vec2(x * scalar, y * scalar)
    }

    operator fun unaryMinus(): Vec2 {
        return Vec2(-x, -y)
    }

    override operator fun compareTo(other: Vec2): Int {
        val thisMagnitude = magnitude()
        val otherMagnitude = other.magnitude()

        return thisMagnitude.compareTo(otherMagnitude)
    }

    fun magnitude(): Double {
        return sqrt(x * x + y * y)
    }

    fun dot(other: Vec2): Double {
        return x * other.x + y * other.y
    }

    fun normalized(): Vec2 {
        val mag = magnitude()

        if (mag == 0.0) {
            throw IllegalStateException("Cannot normalize zero vector")
        }

        return Vec2(x / mag, y / mag)
    }

    operator fun get(index: Int): Double {
        if (index == 0) {
            return x
        } else if (index == 1) {
            return y
        } else {
            throw IndexOutOfBoundsException("Index must be 0 or 1")
        }
    }
}

fun main() {

    val a = Vec2(3.0, 4.0)
    val b = Vec2(1.0, 2.0)

    println("a = $a")
    println("b = $b")

    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * 2.0 = ${a * 2.0}")
    println("-a = ${-a}")

    println("|a| = ${a.magnitude()}")
    println("a dot b = ${a.dot(b)}")
    println("norm(a) = ${a.normalized()}")

    println("a[0] = ${a[0]}")
    println("a[1] = ${a[1]}")

    println("a > b = ${a > b}")
    println("a < b = ${a < b}")

    val vectors = listOf(
        Vec2(1.0, 0.0),
        Vec2(3.0, 4.0),
        Vec2(0.0, 2.0)
    )

    val longest = vectors.maxWithOrNull(compareBy { it })
    val shortest = vectors.minWithOrNull(compareBy { it })

    println("Longest = $longest")
    println("Shortest = $shortest")
}