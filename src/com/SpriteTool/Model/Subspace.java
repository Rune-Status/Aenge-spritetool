package com.SpriteTool.Model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Subspace {

    private Path path;
    private List<Entry> entryList = new ArrayList<Entry>();

    public Subspace(Path path) {
        this.path = path;
    }

    public Path getPath() { return this.path; }
    public String getName() { return this.path.getFileName().toString(); }
    public List<Entry> getEntryList() { return entryList; }
}
