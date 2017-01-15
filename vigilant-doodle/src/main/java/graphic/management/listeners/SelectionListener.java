package graphic.management.listeners;

import logic.schemes.Scheme;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Listener for tree selection.
 */
public class SelectionListener implements TreeSelectionListener {
    private final JTree tree;
    private final JTextField nameText;
    private final JTextField descriptionText;
    private final JTextArea createdText;
    private final JTextArea deadlineText;
    private final JTextArea completedText;

    /**
     * Default constructor for listener.
     *
     * @param tree JTree
     * @param nameText JTextField
     * @param descriptionText JTextField
     * @param createdText JTextArea
     * @param deadlineText JTextArea
     * @param completedText JTextArea
     */
    public SelectionListener(JTree tree, JTextField nameText, JTextField descriptionText, JTextArea createdText, JTextArea deadlineText, JTextArea completedText) {
        this.tree = tree;
        this.nameText = nameText;
        this.descriptionText = descriptionText;
        this.createdText = createdText;
        this.deadlineText = deadlineText;
        this.completedText = completedText;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node != null && node.getUserObject() instanceof Scheme) {
                Scheme scheme = (Scheme) node.getUserObject();
                if (scheme.getName().isEmpty()) {
                    nameText.setText("");
                } else {
                    nameText.setText(scheme.getName());
                }
                if (scheme.getDescription() == null) {
                    descriptionText.setText("");
                } else {
                    descriptionText.setText(scheme.getDescription());
                }
                if (scheme.getStatus().getStartTime() == null) {
                    createdText.setText("");
                } else {
                    createdText.setText(scheme.getStatus().getStartTime().toString());
                }
                if (scheme.getStatus().getCompleted() == null) {
                    completedText.setText("");
                } else {
                    completedText.setText(scheme.getStatus().getCompleted().toString());
                }
                if (scheme.getStatus().getDeadline() == null) {
                    deadlineText.setText("");
                } else {
                    deadlineText.setText(scheme.getStatus().getDeadline().toString());
                }

            }
        }
    }
}
