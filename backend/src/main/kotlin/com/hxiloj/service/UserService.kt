package com.hxiloj.service

import com.hxiloj.model.User
import org.springframework.http.ResponseEntity

interface UserService {

    fun getAllUsers(): List<User>
    fun createNewUser(user: User): User
    fun getUserById(userId: Long): ResponseEntity<User>
    fun updateUserById(userId: Long, newUser : User): ResponseEntity<User>
    fun deleteUserById(userId: Long): ResponseEntity<Void>
}