package blackjack

class Deck {
    private var _cards = mutableListOf<Card>()

    var cards: List<Card> = CARDS_CLOVER
        get() = _cards

    init {
        _cards = CARDS
    }

    companion object {
        private var CARDS_SPADE = CardNumber.values().map { Card(it, CardSymbol.SPADE) }.toMutableList()
        private var CARDS_HEART = CardNumber.values().map { Card(it, CardSymbol.HEART) }.toMutableList()
        private var CARDS_CLOVER = CardNumber.values().map { Card(it, CardSymbol.CLOVER) }.toMutableList()
        private var CARDS_DIAMOND = CardNumber.values().map { Card(it, CardSymbol.DIAMOND) }.toMutableList()
        private var CARDS = CARDS_CLOVER.add(CARDS_DIAMOND).add(CARDS_HEART).add(CARDS_SPADE).toMutableList()

        private fun MutableList<Card>.add(cards: List<Card>): MutableList<Card> {
            this.addAll(cards)
            return this
        }
    }
}
