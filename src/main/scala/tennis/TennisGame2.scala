package tennis

class TennisGame2(val player1Name: String, val player2Name: String)
    extends TennisGame {

  private var playerOnePoints = 0
  private var playerTwoPoints = 0

  def calculateScore(): String = {
    var playerOneResult = ""
    var playerTwoResult = ""
    var score = ""
    if (playerOnePoints == playerTwoPoints && playerOnePoints < 4) {
      if (playerOnePoints == 0)
        score = "Love"
      if (playerOnePoints == 1)
        score = "Fifteen"
      if (playerOnePoints == 2)
        score = "Thirty"
      score += "-All"
    }
    if (playerOnePoints == playerTwoPoints && playerOnePoints >= 3)
      score = "Deuce"

    if (playerOnePoints > 0 && playerTwoPoints == 0) {
      if (playerOnePoints == 1)
        playerOneResult = "Fifteen"
      if (playerOnePoints == 2)
        playerOneResult = "Thirty"
      if (playerOnePoints == 3)
        playerOneResult = "Forty"

      playerTwoResult = "Love"
      score = playerOneResult + "-" + playerTwoResult
    }
    if (playerTwoPoints > 0 && playerOnePoints == 0) {
      if (playerTwoPoints == 1)
        playerTwoResult = "Fifteen"
      if (playerTwoPoints == 2)
        playerTwoResult = "Thirty"
      if (playerTwoPoints == 3)
        playerTwoResult = "Forty"

      playerOneResult = "Love"
      score = playerOneResult + "-" + playerTwoResult
    }

    if (playerOnePoints > playerTwoPoints && playerOnePoints < 4) {
      if (playerOnePoints == 2)
        playerOneResult = "Thirty"
      if (playerOnePoints == 3)
        playerOneResult = "Forty"
      if (playerTwoPoints == 1)
        playerTwoResult = "Fifteen"
      if (playerTwoPoints == 2)
        playerTwoResult = "Thirty"
      score = playerOneResult + "-" + playerTwoResult
    }
    if (playerTwoPoints > playerOnePoints && playerTwoPoints < 4) {
      if (playerTwoPoints == 2)
        playerTwoResult = "Thirty"
      if (playerTwoPoints == 3)
        playerTwoResult = "Forty"
      if (playerOnePoints == 1)
        playerOneResult = "Fifteen"
      if (playerOnePoints == 2)
        playerOneResult = "Thirty"
      score = playerOneResult + "-" + playerTwoResult
    }

    if (playerOnePoints > playerTwoPoints && playerTwoPoints >= 3) {
      score = "Advantage player1"
    }

    if (playerTwoPoints > playerOnePoints && playerOnePoints >= 3) {
      score = "Advantage player2"
    }

    if (playerOnePoints >= 4 && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= 2) {
      score = "Win for player1"
    }
    if (playerTwoPoints >= 4 && playerOnePoints >= 0 && (playerTwoPoints - playerOnePoints) >= 2) {
      score = "Win for player2"
    }
    score
  }

  def wonPoint(player: String): Unit = {
    if (player == "player1")
      addPointForPlayerOne()
    else
      addPointForPlayerTwo()
  }

  private def addPointForPlayerTwo(): Unit = {
    playerTwoPoints += 1
  }

  private def addPointForPlayerOne(): Unit = {
    playerOnePoints += 1
  }
}
