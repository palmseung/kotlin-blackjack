package blackjack

class BlackJackGame(val players: Players, val deck: Deck) {
    fun turn(): Player {
        return players.turn()
    }

    fun play(thisTurnPlayer: Player): Player {
        if (thisTurnPlayer.isFirstCard()) {
            thisTurnPlayer.playOneTime(getCard())
            return thisTurnPlayer.playOneTime(getCard())
        }

        return thisTurnPlayer.playOneTime(getCard())
    }

    private fun getCard(): Card {
        return deck.getCard()
    }
}
