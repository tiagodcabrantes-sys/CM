package cm.virtual_library

abstract class Book(
    val title:String,
    val author:String,
    val publicationYear:Int,
    availableCopies:Int
) {
    var availableCopies: Int = availableCopies
        set(valor){

            if (valor < 0) {
                println("As copias disponiveis nao podem ser negativas.")
                return
            } else {
                field = valor
                if (field == 0) {
                    println("Aviso:O livro esta fora de stock")
                }
            }
        }
    val era:String
        get(){
            if(publicationYear < 1980){
                return "Classico"
            }
            else if(publicationYear <= 2010){
                return "Moderno"
            }
            else{
                return "Contemporaneo"
            }
        }
    init{
        println("O livro $title escrito pelo autor $author foi criado")
    }
    abstract fun getStorageInfo():String

    override fun toString():String{
        return "Titulo: $title, Autor: $author, Era: $era, Disponibilidade: $availableCopies"
    }
}

class DigitalBook(
    title:String,
    author:String,
    publicationYear: Int,
    availableCopies:Int,
    val fileSize:Double,
    val format:String
) : Book(title, author, publicationYear, availableCopies) {
    override fun getStorageInfo(): String {
        return "Guardado digitalmente. Tamanho do ficheiro: $fileSize MB, Formato: $format"
    }
    override fun toString(): String{
        return super.toString() + "\nArmazenamento: " + getStorageInfo()
    }
}

class PhysicalBook(
    title:String,
    author:String,
    publicationYear: Int,
    availableCopies:Int,
    val weight:Int,
    val hasHardcover:Boolean
) : Book(title, author, publicationYear, availableCopies) {

    override fun getStorageInfo() :String{
        if(hasHardcover){
            return "Livro fisico: $weight g, Hardcover: Sim"
        }
        else{
            return "Livro fisico: $weight g, Hardcover: Nao"
        }
    }
    override fun toString(): String{
        return super.toString() + "\nArmazenamento: " + getStorageInfo()
    }
}

class Library(val name: String){
    val books = mutableListOf<Book>()

    companion object{
        var totalBooksCreated = 0

        fun getTotalBooksCreated(): Int {
            return totalBooksCreated
        }
    }

    fun addBook(book: Book){
        books.add(book)
        totalBooksCreated++

        println("Livro: ${book.title} escrito pelo autor ${book.author} foi adicionado a livraria")
    }

    fun showBooks(){
        println("Livros na livraria: ")
        for(book in books){
            println("Titulo: ${book.title}, Autor: ${book.author}, Era: ${book.era}, Disponibilidade: ${book.availableCopies}")

            println("Armazenamento: " +book.getStorageInfo())

        }
    }

    fun borrowBook(title:String){
        for(book in books){
            if(book.title == title){
                if(book.availableCopies > 0){
                    book.availableCopies--

                    println("O livro $title foi emprestado com sucesso.Numero de copias restantes: ${book.availableCopies}")
                }
                else{
                    println("Nao ha copias disponiveis")
                }
                return
            }
        }
        println("Livro nao encontrado")
    }

    fun returnBook(title:String){
        for(book in books){
            if(book.title == title){
                book.availableCopies++
                println("O livro $title, foi devolvido.Numero de copias restantes: ${book.availableCopies}")
                return
            }
        }
        println("Livro nao encontrado")
    }

    fun searchByAuthor(author:String){
        println("Livros escritos pelo autor $author: ")

        for(book in books){
            if(book.author == author){
                println(" ${book.title}(${book.era} , ${book.availableCopies} copias disponiveis)")
            }
        }
    }

}

data class LibraryMember(
    val name: String,
    val membershipId: Int,
    val borrowedBooks: MutableList<String>
)

fun main(){
    val library = Library("Central Library")

    val digitalBook = DigitalBook(
        "Kotlin in Action",
        "Dmitry Jeremov",
        2017,
        5,
        4.5,
        "PDF"
    )

    val physicalBook = PhysicalBook(
        "Clean Code",
        "Robert C. Martin",
        2008,
        3,
        650,
        true
    )

    val classicalBook = PhysicalBook(
        "1984",
        "George Orwell",
        1949,
        2,
        400,
        false
    )

    library.addBook(digitalBook)
    library.addBook(physicalBook)
    library.addBook(classicalBook)

    library.showBooks()

    println("Requesicao de Livros:")
    library.borrowBook("Clean Code")
    library.borrowBook("1984")
    library.borrowBook("1984")
    library.borrowBook("1984")

    println("Devolucao do Livro:")
    library.returnBook("1984")

    println("Pesquisar pelo o Autor:")
    library.searchByAuthor("George Orwell")

    println("\nTotal de livros adicionados: ${Library.getTotalBooksCreated()}")
}

