package com.pepcox.richtar.richtarjakub.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
class Beer(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo val name: String,@ColumnInfo val image: String, val detail: String) : Serializable
