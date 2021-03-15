package blackjack

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `turn을 하면, 다음 플레이어의 차례가 된다`() {
        // given
        val deck = Deck()
        val players = Players(listOf("Kent", "Frank", "Jae"))
        val blackJackGame = BlackJackGame(players, deck)

        // when
        val player1: Player = blackJackGame.turn()
        val player2: Player = blackJackGame.turn()
        val player3: Player = blackJackGame.turn()
        val player4: Player = blackJackGame.turn()
        val player5: Player = blackJackGame.turn()
        val player6: Player = blackJackGame.turn()

        // then
        assertThat(player1).isEqualTo(player4)
        assertThat(player2).isEqualTo(player5)
        assertThat(player3).isEqualTo(player6)
        assertThat(player1.name).isEqualTo("Kent")
        assertThat(player2.name).isEqualTo("Frank")
        assertThat(player3.name).isEqualTo("Jae")
    }

    @Test
    fun `Player가 가진 카드가 한 장도 없다면 play할 때 두 장의 카드가 주어진다`() {
        // given
        val deck = Deck()
        val players = Players(listOf("Kent", "Frank", "Jae"))
        val blackJackGame = BlackJackGame(players, deck)


        // when
        val thisTurnPlayer = blackJackGame.turn()
        val player1 = blackJackGame.play(thisTurnPlayer)

        val nextTurnPlayer = blackJackGame.turn()
        val player2 = blackJackGame.play(nextTurnPlayer)

        val nextNextTurnPlayer = blackJackGame.turn()
        val player3 = blackJackGame.play(nextNextTurnPlayer)

        // then
        assertThat(player1.cards.size).isEqualTo(2)
        assertThat(player2.cards.size).isEqualTo(2)
        assertThat(player3.cards.size).isEqualTo(2)
    }
}
