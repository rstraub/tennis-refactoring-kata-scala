package tennis

class TennisGame3(val playerOneName: String, val playerTwoName: String)
    extends TennisGame {
  private val playerOne = new Player(playerOneName)
  private val playerTwo = new Player(playerTwoName)

  def calculateScore(): String = {
    if (playerOne.points < 4 && playerTwo.points < 4 && !(playerOne.points + playerTwo.points == 6)) {
      if (playerOne.points == playerTwo.points) playerOne.score + "-All"
      else playerOne.score + "-" + playerTwo.score
    } else {
      if (playerOne.points == playerTwo.points) "Deuce"
      else {
        val leader =
          if (playerOne.points > playerTwo.points) playerOneName
          else playerTwoName
        if ((playerOne.points - playerTwo.points) * (playerOne.points - playerTwo.points) == 1)
          "Advantage " + leader
        else "Win for " + leader
      }
    }
  }

  def wonPoint(playerName: String): Unit = {
    if (playerName == playerOneName)
      playerOne.wonPoint()
    else
      playerTwo.wonPoint()
  }

  private def toScore(points: Int): String = {
    val scores = Array("Love", "Fifteen", "Thirty", "Forty")
    scores(points)
  }
}

private class Player(val name: String) {
  private var _points = 0

  def score: String = {
    val scores = Array("Love", "Fifteen", "Thirty", "Forty")
    scores(points)
  }

  def points: Int = _points

  def wonPoint(): Unit = {
    _points += 1
  }
}
