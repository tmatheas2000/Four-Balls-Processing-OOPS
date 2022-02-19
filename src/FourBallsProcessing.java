import processing.core.PApplet;

public class FourBallsProcessing extends PApplet
{
    final int HEIGHT = 480;
    final int WIDTH = 640;
    int height=HEIGHT/5;
    final int DIAMETER = 10;
    int totalBalls=4;
    int speeds[];

    public int[] getSpeeds() {
        return speeds;
    }

    public void setSpeeds(int speed) {
        this.speeds[speed-1] +=(speed*1);
    }

    @Override
    public void settings()
    {
        size(WIDTH, HEIGHT);
        initializeBalls();
    }

    void initializeBalls()
    {
        this.speeds = new int[totalBalls];
        for(int speed=1;speed<=totalBalls;speed++)
        {
            speeds[speed-1]=speed*2;
        }
    }


    @Override
    public void draw()
    {
        for(int speed=1;speed<=totalBalls;speed++)
        {
            moveBall(speed);
        }
    }

    void moveBall(int speed)
    {
        ellipse(getBallPosition(speed), getBallHeightFromTop(speed), DIAMETER, DIAMETER);
        setNextPositionOfBall(speed);
    }

    int getBallHeightFromTop(int speed)
    {
        return height*speed;
    }

    int getBallPosition(int ballNo)
    {
        return this.getSpeeds()[ballNo-1];
    }
    void setNextPositionOfBall(int speed)
    {
        this.setSpeeds(speed);
    }

    public static void main(String[] args)
    {
        PApplet.main("FourBallsProcessing",args);
    }
}