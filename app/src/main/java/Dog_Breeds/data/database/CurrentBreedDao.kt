package Dog_Breeds.data.database

import androidx.lifecycle.LiveData
import Dog_Breeds.data.network.response.CurrentBreedResponseItem
import androidx.room.*

@Dao
interface CurrentBreedDao {

    @Query("SELECT * FROM breeds")
    fun getAllBreeds() : LiveData<List<CurrentBreedResponseItem>>

    @Query("SELECT * FROM breeds WHERE name IN (:name)")
    fun getBreedByName(name: String): LiveData<List<CurrentBreedResponseItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBreeds(breedList: List<CurrentBreedResponseItem>)

    @Query("DELETE FROM breeds")
    fun deleteAllBreeds()

}