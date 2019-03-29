package android.paging.library.bug.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface IDao<in Model> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg model: Model)

    @Update
    fun update(vararg model: Model)

    @Delete
    fun delete(vararg model: Model)
}