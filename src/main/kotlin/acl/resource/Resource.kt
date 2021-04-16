package acl.resource

import acl.access.AccessControlList
import acl.access.AccessRight
import acl.user.User

abstract class Resource(open var name : String) {
    var ACL : AccessControlList = AccessControlList()
    private var parent : Directory? = null
    abstract fun getContent() : String

    fun accessBy(user : User) : String {
        var accessRight = ACL.getAccessRightFor(user)
        var currentParent = parent
        while (accessRight == AccessRight.UNSPECIFIED && currentParent != null) {
            accessRight = currentParent.ACL.getAccessRightFor(user)
            currentParent = currentParent.getParent()
        }

        if (accessRight == AccessRight.GRANTED) {
            return getContent()
        }
        return "Exception: Access denied"
    }

    fun getParent() = parent
    fun setParent(newParent : Directory) {
        parent = newParent
    }
}