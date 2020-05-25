package Dog_Breeds.data.network.response

import junit.framework.Assert.*
import org.junit.Assert
import org.junit.Test

internal class CurrentBreedResponseItemTest {

    val NAME_1 = "Affenpinscher"
    val ID_1 = 1
    val BRED_FOR_1 = "Small rodent hunting, lapdog"
    val TEMPERAMENT_1 = "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving"
    val LIFE_SPAN_1 = "10 - 12 years"
    val HEIGHT_1 = Height(imperial = "9 - 11.5", metric = "23 - 29")
    val WEIGHT_1 = Weight(imperial = "6 - 13", metric = "3 - 6")

    val NAME_2 = "Afghan Hound"
    val ID_2 = 2
    val BRED_FOR_2 = "Coursing and hunting"
    val TEMPERAMENT_2 = "Aloof, Clownish, Dignified, Independent, Happy"
    val LIFE_SPAN_2 = "10 - 13 years"
    val HEIGHT_2 = Height(imperial = "25 - 27", metric = "64 - 69")
    val WEIGHT_2 = Weight(imperial = "50 - 60", metric = "23 - 27")

    @Test
    fun test_BreedResponseItemsAreEqual(){
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        assertEquals(breed1,breed2)
        println("both breeds are equal!")
    }

    @Test
    fun test_BreedNamesAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_2, TEMPERAMENT_1, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedIdsAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_2, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedBredForsAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_2, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedTemperamentsAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_2, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedLifeSpansAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_2, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedHeightsAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_2, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }

    @Test
    fun test_BreedWeightsAreDifferent() {
        var breed1 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_1)
        var breed2 = CurrentBreedResponseItem(BRED_FOR_1, HEIGHT_1, ID_1, LIFE_SPAN_1, NAME_1, TEMPERAMENT_1, WEIGHT_2)
        Assert.assertNotEquals(breed1,breed2)
        println("both breeds are as expected not equal!")
    }
}
