package cm.exer_1

fun main(){
     val quadrados = IntArray(50)     //alínea a
    for (i in 0..49){               //vai de 0 a 49
        quadrados[i] = (i+1)*(i+1)          // i+1 para o indice começar em 1 e nao em 0
    }
    for(i in 0..49){
        println(quadrados[i])
    }

    val num = 1..50             //alinea b
    val quadradosB = num.map{it * it}
    for(i in quadradosB){
        println(i)
    }

    val quadradosC = Array(50) {0} //aliena c
    for(i in 0..49){
        quadradosC[i] = (i+1) * (i+1)
    }
    for(i in 0..49){
        println(quadradosC[i])
    }
}


