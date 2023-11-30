package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

import controller.ProjectDAO;
import model.Project;
import java.awt.Cursor;
import java.awt.Font;

public class ProjectDialogScreen extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;

	ProjectDAO projectDAO;

	public ProjectDialogScreen(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-dinossauro-kawaii-100d.png"));
		initComponents();
		initDataAccessObjects();
		centralizeProjectDialogScreen();

	}

	private void initComponents() {

		jPanelRegisterProject = new javax.swing.JPanel();
		jLabelName = new javax.swing.JLabel();
		jTextFieldName = new javax.swing.JTextField();
		jLabelDescription = new javax.swing.JLabel();
		jScrollPaneDescription = new javax.swing.JScrollPane();
		jTextAreaDescription = new javax.swing.JTextArea();
		jPanelToolBar = new javax.swing.JPanel();
		jPanelToolBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jLabelToolBarTitle = new javax.swing.JLabel();
		jLabelToolBarSave = new javax.swing.JLabel();
		jLabelToolBarSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Projeto");
		setMinimumSize(new java.awt.Dimension(400, 400));
		setPreferredSize(new java.awt.Dimension(400, 400));

		jPanelRegisterProject.setBackground(new java.awt.Color(255, 255, 255));
		jPanelRegisterProject.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelName.setText("Nome");

		jTextFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTextFieldName.setToolTipText("");

		jLabelDescription.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelDescription.setText("Descrição");

		jTextAreaDescription.setColumns(20);
		jTextAreaDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTextAreaDescription.setRows(5);
		jScrollPaneDescription.setViewportView(jTextAreaDescription);

		javax.swing.GroupLayout jPanelRegisterProjectLayout = new javax.swing.GroupLayout(jPanelRegisterProject);
		jPanelRegisterProject.setLayout(jPanelRegisterProjectLayout);
		jPanelRegisterProjectLayout.setHorizontalGroup(
				jPanelRegisterProjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelRegisterProjectLayout.createSequentialGroup().addContainerGap()
								.addGroup(jPanelRegisterProjectLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPaneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 356,
												Short.MAX_VALUE))
								.addContainerGap()));
		jPanelRegisterProjectLayout.setVerticalGroup(jPanelRegisterProjectLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelRegisterProjectLayout.createSequentialGroup().addContainerGap().addComponent(jLabelName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabelDescription)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPaneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 206,
								Short.MAX_VALUE)
						.addContainerGap()));

		jPanelToolBar.setBackground(new Color(51, 204, 153));
		jPanelToolBar.setForeground(new Color(51, 204, 153));
		jPanelToolBar.setPreferredSize(new java.awt.Dimension(400, 50));

		jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
		jLabelToolBarTitle.setText("Novo Projeto");

		jLabelToolBarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelToolBarSave.setIcon(new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-caixa-de-selecção-seleccionada-2-70.png")); // NOI18N
		jLabelToolBarSave.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabelToolBarSaveMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
		jPanelToolBarLayout.setHorizontalGroup(
			jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanelToolBarLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		jPanelToolBarLayout.setVerticalGroup(
			jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelToolBarTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
		);
		jPanelToolBar.setLayout(jPanelToolBarLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanelRegisterProject, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanelRegisterProject, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		pack();
	}

	private void jLabelToolBarSaveMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			Project project = new Project();
			project.setName(jTextFieldName.getText());
			project.setDescription(jTextAreaDescription.getText());

			projectDAO.save(project);

			JOptionPane.showMessageDialog(rootPane, "Projeto salva com sucesso");
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e);
		}
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Java swing".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ProjectDialogScreen dialog = new ProjectDialogScreen(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	private javax.swing.JLabel jLabelDescription;
	private javax.swing.JLabel jLabelName;
	private javax.swing.JLabel jLabelToolBarSave;
	private javax.swing.JLabel jLabelToolBarTitle;
	private javax.swing.JPanel jPanelRegisterProject;
	private javax.swing.JPanel jPanelToolBar;
	private javax.swing.JScrollPane jScrollPaneDescription;
	private javax.swing.JTextArea jTextAreaDescription;
	private javax.swing.JTextField jTextFieldName;

	private void initDataAccessObjects() {
		projectDAO = new ProjectDAO();
	}

	private void centralizeProjectDialogScreen() {
		setLocationRelativeTo(null);
	}
}
