package android.paging.library.bug.model

import android.paging.library.bug.util.DBConstants
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = DBConstants.NEWS_TABLE
)
data class News(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DBConstants.ID_COLUMN)
    val id: Int = 0,
    @ColumnInfo(name = DBConstants.CREATED_AT_COLUMN)
    val createdAt: Date = Date(),
    @ColumnInfo(name = DBConstants.AVATAR_COLUMN)
    val avatar: String = "",
    @ColumnInfo(name = DBConstants.TITLE_COLUMN)
    val title: String = "",
    @ColumnInfo(name = DBConstants.BODY_COLUMN)
    val body: String = "",
    @ColumnInfo(name = DBConstants.IMAGE_URL_COLUMN)
    val imageUrl: String = ""
)