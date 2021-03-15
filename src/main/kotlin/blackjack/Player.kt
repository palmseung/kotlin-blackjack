package blackjack

data class Player(val name: String) {
    private var _cards = mutableListOf<Card>()

    var cards: List<Card> = listOf()
        get() = _cards

    fun add(card: Card): List<Card> {
        _cards.add(card)
        return cards
    }

    fun isFirstCard(): Boolean {
        return _cards.size == ZERO
    }

    fun playOneTime(card: Card): Player {
        _cards.add(card)
        return this
    }

    companion object {
        private const val ZERO = 0
    }
}
