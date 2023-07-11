package com.example.myapp

import java.util.UUID

class TaskModel (
    var name: String,
    var desc: String,
    var id: UUID = UUID.randomUUID()
)
{

}