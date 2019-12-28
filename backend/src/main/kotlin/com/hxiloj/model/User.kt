package com.hxiloj.model

import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="users")
data class User(

        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long  = 0,

        val created: Timestamp = Timestamp(System.currentTimeMillis()),
        
        @get: NotBlank
        val password: String = "",

        @get: NotBlank
        val username: String = ""

)
