import org.junit.jupiter.api.Test

internal class _4_4_UseColumnAlignmentWhenHelpfulKtTest {
    @Test
    fun goodExpandFullNameTest() {
        val re = _4_3_UseMethodsToCleanUpIrregularityKtTest()
        re.checkFullName("Doug Adams"  , "Mr. Douglas Adams" , "")
        re.checkFullName(" Jake Brown ", "Mr. Jake Brown III", "")
        re.checkFullName("No Such Guy" , ""                  , "no match found")
        re.checkFullName("John"        , ""                  , "more than one result")
    }
}