import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class Main extends JFrame {
    Main(){
        setTitle("File Tree Viewer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = createTreeNode(new File("/Users/klirik/Documents"));
        JTree tree = new JTree(new DefaultTreeModel(root));

        add(tree);
    }

    private DefaultMutableTreeNode createTreeNode(File file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                node.add(createTreeNode(child));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        JFrame ui = new Main();
        ui.setVisible(true);
    }
}
