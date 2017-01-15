package graphic.management.listeners;

import logic.schemes.Scheme;
import org.mongodb.morphia.Datastore;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Button listener for update panel.
 */
public class UpdateButtonListener implements ActionListener {

    private final JTree tree;
    private final Datastore db;
    private final JTextField nameText;
    private final JTextField descriptionText;
    private final JTextArea createdText;
    private final JTextArea deadlineText;
    private final JTextArea completedText;

    /**
     * Default constructor for listener.
     *
     * @param tree JTree
     * @param db Datastore
     * @param nameText JTextField
     * @param descriptionText JTextField
     * @param createdText JTextArea
     * @param deadlineText JTextArea
     * @param completedText JTextArea
     */
    public UpdateButtonListener(JTree tree,
                                Datastore db,
                                JTextField nameText,
                                JTextField descriptionText,
                                JTextArea createdText,
                                JTextArea deadlineText,
                                JTextArea completedText
    ) {
        this.tree = tree;
        this.db = db;
        this.nameText = nameText;
        this.descriptionText = descriptionText;
        this.createdText = createdText;
        this.deadlineText = deadlineText;
        this.completedText = completedText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tree.getLastSelectedPathComponent() != null && tree.getLastSelectedPathComponent() instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node != null && node.getUserObject() instanceof Scheme) {
                Scheme scheme = (Scheme) node.getUserObject();
                setFunction(scheme);
                db.save(scheme);
                tree.repaint();
                tree.updateUI();
            }
        }
    }

    private void setFunction(Scheme scheme) {
        if (scheme.getName() == null) {
            if (!nameText.getText().isEmpty()) {
                scheme.setName(nameText.getText());
            }
        } else {
            if (!nameText.getText().equals(scheme.getName())) {
                scheme.setName(nameText.getText());
            }
        }

        if (scheme.getDescription() == null) {
            if (!descriptionText.getText().isEmpty()) {
                scheme.setDescription(descriptionText.getText());
            }
        } else {
            if (!scheme.getDescription().equals(scheme.getDescription())) {
                scheme.setDescription(descriptionText.getText());
            }
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
