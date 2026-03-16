package cm.exer_2

fun main() {
    var decisao = ""

    while(decisao != "sair" && decisao != "Sair") {

        println("Que operacao pretende selecionar(numerica ou booleana ou sair)?: ")

        decisao = readln()

        if (decisao == "numerica" || decisao == "Numerica") {
            println("Insira a opcao que pretende selecionar(+,-,*,/,shl,shr):")
            var opcao1 = readln()

            if (opcao1 == "+" || opcao1 == "-" || opcao1 == "*" || opcao1 == "/" || opcao1 == "shl" || opcao1 == "shr") {
                println("Operacao possivel de se realizar")

                try {
                    println("Insira o primeiro numero: ")
                    var num1 = readln().toInt()
                    println("Insira o segundo numero: ")
                    var num2 = readln().toInt()

                    when (opcao1) {
                        "+" -> {
                            val res = num1 + num2
                            println("Resultado da soma: $res")
                            println("Decimal: $res")
                            println("Hexadecimal: ${res.toString(16)}")
                        }

                        "-" -> {
                            val res = num1 - num2
                            println("Resultado da subtracao: $res")
                            println("Decimal: $res")
                            println("Hexadecimal: ${res.toString(16)}")
                        }

                        "*" -> {
                            val res = num1 * num2
                            println("Resultado da multiplicacao: $res")
                            println("Decimal: $res")
                            println("Hexadecimal: ${res.toString(16)}")
                        }

                        "/" -> {
                            if (num2 != 0) {
                                val res = num1 / num2
                                println("Resultado da divisao: $res")
                                println("Decimal: $res")
                                println("Hexadecimal: ${res.toString(16)}")
                            } else {
                                println("Operacao impossivel de se realizar.O segnudo numero tem de ser diferente de 0.Tente novamente")
                            }
                        }

                        "shl" -> {
                            val res = num1 shl num2
                            println("Resultado shift left: $res")
                            println("Decimal: $res")
                            println("Hexadecimal: ${res.toString(16)}")
                        }

                        "shr" -> {
                            val res = num1 shr num2
                            println("Resultado do shift right: $res")
                            println("Decimal: $res")
                            println("Hexadecimal: ${res.toString(16)}")

                        }
                    }

                } catch (e: Exception) {
                    println("Erro ao inserir valores.")
                }
            } else {
                println("Operacao impossivel de se realizar")
            }

        } else if (decisao == "booleana" || decisao == "Booleana") {
            println("Que operacao pretende raelizar(&&,||,!): ")
            var opcao2 = readln()

            if (opcao2 == "&&" || opcao2 == "||" || opcao2 == "!") {
                println("Operacao possivel de se realizar")

                try {
                    when (opcao2) {
                        "&&" -> {
                            println("Digite o primeiro valor booleano(true ou false): ")
                            var bool1 = readln().toBoolean()
                            println("Digite o segundo valor booleano: ")
                            var bool2 = readln().toBoolean()

                            val res = bool1 && bool2
                            println("Resultado: $res")
                            println("Decimal: ${if (res) 1 else 0}")
                            println("Hexadecimal: ${if (res) "1" else "0"}")
                            println("Booleano: $res")
                        }

                        "||" -> {
                            println("Digite o primeiro valor booleano: ")
                            var bool1 = readln().toBoolean()
                            println("Digite o segundo valor booleano: ")
                            var bool2 = readln().toBoolean()

                            val res = bool1 || bool2
                            println("Resultado: $res")
                            println("Decimal: ${if (res) 1 else 0}")
                            println("Hexadecimal: ${if (res) "1" else "0"}")
                            println("Booleano: $res")
                        }

                        "!" -> {
                            println("Digite o primeiro valor booleano: ")
                            var bool1 = readln().toBoolean()

                            val res = !bool1
                            println("Resultado: $res")
                            println("Decimal: ${if (res) 1 else 0}")
                            println("Hexadecimal: ${if (res) "1" else "0"}")
                            println("Booleano: $res")
                        }
                    }
                } catch (e: Exception) {
                    println("Erro ao inseririr valores.")
                }
            } else {
                println("Operacao impossivel de se realizar")
            }
        } else if(decisao == "sair" || decisao == "Sair"){
            println("Programa terminado")
        }
        else{
            println("Decisao  de operacao invalida")
        }
    }
}