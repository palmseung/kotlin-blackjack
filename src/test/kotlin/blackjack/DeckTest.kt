package blackjack

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DeckTest {
    @Test
    fun `하나의 Deck을 생성하면 총 52장의 카드가 같이 생성된다`() {
        // when
        val deck = Deck()

        // then
        assertThat(deck.cards.size).isEqualTo(52)
    }
}
