package blackjack

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlayerTest {
    @Test
    fun `플레이어 이름을 인자로 주면, 플레이어가 생성된다`() {
        // given
        val name = "Steven"

        // when, then
        assertThatThrownBy { Pleyer(name) }.doesNotThrowAnyException()
    }
}
