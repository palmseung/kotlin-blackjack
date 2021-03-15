package blackjack

class Players(val names: List<String>) {
    private var _players = mutableListOf<Player>()

    var players: List<Player> = listOf()
        get() = _players

    init {
        _players = names.map { Player(it) }.toMutableList()
    }

    fun turn(): Player {
        val thisTurnPlayer = players[INDEX_ZERO]
        val lastIndex = _players.size
        _players = _players.subList(INDEX_ONE, lastIndex)
        _players.add(thisTurnPlayer)

        return thisTurnPlayer
    }

    companion object {
        private const val INDEX_ZERO = 0
        private const val INDEX_ONE = 1
    }
}
