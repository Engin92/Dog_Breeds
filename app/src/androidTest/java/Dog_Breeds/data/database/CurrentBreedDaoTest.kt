package Dog_Breeds.data.database

import Dog_Breeds.data.network.response.CurrentBreedResponseItem
import Dog_Breeds.data.network.response.Height
import Dog_Breeds.data.network.response.LiveDataTestUtil
import Dog_Breeds.data.network.response.Weight
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test


class CurrentBreedDaoTest : BreedDatabaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    val NAME_1 = "Affenpinscher"
    val ID_1 = 1
    val BRED_FOR_1 = "Small rodent hunting, lapdog"
    val TEMPERAMENT_1 = "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving"
    val LIFE_SPAN_1 = "10 - 12 years"
    val HEIGHT_1 = Height(imperial = "9 - 11.5", metric = "23 - 29")
    val WEIGHT_1 = Weight(imperial = "6 - 13", metric = "3 - 6")

    @Test
    @Throws(Exception::class)
    fun test_insertReadDeleteBreed() {
        var breed1 = CurrentBreedResponseItem(
            BRED_FOR_1,
            HEIGHT_1,
            ID_1,
            LIFE_SPAN_1,
            NAME_1,
            TEMPERAMENT_1,
            WEIGHT_1
        )

        // insert
        getBreedDao().insertBreed(breed1)

        // read
        val liveDataTestUtil = LiveDataTestUtil<List<CurrentBreedResponseItem>>()
        var insertedBreeds = liveDataTestUtil.getValue(getBreedDao().getAllBreeds())!!

        assertNotNull(insertedBreeds)
        assertEquals(breed1.name, insertedBreeds[0].name)
        assertEquals(breed1.id, insertedBreeds[0].id)
        assertEquals(breed1.bredFor, insertedBreeds[0].bredFor)
        assertEquals(breed1.temperament, insertedBreeds[0].temperament)
        assertEquals(breed1.lifeSpan, insertedBreeds[0].lifeSpan)
        assertEquals(breed1.height, insertedBreeds[0].height)
        assertEquals(breed1.weight, insertedBreeds[0].weight)

        // delete
        getBreedDao().deleteAllBreeds()

        // confirm the database is empty
        insertedBreeds = liveDataTestUtil.getValue(getBreedDao().getAllBreeds())!!
        assertEquals(0, insertedBreeds.size)
    }
}