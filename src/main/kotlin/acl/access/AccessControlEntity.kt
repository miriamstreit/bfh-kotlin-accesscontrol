package acl.access

import acl.user.User

class AccessControlEntity(private var user : User, private var accessRight: AccessRight) {
    fun getAccessRight() = accessRight
    fun getUser() = user
}