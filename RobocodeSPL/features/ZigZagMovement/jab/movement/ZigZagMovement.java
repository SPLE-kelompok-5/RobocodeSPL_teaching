package jab.movement;

import jab.module.Module;
import jab.module.Movement;

/**
 * ZigZag movement - moves in a zigzag pattern to avoid bullets
 * 
 * @author jab
 */
public class ZigZagMovement extends Movement {

    private int direction = 1;
    private int moveCount = 0;
    private static final int MOVE_THRESHOLD = 15;

    public ZigZagMovement(Module bot) {
        super(bot);
    }

    @Override
    public void move() {
        if (moveCount >= MOVE_THRESHOLD || Math.abs(bot.getDistanceRemaining()) < 5) {
            direction *= -1;
            moveCount = 0;
            // Belok 90 derajat bergantian kiri-kanan = efek zigzag tajam
            bot.setTurnRight(90 * direction);
            bot.setAhead(100);
        }
        moveCount++;
    }

    @Override
    public void onHitWall() {
        direction *= -1;
        moveCount = 0;
        bot.setBack(50);
        bot.setTurnRight(90);
    }
}