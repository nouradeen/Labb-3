import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.WildcardType;
import java.util.*;

public class Game {
	private static final int WIDTH_X = 800;
	private static final int HEIGHT_Y = 600;

	Ball ball;
	Bat bat;
	Bricks brick;

	public ArrayList<Bricks> bricks;

	//Random random = new Random();

	public Game(GameBoard board) {
		ball = new Ball(WIDTH_X/2 - 15, HEIGHT_Y - 40, 30, 30, Color.red);
		bat = new Bat(WIDTH_X/2 - 150/2, HEIGHT_Y - 10, 150, 10, Color.gray);
		//brick = new Bricks(WIDTH_X/2 - 15, HEIGHT_Y/2, 30, 30, Color.white);
		bricks = new ArrayList<Bricks>();

		// // for(int i = 1; i <= 5; i++){
		// // 	int X = random.nextInt(78);
		// // 	int Y = random.nextInt(30);
		bricks.add(new Bricks(WIDTH_X/2 - 15, HEIGHT_Y/2, 30, 30, Color.gray));
		// //}
	}

	public void update(Keyboard keyboard) {
		if(ball.BatCollision(bat)){
			ball.state = BallState.Jumping;
		}else if(ball.getY() > HEIGHT_Y - 40 && ball.state == BallState.Falling){
			ball.state = BallState.Dead;

		}else{
			for(Bricks e: bricks){
				if(ball.BrickCollision(e)){
					if(ball.state == BallState.Jumping){
						ball.state = BallState.Falling;
						//bricks.remove(0);
					}else if(ball.state == BallState.Falling){
						ball.state = BallState.Jumping;
					}
			}
			
		} 
		
		


		}
		
		ball.update(keyboard);
		bat.update(keyboard);

		// if(ball.getY() > HEIGHT_Y - 10){
		// 	ball.setX(WIDTH_X/2);
		// 	ball.setY(HEIGHT_Y/2);
		// }
	}

	public void draw(Graphics2D graphics) {
		ball.draw(graphics);
		bat.draw(graphics);
		for(Bricks e: bricks){
			e.draw(graphics);
		}
		
	}
}
