# My Labb 3 project
## To-do List
- Create the second type of the Bricks, "bricks with 2 lives"
- Create the mechanism to make the ball reflect in more directions
- Place the bricks in good place
- Add a score to the game and it should be seen in the game while playing
- Add a lives to the game, a message should be seen
- After the lives is over, the game should show a "Game Over" message
- When all the bricks is hit, the game should pause and show the points
- The game should be playable
## Missing

## Testing
- Line `[27]    bricks.add(new Bricks(WIDTH_X/2 - 15, HEIGHT_Y/2, 30, 30, Color.gray));`
- Line `58 - 66 in Game.java`
```
for(Bricks e: bricks){
	if(ball.BrickCollision(e)){
		if(ball.state == BallState.Jumping){
			bricks.remove(e);
			ball.state = BallState.Falling;
		}else if(ball.state == BallState.Falling){
			ball.state = BallState.Jumping;
		}
}
```
## Not working

## Should be fixed
- The `Collesion` should be fixed to be able to reflect in all direction
## Errors