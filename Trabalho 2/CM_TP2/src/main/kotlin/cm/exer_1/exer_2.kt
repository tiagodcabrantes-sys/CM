package cm.exer_1

class Cache<K : Any, V : Any>{
    private val entries : MutableMap<K, V> = mutableMapOf()

    fun put(key : K, value : V){
        entries[key] = value
    }

    fun get(key : K) : V?{
        return entries[key]
    }

    fun evict(key : K){
        entries.remove(key)
    }

    fun size() : Int{
        return entries.size
    }

    fun getOrPut(key : K, default: () -> V): V{
        val existingValue = entries[key]

        if(existingValue != null){
            return existingValue
        }

        val newValue = default()
        entries[key] = newValue
        return newValue
    }

    fun transform(key : K, action : (V) -> V) : Boolean {
        val currentValue = entries[key]

        if(currentValue != null){
            val updateValue = action(currentValue)
            entries[key] = updateValue
            return true
        }

        return false
    }

    fun snapshot() : Map<K,V>{
        return entries.toMap()
    }

}

fun main(){
    val wordCache = Cache<String, Int>()

    wordCache.put("kotlin", 1)
    wordCache.put("scala", 1)
    wordCache.put("haskell", 1)

    println("--- Word frequency cache ---")
    println("Size: ${wordCache.size()}")
    println("Frequency of \"kotlin\": ${wordCache.get("kotlin")}")
    println("getOrPut \"kotlin\": ${wordCache.getOrPut("kotlin") { 0 }}")
    println("getOrPut \"java\": ${wordCache.getOrPut("java") { 0 }}")
    println("Size after getOrPut: ${wordCache.size()}")
    println("Transform \"kotlin\" (+1): ${wordCache.transform("kotlin") { value -> value + 1 }}")
    println("Transform \"cobol\" (+1): ${wordCache.transform("cobol") { value -> value + 1 }}")
    println("Snapshot: ${wordCache.snapshot()}")

    val idCache = Cache<Int, String>()

    idCache.put(1, "Alice")
    idCache.put(2, "Bob")

    println("--- Id registry cache ---")
    println("Id 1 -> ${idCache.get(1)}")
    println("Id 2 -> ${idCache.get(2)}")
    idCache.evict(1)
    println("After evict id 1, size: ${idCache.size()}")
    println("Id 1 after evict -> ${idCache.get(1)}")
}

