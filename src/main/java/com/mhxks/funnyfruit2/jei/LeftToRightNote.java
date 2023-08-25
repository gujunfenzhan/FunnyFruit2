package com.mhxks.funnyfruit2.jei;

import mezz.jei.api.gui.ITickTimer;

public class LeftToRightNote
implements ITickTimer {
    private int vaule = 0;
    private final int maxVaule;
    private boolean state = true;
    public LeftToRightNote(int maxVaule) {
        this.maxVaule = maxVaule;
    }
    @Override
    public int getMaxValue() {
        return maxVaule;
    }

    @Override
    public int getValue() {
        if(state)
            vaule++;
        else vaule--;

        if(vaule>=maxVaule) {
            state = false;
        }
        if(vaule<=0) {
            state = true;
        }
        return vaule;
    }
}
