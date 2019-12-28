package com.hxiloj.service.impl

import com.hxiloj.model.User
import com.hxiloj.repository.UserRepository
import com.hxiloj.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service("userService")
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getAllUsers(): List<User> {
        return   userRepository.findAll()
    }

    override fun createNewUser(user: User): User {
        return userRepository.save(user)
    }

    override fun getUserById(userId: Long): ResponseEntity<User> {
        return userRepository.findById(userId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun updateUserById(userId: Long, newUser: User): ResponseEntity<User> {
        return userRepository.findById(userId).map { existingUser ->
            val updatedUser: User = existingUser
                    .copy(
                            created = Timestamp(System.currentTimeMillis()),
                            username = newUser.username,
                            password = newUser.password
                    )
            ResponseEntity.ok().body(userRepository.save(updatedUser))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun deleteUserById(userId: Long): ResponseEntity<Void> {
        return userRepository.findById(userId).map { user  ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}