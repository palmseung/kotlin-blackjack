package blackjack

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class PlayerTest {
    @Test
    fun `플레이어 이름을 인자로 주면, 플레이어가 생성된다`() {
        // given
        val name = "Steven"

        // when, then
        assertDoesNotThrow { Player(name) }
    }
}
