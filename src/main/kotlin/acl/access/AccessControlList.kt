/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package acl.access

import acl.user.User

class AccessControlList {
    private var aceList : MutableList<AccessControlEntity> = mutableListOf()
    fun add(ace : AccessControlEntity) {
        aceList.add(ace)
    }
    fun getAccessRightFor(user : User) : AccessRight {
        val userAccessRights = aceList.filter { ace -> ace.getUser() == user }.map { ace -> ace.getAccessRight() }
        return when {
            userAccessRights.contains(AccessRight.DENIED) -> AccessRight.DENIED
            userAccessRights.contains(AccessRight.GRANTED) -> AccessRight.GRANTED
            else -> AccessRight.UNSPECIFIED
        }
    }
}
