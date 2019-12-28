package com.hxiloj.controller

import com.hxiloj.model.User
import com.hxiloj.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/ws")
class UserController (private val userService: UserService){

    @GetMapping("/users")
    fun getAllUsers(): List<User> = userService.getAllUsers()

    @PostMapping("/users")
    fun createNewUser(@Valid @RequestBody user: User): User =
            userService.createNewUser(user)

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<User> {
        return userService.getUserById(userId)
    }

    @PutMapping("/users/{id}")
    fun updateUserById(@PathVariable(value = "id") userId: Long,
                          @Valid @RequestBody newUser: User): ResponseEntity<User> {
        return userService.updateUserById(userId, newUser)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Void> {
        return userService.deleteUserById(userId)
    }
}