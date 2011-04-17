package tv.porst.swfretools.dissector.gui.main.implementations;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import tv.porst.swfretools.dissector.gui.main.MessageBox;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTree;
import tv.porst.swfretools.dissector.gui.main.flashtree.FlashTreeHelpers;
import tv.porst.swfretools.dissector.gui.main.flashtree.nodes.FlashTreeNode;
import tv.porst.swfretools.dissector.gui.main.models.FileModel;
import tv.porst.swfretools.dissector.gui.main.models.LoadedFile;
import tv.porst.swfretools.parser.SWFParserException;

/**
 * Contains methods for working with files.
 */
public final class FileActions {

	/**
	 * Selects a node in the SWF tree.
	 * 
	 * @param tree The tree where the node is selected.
	 * @param node The node to select.
	 */
	private static void selectNode(final FlashTree tree, final FlashTreeNode<?> node) {

		final TreeNode[] path = node.getPath();

		tree.expandPath(new TreePath(path));
		tree.setSelectionPath(new TreePath(path));

		tree.updateUI();
	}

	/**
	 * Prompts the user for an SWF file and opens the selected file.
	 * 
	 * @param tree The tree that shows the opened SWF file.
	 * @param model The file model that keeps track of open files.
	 */
	public static void openFile(final FlashTree tree, final FileModel model) {

		final JFileChooser chooser = new JFileChooser();

		if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(tree)) {

			final File file = chooser.getSelectedFile();

			try {
				final LoadedFile loadedFile = model.openFile(file);

				// After loading the file, the new node in the tree should
				// be selected. This is not done in the event handler because
				// in the future there will be other ways to load files and
				// those should not display the node selection behavior.

				final FlashTreeNode<?> node = FlashTreeHelpers.findNode((FlashTreeNode<?>) tree.getModel().getRoot(), loadedFile);

				selectNode(tree, node);
			} catch (final IOException e) {
				MessageBox.showError(SwingUtilities.getWindowAncestor(tree), "Selected file could not be read.");
			} catch (final SWFParserException e) {
				MessageBox.showError(SwingUtilities.getWindowAncestor(tree), "Selected file could not be parsed.");
			}
		}
	}
}