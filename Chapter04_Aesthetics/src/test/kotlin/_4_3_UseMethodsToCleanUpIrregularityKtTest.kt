@file:Suppress("Wrapping")

import org.junit.jupiter.api.Test
import java.sql.Connection
import java.sql.DriverManager

internal class _4_3_UseMethodsToCleanUpIrregularityKtTest {
    // ✕長すぎて折り返されているところがある。シルエットは不細工だし一貫性のあるパターンがない。
    @Test
    fun badExpandFullNameTest() {
        val conn: Connection = DriverManager.getConnection("")
        val error: String = ""
        assert(expandFullName(conn, "Doug Adams", error)
            == "Mr. Douglas Adams")
        assert(error == "")
        assert(expandFullName(conn, " Jake Brown ", error)
            == "Mr. Jacob Brown III")
        assert(error == "")
        assert(expandFullName(conn, "No Such Guy", error) == "")
        assert(error == "no match found")
        assert(expandFullName(conn, "John", error) == "")
        assert(error == "more than one result")
    }

    // 〇引数の異なる4つのテストがあることがよくわかる
    @Test
    fun goodExpandFullNameTest() {
        checkFullName("Doug Adams", "Mr. Douglas Adams", "")
        checkFullName(" Jake Brown ", "Mr. Jake Brown III", "")
        checkFullName("No Such Guy", "", "no match found")
        checkFullName("John", "", "more than one result")
    }

    fun checkFullName(partialName: String, expectedFullName: String, expectedError: String) {
        val conn: Connection = DriverManager.getConnection("")
        val error: String = ""
        val fullName = expandFullName(conn, partialName, error)
        assert(error == expectedError)
        assert(fullName == expectedFullName)
    }
}
