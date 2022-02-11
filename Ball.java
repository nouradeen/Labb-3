import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.w3c.dom.css.Rect;

import java.awt.Color;
import java.awt.Rectangle;
import java.lang.reflect.WildcardType;

public class Ball extends Sprite {
    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
    //private Bat bat;
    public BallState state;
    private Color color;
    //private Random random;
    //private List<BallState> states = Arrays.asList(BallState.TurningLeft, BallState.TurningRight, BallState.Falling, BallState.Jumping);
    public Ball(int x, int y, int width, int height, Color color){
        super(x, y, width, height);
        this.color = color;
        state = BallState.Idle;
    }
    @Override
    public void update(Keyboard keyboard) {
        //random = new Random();
        if(state == BallState.Idle){
            state = BallState.Jumping;
        }

        if(state == BallState.Jumping){
            setY(getY() - 5);
        } else if(state == BallState.Falling){
            setY(getY() + 5);
        } else if(state == BallState.TurningLeft){
            setX(getX() - 5);
        } else if(state == BallState.TurningRight){
            setX(getX() + 5);
        } else if(state == BallState.Dead){
            setX(WIDTH/2);
            setY(HEIGHT/2);
            System.out.println("You lost!!!!!!!");
            state = BallState.Idle;
        }

        if(state == BallState.Jumping && getY() == 0){
            state = BallState.Falling;
        }

        if(state == BallState.Falling && getY() >= HEIGHT - getHeight()){
            state = BallState.Jumping;
        }

        if(state == BallState.TurningLeft && getX() == 0){
            state = BallState.TurningRight;
        }

        if(state == BallState.TurningRight && getX() >= WIDTH - getWidth()){
            state = BallState.TurningLeft;
        }
    
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(color);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public boolean BatCollision(Bat bat){
        Rectangle ballRec = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle batRec = new Rectangle(bat.getX(), bat.getY(), bat.getWidth(), bat.getHeight());
        return ballRec.intersects(batRec);
    }

    public boolean BrickCollision(Bricks brick){
        Rectangle ballRec = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle brickRec = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        return ballRec.intersects(brickRec);
    }
    
}


//testing