package blackjack

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CardTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `카드는 번호(CardNumber)와 문양(CardSymbol)로 생성된다`(cardNumber: CardNumber, cardSymbol: CardSymbol) {
        // when, then
        assertDoesNotThrow { Card(cardNumber, cardSymbol) }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(CardNumber.ACE, CardSymbol.CLOVER),
                Arguments.of(CardNumber.FIVE, CardSymbol.DIAMOND),
                Arguments.of(CardNumber.KING, CardSymbol.HEART),
                Arguments.of(CardNumber.QUEEN, CardSymbol.SPADE)
            )
        }
    }
}
