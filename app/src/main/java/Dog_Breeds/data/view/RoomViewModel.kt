package Dog_Breeds.data.view

import android.app.Application
import androidx.room.Room
import Dog_Breeds.data.database.BreedDatabase

class RoomViewModel : Application() {

    companion object {
        var database: BreedDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, BreedDatabase::class.java, "breed_db").fallbackToDestructiveMigration().build()
    }
}