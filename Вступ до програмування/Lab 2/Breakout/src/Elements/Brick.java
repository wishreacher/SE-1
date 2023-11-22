package Elements;

import acm.graphics.GRect;

public class Brick extends GRect {

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setFilled(true);
    }
    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    private boolean isHit = false;
}
