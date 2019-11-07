package com.SpriteTool.IO;

import com.SpriteTool.Model.Entry;
import com.SpriteTool.Model.Format.Info;
import com.SpriteTool.Model.Format.Sprite;
import com.SpriteTool.Model.Subspace;
import com.SpriteTool.Model.Workspace;
import javafx.scene.control.Alert;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WorkspaceReader {

    public Workspace loadWorkspace(Path path) {
        Workspace ws = new Workspace(path);

        File[] directories = new File(path.toUri()).listFiles(File::isDirectory);

        if (directories == null || directories.length == 0) {
            new Alert(Alert.AlertType.ERROR, "The chosen directory is not a valid workspace.").showAndWait();
            return null;
        }

        for (File dir : directories) {
            ws.getSubspaces().add(loadSubspace(dir.toPath()));
        }

        return ws;
    }

    public Subspace loadSubspace(Path path) {

        Subspace ss = new Subspace(path);

        File[] files = new File(ss.getPath().toUri()).listFiles(File::isFile);

        if (files == null) {
            return null;
        }

        //Pair .png files to their .info
        List<String> pngFiles = new ArrayList<String>();
        List<String> infoFiles = new ArrayList<String>();

        for (File file : files) {
            String[] fileName = splitFileName(file);
            if (fileName == null)
                continue;
            if (fileName[1].equalsIgnoreCase("png"))
                pngFiles.add(fileName[0]);
            else if (fileName[1].equalsIgnoreCase("info"))
                infoFiles.add(fileName[0]);
        }

        List<String> pairs = new ArrayList<String>();
        List<String> noPairs = new ArrayList<String>();

        for (String png : pngFiles) {
            if (infoFiles.contains(png))
                pairs.add(png);
            else
                noPairs.add(png);
        }

        if (noPairs.size() > 0) {
            System.out.print("Looks like a new png was added.");
        }

        //Generate entries
        for (String pair : pairs) {
            InfoReader reader = new InfoReader();
            File infoFile = new File(ss.getPath().toString(), pair + ".info");
            File pngFile = new File(ss.getPath().toString(), pair + ".png");
            if (!infoFile.exists()
                || !pngFile.exists()) {
                System.out.print("An expected file did not exist.");
                return null;
            }

            Info info = reader.read(infoFile);
            if (info.getType() == Entry.TYPE.SPRITE) {
                Sprite sprite = new Sprite(pngFile, info);
                ss.getEntryList().add(new Entry(sprite));
            }
        }

        return ss;
    }


    private static String[] splitFileName(File file) {
        String fileName = file.getName();
        String[] parts = fileName.split(Pattern.quote("."));
        if (parts.length == 2)
            return parts;

        return null;
    }


}
