package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import java.io.Serializable

@Entity
class Beer(@ColumnInfo val name: String,@ColumnInfo val image: String, val detail: String) : Serializable
