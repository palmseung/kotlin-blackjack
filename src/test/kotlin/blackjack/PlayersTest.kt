package blackjack

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class PlayersTest {
    @Test
    fun `문자열 이름 List를 주면 Players가 생성된다`() {
        // given
        val names = listOf("Steven", "Jae", "Tom")

        // when
        assertDoesNotThrow { Players(names) }
    }
}
