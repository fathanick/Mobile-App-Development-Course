fun main() {
    val favoriteContacts = mutableSetOf("Ali", "Budi", "Citra")

    favoriteContacts.add("Dewi")
    favoriteContacts.add("Ali")   // duplicate, ignored

    favoriteContacts.remove("Budi")

    println("Final favorite contacts: $favoriteContacts")
}
