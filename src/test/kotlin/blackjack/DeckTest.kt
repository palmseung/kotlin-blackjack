package blackjack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class DeckTest {
    @Test
    fun `하나의 Deck을 생성하면 총 52장의 카드가 같이 생성된다`() {
        // when
        val deck = Deck()

        // then
        assertThat(deck.cards.size).isEqualTo(52)
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `하나의 Deck에는 4가지 문양의 카드가 각각 13장씩 생성된다`(cardSymbol: CardSymbol) {
        // given
        val deck = Deck()

        // when
        val cards = deck.cards.filter { it.symbol.equals(cardSymbol) }

        // then
        assertThat(cards.size).isEqualTo(13)
    }

    @Test
    fun `Deck에서 카드를 하나 꺼내면, 전체 카드 갯수에서 한 개가 줄어든다`() {
        // given
        val deck = Deck()
        val previousCardSize = deck.cards.size
        assertThat(previousCardSize).isEqualTo(52)

        // when
        deck.getCard()

        // then
        val currentCardSize = deck.cards.size
        assertThat(currentCardSize).isEqualTo(51)
    }

    companion object {
        @JvmStatic
        private fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(CardSymbol.DIAMOND),
                Arguments.of(CardSymbol.CLOVER),
                Arguments.of(CardSymbol.HEART),
                Arguments.of(CardSymbol.SPADE)
            )
        }
    }
}
