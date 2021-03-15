package blackjack

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow


internal class BlackJackGameTest {
    @Test
    fun `블랙잭 게임은 Players와 Deck으로 생성된다`() {
        // given
        val deck = Deck()
        val players = Players(listOf("Kent", "Frank", "Jae"))

        // when, then
        assertDoesNotThrow { BlackJackGame(players, deck) }

    }
}