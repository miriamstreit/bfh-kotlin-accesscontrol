package acl.resource

class File(override var name : String, private val content : String) : Resource(name) {
    override fun getContent(): String {
        return content
    }
}