package Dog_Breeds.data.network.response

import junit.framework.Assert.assertEquals
import org.junit.Test

internal class HeightTest {

    val HEIGHT = Height(imperial = "9 - 11.5", metric = "22.86 - 29.21")

    var heightImperialList = HEIGHT.imperial?.split("-")
    var heightMetricList = HEIGHT.metric?.split("-")

    var imperialHeightMin = heightImperialList?.get(0)?.toDouble()
    var imperialHeightMax = heightImperialList?.get(1)?.toDouble()

    var metricHeightMin = heightMetricList?.get(0)?.toDouble()
    var metricHeightMax = heightMetricList?.get(1)?.toDouble()


    @Test
    fun test_convertAndCheckAllHeights() {
        InchesToCentimeterConverter(imperialHeightMin, metricHeightMin)
        InchesToCentimeterConverter(imperialHeightMax, metricHeightMax)
        println("success!")
    }

    fun InchesToCentimeterConverter(imperial: Double?, metric: Double?) {
        var imperialInMetric = (imperial?.times(2.54))
        assertEquals(imperialInMetric, metric)
    }
}