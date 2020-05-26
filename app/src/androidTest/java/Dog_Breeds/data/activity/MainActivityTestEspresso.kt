package Dog_Breeds.data.activity

import Dog_Breeds.data.R
import Dog_Breeds.data.ToastMatcher
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTestEspresso(){

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val array = arrayOf(                    // The same list of Dog breeds, as in the jsonfile breeds.json
        "Affenpinscher", "Afghan Hound", "African Hunting Dog", "Airedale Terrier", "Akbash Dog", "Akita", "Alapaha Blue Blood Bulldog", "Alaskan Husky", "Alaskan Malamute", "American Bulldog", "American Bully",
        "American Eskimo Dog", "American Eskimo Dog (Miniature)", "American Foxhound", "American Pit Bull Terrier", "American Staffordshire Terrier", "American Water Spaniel", "Anatolian Shepherd Dog",
        "Appenzeller Sennenhund", "Australian Cattle Dog", "Australian Kelpie", "Australian Shepherd", "Australian Terrier", "Azawakh", "Barbet", "Basenji", "Basset Bleu de Gascogne", "Basset Hound", "Beagle",
        "Bearded Collie", "Beauceron", "Bedlington Terrier", "Belgian Malinois", "Belgian Tervuren", "Bernese Mountain Dog", "Bichon Frise", "Black and Tan Coonhound", "Bloodhound", "Bluetick Coonhound", "Boerboel",
        "Border Collie", "Border Terrier", "Boston Terrier", "Bouvier des Flandres", "Boxer", "Boykin Spaniel", "Bracco Italiano", "Briard", "Brittany", "Bull Terrier", "Bull Terrier (Miniature)", "Bullmastiff",
        "Cairn Terrier", "Cane Corso", "Cardigan Welsh Corgi", "Catahoula Leopard Dog", "Caucasian Shepherd (Ovcharka)", "Cavalier King Charles Spaniel", "Chesapeake Bay Retriever", "Chinese Crested",
        "Chinese Shar-Pei", "Chinook", "Chow Chow", "Clumber Spaniel", "Cocker Spaniel", "Cocker Spaniel (American)", "Coton de Tulear", "Dalmatian", "Doberman Pinscher", "Dogo Argentino", "Dutch Shepherd",
        "English Setter", "English Shepherd", "English Springer Spaniel", "English Toy Spaniel", "English Toy Terrier", "Eurasier", "Field Spaniel", "Finnish Lapphund", "Finnish Spitz", "French Bulldog",
        "German Pinscher", "German Shepherd Dog", "German Shorthaired Pointer", "Giant Schnauzer", "Glen of Imaal Terrier", "Golden Retriever", "Gordon Setter", "Great Dane", "Great Pyrenees", "Greyhound",
        "Griffon Bruxellois", "Harrier", "Havanese", "Irish Setter", "Irish Terrier", "Irish Wolfhound", "Italian Greyhound", "Japanese Chin", "Japanese Spitz", "Keeshond", "Komondor", "Kooikerhondje", "Kuvasz",
        "Labrador Retriever", "Lagotto Romagnolo", "Lancashire Heeler", "Leonberger", "Lhasa Apso", "Maltese", "Miniature American Shepherd", "Miniature Pinscher", "Miniature Schnauzer", "Newfoundland",
        "Norfolk Terrier", "Norwich Terrier", "Nova Scotia Duck Tolling Retriever", "Old English Sheepdog", "Olde English Bulldogge", "Papillon", "Pekingese", "Pembroke Welsh Corgi", "Perro de Presa Canario",
        "Pharaoh Hound", "Plott", "Pomeranian", "Poodle (Miniature)", "Poodle (Toy)", "Pug", "Puli", "Pumi", "Rat Terrier", "Redbone Coonhound", "Rhodesian Ridgeback", "Rottweiler", "Russian Toy", "Saint Bernard",
        "Saluki", "Samoyed", "Schipperke", "Scottish Deerhound", "Scottish Terrier", "Shetland Sheepdog", "Shiba Inu", "Shih Tzu", "Shiloh Shepherd", "Siberian Husky", "Silky Terrier", "Smooth Fox Terrier",
        "Soft Coated Wheaten Terrier", "Spanish Water Dog", "Spinone Italiano", "Staffordshire Bull Terrier", "Standard Schnauzer", "Swedish Vallhund", "Thai Ridgeback", "Tibetan Mastiff", "Tibetan Spaniel",
        "Tibetan Terrier", "Toy Fox Terrier", "Treeing Walker Coonhound", "Vizsla", "Weimaraner", "Welsh Springer Spaniel", "West Highland White Terrier", "Whippet", "White Shepherd", "Wire Fox Terrier",
        "Wirehaired Pointing Griffon", "Wirehaired Vizsla", "Xoloitzcuintli", "Yorkshire Terrier"
    )

    val CACHECLEARED = "Cache Cleared!"


    @Test
    fun test_IsActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_layout_listView_button() {
        onView(withId(R.id.layoutMain)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_list_view)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_cacheClearedToast() {      // test the Toast Message which appears after clicking on the button
        onView(withId(R.id.button)).perform(click())
        onView(withText(CACHECLEARED))
            .inRoot((ToastMatcher()))
            .check(matches(isDisplayed()))
    }

    // <------------------------- Activity Navigation ------------------------------------>

    @Test
    fun test_navToDetailedActivity() {
        clickOnRandomListItem()
        checkBreedData()
    }

    fun checkBreedData() {          // testing if Layout and all textviews in breed_layout.xml are displayed after navigation
        onView(withId(R.id.breed_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_id)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_name)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_bred_for)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_life_span)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_temperament)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_height)).check(matches(isDisplayed()))
        onView(withId(R.id.breed_weight)).check(matches(isDisplayed()))
    }

    fun clickOnRandomListItem(){    //clicking on one of the items in the list, to navigate to the second activity
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`(array.random())
            )
        ).inAdapterView(withId(R.id.breed_list_view)).perform(click())

        onView(withId(R.id.detailed)).check(matches(isDisplayed()))
    }

    @Test
    fun test_backPressToMainActivity() {
        clickOnRandomListItem()
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    // <------------------------- ListView Tests ------------------------------------>

    @Test
    fun test_ListView () {

        lastItemNotDisplayed() // last Item in the list is not displayed until scrolled down

        for (i in array) {
            clickOnItemWithTextEqualToString(i) //clicks on all items in the ListView, also checks if the items exist, also scrolls down while clicking all items
        }
    }

    @Test
    fun lastItemNotDisplayed(){
        onView(withText("Yorkshire Terrier")).check(doesNotExist())
    }


    fun clickOnItemWithTextEqualToString(name : String) {
        ActivityScenario.launch(MainActivity::class.java)
        onData(
            allOf(
                `is`(instanceOf(String::class.java)),
                `is`(name)
            )
        ).inAdapterView(withId(R.id.breed_list_view)).perform(click())
    }
}