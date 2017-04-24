package mx.gob.jovenes.guanajuato.utils;

import android.view.MotionEvent;
import android.view.View;

import java.util.function.Function;

/**
 * Created by Uriel on 24/04/2017.
 */

public class SlideHandler {
    private View view;
    private float startPointX;
    private float startPointY;
    private int actionType;
    private static final int ACTION_TYPE_DEFAULT = 0;
    private static final int ACTION_TYPE_UP = 1;
    private static final int ACTION_TYPE_RIGHT = 2;
    private static final int ACTION_TYPE_DOWN = 3;
    private static final int ACTION_TYPE_LEFT = 4;
    private static final int SLIDE_RANGE = 100;

    public SlideHandler(View view, Function f) {
        this.view = view;
        view.onTouchEvent(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startPointX = event.getRawX();
                        startPointY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (startPointX - x > SLIDE_RANGE) {
                            actionType = ACTION_TYPE_LEFT;
                        } else if (x - startPointX > SLIDE_RANGE) {
                            actionType = ACTION_TYPE_RIGHT;
                        } else if (startPointY - y > SLIDE_RANGE) {
                            actionType = ACTION_TYPE_UP;
                        } else if (y - startPointY > SLIDE_RANGE) {
                            actionType = ACTION_TYPE_DOWN;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (actionType == ACTION_TYPE_UP) {
                            f.
                        } else if (actionType == ACTION_TYPE_RIGHT) {
                            slideToRight();
                        } else if (actionType == ACTION_TYPE_DOWN) {
                            slideDown();
                        } else if (actionType == ACTION_TYPE_LEFT) {
                            slideToLeft();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        })
    }
}