package blackjack

class BlackJackGame(val players: Players, val deck: Deck) {
    fun turn(): Player {
        return players.turn()
    }

    fun play(thisTurnPlayer: Player): Player {
        TODO("Not yet implemented")
    }
}
