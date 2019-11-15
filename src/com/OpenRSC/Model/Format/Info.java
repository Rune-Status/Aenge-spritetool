package com.OpenRSC.Model.Format;

import com.OpenRSC.Model.Entry;

public class Info {
    private Entry.TYPE type;
    private String filename;
    private String id;
    private int frameCount;
    private int frame;
    private boolean useShift;
    private int offsetX;
    private int offsetY;
    private int boundwidth;
    private int boundheight;

    Info() {}

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (!Info.class.isAssignableFrom(o.getClass()))
            return false;

        Info info = (Info)o;

        if (!this.filename.equalsIgnoreCase(info.filename) ||
                this.type != info.type ||
                !this.id.equalsIgnoreCase(info.id) ||
                this.frameCount != info.frameCount ||
                this.frame != info.frame ||
                this.useShift != info.useShift ||
                this.offsetX != info.offsetX ||
                this.offsetY != info.offsetY ||
                this.boundwidth != info.boundwidth ||
                this.boundheight != info.boundheight)
            return false;


        return true;
    }
    public void setType(Entry.TYPE type) { this.type = type; }
    public Entry.TYPE getType() { return this.type; }
    public void setFileName(String name) { this.filename = name; }
    public String getFileName() { return this.filename; }
    public void setID(String id) { this.id = id; }
    public String getID() { return this.id; }
    public void setFrame(int frame) { this.frame = frame; }
    public int getFrame() { return this.frame; }
    public void setFrameCount(int framecount) { this.frameCount = framecount; }
    public int getFrameCount() { return this.frameCount; }
    public void setOffsetX(int value) { this.offsetX = value; }
    public int getOffsetX() { return this.offsetX; }
    public void setOffsetY(int value) { this.offsetY = value; }
    public int getOffsetY() { return this.offsetY; }
    public void setBoundWidth(int value) { this.boundwidth = value; }
    public int getBoundWidth() { return this.boundwidth; }
    public void setBoundHeight(int value) { this.boundheight = value; }
    public int getBoundHeight() { return this.boundheight; }
    public void setUseShift(boolean bool) { this.useShift = bool; }
    public Boolean getUseShift() { return this.useShift; }

    public Info clone() {
        Info info = new Info();
        if (this.getType() == Entry.TYPE.SPRITE)
            info.setType(Entry.TYPE.SPRITE);
        else
            info.setType(Entry.TYPE.ANIMATION);

        info.setFileName(this.getFileName());
        info.setID(this.getID());
        info.setFrame(this.getFrame());
        info.setFrameCount(this.getFrameCount());
        info.setOffsetX(this.getOffsetX());
        info.setOffsetY(this.getOffsetY());
        info.setBoundWidth(this.getBoundWidth());
        info.setBoundHeight(this.getBoundHeight());
        info.setUseShift(this.getUseShift());

        return info;
    }
}
