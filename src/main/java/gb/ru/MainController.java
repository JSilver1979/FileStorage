package gb.ru;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainController implements Initializable {
    @FXML
    private TreeView<String> leftPane;
    @FXML
     private TreeView<String> rightPane;

    private File userHomeDir;

    private Image pc = new Image(getClass().getResourceAsStream("/gb/ru/pc.png"));
    private Image folder = new Image(getClass().getResourceAsStream("/gb/ru/folder.png"));
    private Image file = new Image(getClass().getResourceAsStream("/gb/ru/file.png"));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userHomeDir = new File(System.getProperty("user.home"));
        leftPane.setRoot(getNodesForDirectory(userHomeDir));
        rightPane.setRoot(getNodesForDirectory(userHomeDir));
    }

    public TreeItem<String> getNodesForDirectory(File directory) {
        TreeItem<String> root = new TreeItem<String>(directory.getName(), new ImageView(pc));
        for(File f : directory.listFiles()) {
            if(f.isDirectory()) {
//                root.getChildren().add(getNodesForDirectory(f));
                root.getChildren().add(new TreeItem<String>(f.getName(), new ImageView(folder)));
            } else {
                root.getChildren().add(new TreeItem<String>(f.getName(), new ImageView(file)));
            }
        }
        return root;
    }

    @FXML
    public void CloseApp() {
        Platform.exit();
    }


}
