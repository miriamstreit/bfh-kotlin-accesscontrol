package acl.resource

class Directory(override var name : String) : Resource(name) {
    private var resourcesList : MutableList<Resource> = mutableListOf()

    override fun getContent() : String {
        var content = ""
        resourcesList.forEach {
            content += "${it.name}\n"
        }
        return content
    }

    fun add(resource : Resource) {
        resourcesList.add(resource)
        resource.setParent(this)
    }
}