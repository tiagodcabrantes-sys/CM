package cm.exer_3

fun main() {

    val saltos = generateSequence(100.0) { it * 0.6 }
    val saltos1 = saltos.filter { it >= 1 }
    val saltos2 = saltos1.take(15)

    for (i in saltos2) {
        println("%.2f".format(i))
    }
}