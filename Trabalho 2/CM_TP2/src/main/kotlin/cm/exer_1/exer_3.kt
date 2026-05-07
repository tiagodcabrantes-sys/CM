package cm.exer_1

class Pipeline{
    private val stageNames = mutableListOf<String>()
    private val stageTransforms = mutableListOf<(List<String>) -> List<String>>()

    fun addStage(name : String, transform: (List<String>) -> List<String>) {
        stageNames.add(name)
        stageTransforms.add(transform)
    }

    fun execute(input: List<String>) : List<String> {
        var result = input

        for(transform in stageTransforms) {
            result = transform(result)
        }

        return result
    }

    fun describe(){
        println("Pipeline Stages:")
        var index = 1

        for (name in stageNames){
            println("$index. $name")
            index++
        }
    }
}

fun buildPipeline(block: Pipeline.() -> Unit): Pipeline {
    val pipeline = Pipeline()
    pipeline.block()
    return pipeline
}

fun main() {

    val logs = listOf(
        " INFO : server started ",
        " ERROR : disk full ",
        " DEBUG : checking config ",
        " ERROR : out of memory ",
        " INFO : request received ",
        " ERROR : connection timeout "
    )

    val pipeline = buildPipeline {

        addStage("Trim") { list ->
            list.map { it.trim() }
        }

        addStage("Filter errors") { list ->
            list.filter { it.contains("ERROR") }
        }

        addStage("Uppercase") { list ->
            list.map { it.uppercase() }
        }

        addStage("Add index") { list ->
            val result = mutableListOf<String>()
            var index = 1

            for (line in list) {
                result.add("$index. $line")
                index++
            }

            result
        }
    }

    pipeline.describe()
    val result = pipeline.execute(logs)

    println("Result:")

    for (line in result) {
        println(line)
    }

}