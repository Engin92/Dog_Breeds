package Dog_Breeds.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import Dog_Breeds.data.network.response.CurrentBreedResponseItem


@Database(
    entities = [(CurrentBreedResponseItem::class)],
    version = 1
)
abstract class BreedDatabase : RoomDatabase() {
    abstract fun currentBreedDao(): CurrentBreedDao

}
