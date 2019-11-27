module spritetool {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires fontawesomefx;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires org.apache.commons.io;
    requires java.desktop;
    requires javafx.swing;
    requires org.controlsfx.controls;
    opens com.OpenRSC.Render;
    opens com.OpenRSC.Model;
    opens com.OpenRSC.Model.Format;
    opens com.OpenRSC.Interface.PopMenu;
    opens com.OpenRSC.Interface.Splash;
    opens com.OpenRSC.Interface.SpriteTool;
    opens com.OpenRSC.Interface.CreateWorkspace;
    opens com.OpenRSC;
}