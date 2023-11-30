package view;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import controller.TaskDAO;
import model.Project;
import model.Task;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;

public class TaskDialogScreen extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;
	TaskDAO taskDAO;
	Project project;

	private boolean isUpdate = false;
	Task task = null;

	public TaskDialogScreen(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-dinossauro-kawaii-100d.png"));
		initComponents();
		initDataAccessObjects();
		centralizeTaskDialogScreen();
	}

	private void initComponents() {

		jPanelRegisterTask = new javax.swing.JPanel();
		jLabelNotes = new javax.swing.JLabel();
		jScrollPaneDescription = new javax.swing.JScrollPane();
		jTextAreaDescription = new javax.swing.JTextArea();
		jLabelName = new javax.swing.JLabel();
		jTextFieldName = new javax.swing.JTextField();
		jLabelDescription = new javax.swing.JLabel();
		jScrollPaneNotes = new javax.swing.JScrollPane();
		jTextAreaNotes = new javax.swing.JTextArea();
		jLabelDeadLine = new javax.swing.JLabel();
		jFormattedTextFieldDeadLine = new javax.swing.JFormattedTextField();
		jPanelToolBar = new javax.swing.JPanel();
		jPanelToolBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jLabelToolBarTitle = new javax.swing.JLabel();
		jLabelToolBarSave = new javax.swing.JLabel();
		jLabelToolBarSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Tarefa");
		setMinimumSize(new java.awt.Dimension(400, 550));
		setPreferredSize(new java.awt.Dimension(400, 550));

		jPanelRegisterTask.setBackground(new java.awt.Color(255, 255, 255));
		jPanelRegisterTask.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabelNotes.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelNotes.setText("Notas");

		jTextAreaDescription.setColumns(20);
		jTextAreaDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTextAreaDescription.setLineWrap(true);
		jTextAreaDescription.setRows(5);
		jTextAreaDescription.setWrapStyleWord(true);
		jScrollPaneDescription.setViewportView(jTextAreaDescription);

		jLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelName.setText("Nome");

		jTextFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTextFieldName.setToolTipText("");

		jLabelDescription.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelDescription.setText("Descrição");

		jTextAreaNotes.setColumns(20);
		jTextAreaNotes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTextAreaNotes.setLineWrap(true);
		jTextAreaNotes.setRows(5);
		jTextAreaNotes.setWrapStyleWord(true);
		jScrollPaneNotes.setViewportView(jTextAreaNotes);

		jLabelDeadLine.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
		jLabelDeadLine.setText("Prazo");

		jFormattedTextFieldDeadLine.setFormatterFactory(
				new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

		javax.swing.GroupLayout jPanelRegisterTaskLayout = new javax.swing.GroupLayout(jPanelRegisterTask);
		jPanelRegisterTask.setLayout(jPanelRegisterTaskLayout);
		jPanelRegisterTaskLayout.setHorizontalGroup(jPanelRegisterTaskLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelRegisterTaskLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanelRegisterTaskLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPaneNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 356,
										Short.MAX_VALUE)
								.addComponent(jLabelNotes, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jScrollPaneDescription, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabelDeadLine, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jFormattedTextFieldDeadLine))
						.addContainerGap()));
		jPanelRegisterTaskLayout.setVerticalGroup(jPanelRegisterTaskLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelRegisterTaskLayout.createSequentialGroup().addContainerGap().addComponent(jLabelName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabelDescription)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabelNotes)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPaneNotes, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jLabelDeadLine)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jFormattedTextFieldDeadLine, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanelToolBar.setBackground(new Color(51, 204, 153));
		jPanelToolBar.setForeground(new Color(51, 204, 153));
		jPanelToolBar.setPreferredSize(new java.awt.Dimension(400, 50));

		jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
		jLabelToolBarTitle.setText("Nova Tarefa");

		jLabelToolBarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelToolBarSave.setIcon(new ImageIcon(
				"C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-caixa-de-selecção-seleccionada-2-70.png")); // NOI18N
		jLabelToolBarSave.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabelToolBarSaveMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
		jPanelToolBarLayout.setHorizontalGroup(jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, jPanelToolBarLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanelToolBarLayout.setVerticalGroup(jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanelToolBarLayout.createSequentialGroup()
						.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE));
		jPanelToolBar.setLayout(jPanelToolBarLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanelRegisterTask,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanelRegisterTask, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		pack();
	}

	public void setTask(Task task) {
		jTextFieldName.setText(task.getName());
		jTextAreaDescription.setText(task.getDescription());
		jTextAreaNotes.setText(task.getNotes());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(task.getDeadline());
		jFormattedTextFieldDeadLine.setText(formattedDate.toString());
		this.task = task;
		this.setIsUpdate(true);
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	private void jLabelToolBarSaveMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			
			if (!this.isUpdate) {
				this.task = new Task();				
			}

			this.task.setName(jTextFieldName.getText());
			this.task.setDescription(jTextAreaDescription.getText());
			this.task.setNotes(jTextAreaNotes.getText());

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date deadline = null;

			try {
				deadline = dateFormat.parse(jFormattedTextFieldDeadLine.getText());
			} catch (ParseException ex) {
				Logger.getLogger(TaskDialogScreen.class.getName()).log(Level.SEVERE, null, ex);
			}

			this.task.setDeadline(deadline);

			if (this.isUpdate) {
				taskDAO.update(this.task);
			} else {
				this.task.setIdProject(project.getId());

				this.task.setCompleted(false);
				taskDAO.save(this.task);
			}

			JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso");
			this.dispose();
		} catch (HeadlessException ex) {
			JOptionPane.showMessageDialog(rootPane, ex);
		}
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TaskDialogScreen dialog = new TaskDialogScreen(new javax.swing.JFrame(), true);
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

	private javax.swing.JFormattedTextField jFormattedTextFieldDeadLine;
	private javax.swing.JLabel jLabelDeadLine;
	private javax.swing.JLabel jLabelDescription;
	private javax.swing.JLabel jLabelName;
	private javax.swing.JLabel jLabelNotes;
	private javax.swing.JLabel jLabelToolBarTitle;
	private javax.swing.JPanel jPanelRegisterTask;
	private javax.swing.JPanel jPanelToolBar;
	private javax.swing.JScrollPane jScrollPaneDescription;
	private javax.swing.JScrollPane jScrollPaneNotes;
	private javax.swing.JTextArea jTextAreaDescription;
	private javax.swing.JTextArea jTextAreaNotes;
	private javax.swing.JTextField jTextFieldName;
	private JLabel jLabelToolBarSave;

	private void initDataAccessObjects() {
		taskDAO = new TaskDAO();
	}

	private void centralizeTaskDialogScreen() {
		setLocationRelativeTo(null);
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
