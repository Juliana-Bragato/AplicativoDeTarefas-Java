package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ProjectDAO;
import controller.TaskDAO;
import model.Project;
import model.Task;
import util.ButtonColumnCellRederer;
import util.StatusColumnCellRenderer;
import util.TaskTableModel;
import java.awt.Cursor;

public class MainScreen extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	DefaultListModel projectsModel;
	TaskTableModel tasksModel;

	ProjectDAO projectDAO;
	TaskDAO taskDAO;

	public MainScreen() {
		initComponents();
		setApplicationIcon();

		initDataAccessObjects();
		initComponentsModel();

		decorateJTableTasks();
		centralizeMainScreen();
	}

	private void initComponents() {

		jScrollPaneTasks = new javax.swing.JScrollPane();
		jTableTasks = new javax.swing.JTable();
		jPanelToolBar = new javax.swing.JPanel();
		jLabelToolBarTitle = new javax.swing.JLabel();
		jLabelToolBarSubTitle = new javax.swing.JLabel();
		jLabelToolBarSubTitle
				.setIcon(new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-girassol-32.png"));
		jLabelInfos = new javax.swing.JLabel();
		jPanelProjects = new javax.swing.JPanel();
		jScrollPaneProjects = new javax.swing.JScrollPane();
		jListProjects = new javax.swing.JList<>();
		jListProjects.setSelectionForeground(new Color(255, 255, 255));
		jListProjects.setForeground(new Color(51, 102, 51));
		jPanelTasksTollBar = new javax.swing.JPanel();
		jLabelTasksToolBarTitle = new javax.swing.JLabel();
		jLabelTasksToolBarAdd = new javax.swing.JLabel();
		jLabelTasksToolBarAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jPanelProjectsToolBar = new javax.swing.JPanel();
		jLabelProjectsToolBarTitle = new javax.swing.JLabel();
		jLabelProjectsToolBarAdd = new javax.swing.JLabel();
		jLabelProjectsToolBarAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jPanelEmptyTasks = new javax.swing.JPanel();
		jPanelEmptyTasksLayout = new javax.swing.JPanel();
		jPanelEmptyTasksLayout.setForeground(new Color(0, 0, 0));
		jLabelEmptyTasksTitle = new javax.swing.JLabel();
		jLabelEmptyTasksSubTitle = new javax.swing.JLabel();
		jLabelEmptyTasksImage = new javax.swing.JLabel();

		jScrollPaneTasks.setBorder(null);

		jTableTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jTableTasks.setFocusable(false);
		jTableTasks.setIntercellSpacing(new java.awt.Dimension(0, 0));
		jTableTasks.setRowHeight(50);
		jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
		jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jTableTasks.setShowHorizontalLines(false);
		jTableTasks.setShowVerticalLines(false);
		jTableTasks.getTableHeader().setReorderingAllowed(false);
		jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTableTasksMouseClicked(evt);
			}
		});
		jScrollPaneTasks.setViewportView(jTableTasks);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Todo App");
		setBackground(new java.awt.Color(255, 255, 255));
		setMinimumSize(new java.awt.Dimension(600, 800));

		jPanelToolBar.setBackground(new Color(0, 204, 153));
		jPanelToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 28)); // NOI18N
		jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
		jLabelToolBarTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabelToolBarTitle.setIcon(
				new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-dinossauro-kawaii-100d.png")); // NOI18N
		jLabelToolBarTitle.setText("  App Tarefas");
		jLabelToolBarTitle.setToolTipText("");

		jLabelToolBarSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // NOI18N
		jLabelToolBarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
		jLabelToolBarSubTitle.setText("    Anote tudo, não esqueça nada");

		jLabelInfos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabelInfosMouseClicked(evt);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-girassol-32.png"));

		javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
		jPanelToolBarLayout.setHorizontalGroup(jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanelToolBarLayout.createSequentialGroup().addContainerGap().addGroup(jPanelToolBarLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								jPanelToolBarLayout.createSequentialGroup().addGap(0, 992, Short.MAX_VALUE)
										.addComponent(jLabelInfos))
						.addGroup(jPanelToolBarLayout.createSequentialGroup()
								.addComponent(jLabelToolBarSubTitle, GroupLayout.PREFERRED_SIZE, 268,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE))
						.addContainerGap()));
		jPanelToolBarLayout.setVerticalGroup(jPanelToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanelToolBarLayout.createSequentialGroup().addContainerGap().addComponent(jLabelInfos)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabelToolBarTitle)
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(jPanelToolBarLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabelToolBarSubTitle)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(15)));
		jPanelToolBar.setLayout(jPanelToolBarLayout);

		jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
		jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jListProjects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jListProjects.setFixedCellHeight(50);
		jListProjects.setSelectionBackground(new Color(51, 204, 153));
		jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jListProjectsMouseClicked(evt);
			}
		});
		jScrollPaneProjects.setViewportView(jListProjects);

		javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
		jPanelProjects.setLayout(jPanelProjectsLayout);
		jPanelProjectsLayout.setHorizontalGroup(jPanelProjectsLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelProjectsLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPaneProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addContainerGap()));
		jPanelProjectsLayout
				.setVerticalGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelProjectsLayout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPaneProjects).addContainerGap()));

		jPanelTasksTollBar.setBackground(new java.awt.Color(255, 255, 255));
		jPanelTasksTollBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabelTasksToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabelTasksToolBarTitle.setForeground(new Color(51, 204, 153));
		jLabelTasksToolBarTitle.setText("Tarefas");

		jLabelTasksToolBarAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelTasksToolBarAdd
				.setIcon(new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-adicionar-arquivo-70.png")); // NOI18N
		jLabelTasksToolBarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabelTasksToolBarAddMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanelTasksTollBarLayout = new javax.swing.GroupLayout(jPanelTasksTollBar);
		jPanelTasksTollBarLayout.setHorizontalGroup(jPanelTasksTollBarLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanelTasksTollBarLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabelTasksToolBarTitle, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabelTasksToolBarAdd,
								GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)));
		jPanelTasksTollBarLayout.setVerticalGroup(jPanelTasksTollBarLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelTasksToolBarTitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 53,
						Short.MAX_VALUE)
				.addComponent(jLabelTasksToolBarAdd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 53,
						Short.MAX_VALUE));
		jPanelTasksTollBar.setLayout(jPanelTasksTollBarLayout);

		jPanelProjectsToolBar.setBackground(new java.awt.Color(255, 255, 255));
		jPanelProjectsToolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabelProjectsToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabelProjectsToolBarTitle.setForeground(new Color(51, 204, 153));
		jLabelProjectsToolBarTitle.setText("Projetos");

		jLabelProjectsToolBarAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelProjectsToolBarAdd
				.setIcon(new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-adicionar-arquivo-70.png")); // NOI18N
		jLabelProjectsToolBarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabelProjectsToolBarAddMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanelProjectsToolBarLayout = new javax.swing.GroupLayout(jPanelProjectsToolBar);
		jPanelProjectsToolBarLayout.setHorizontalGroup(jPanelProjectsToolBarLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanelProjectsToolBarLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabelProjectsToolBarTitle, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabelProjectsToolBarAdd)));
		jPanelProjectsToolBarLayout.setVerticalGroup(jPanelProjectsToolBarLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelProjectsToolBarTitle, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
				.addComponent(jLabelProjectsToolBarAdd, GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE));
		jPanelProjectsToolBar.setLayout(jPanelProjectsToolBarLayout);

		jPanelEmptyTasks.setBackground(new java.awt.Color(255, 255, 255));
		jPanelEmptyTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanelEmptyTasks.setLayout(new java.awt.BorderLayout());

		jPanelEmptyTasksLayout.setBackground(new java.awt.Color(255, 255, 255));

		jLabelEmptyTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		jLabelEmptyTasksTitle.setForeground(new Color(51, 204, 153));
		jLabelEmptyTasksTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelEmptyTasksTitle.setText("Nenhuma Tarefa por aqui :D");

		jLabelEmptyTasksSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabelEmptyTasksSubTitle.setForeground(new java.awt.Color(153, 153, 153));
		jLabelEmptyTasksSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelEmptyTasksSubTitle.setText("Clique no botão \"+\" para adicionar uma nova tarefa");

		jLabelEmptyTasksImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelEmptyTasksImage.setIcon(
				new ImageIcon("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-ficheiro-de-imagem-100.png")); // NOI18N

		javax.swing.GroupLayout jPanelEmptyTasksLayoutLayout = new javax.swing.GroupLayout(jPanelEmptyTasksLayout);
		jPanelEmptyTasksLayout.setLayout(jPanelEmptyTasksLayoutLayout);
		jPanelEmptyTasksLayoutLayout.setHorizontalGroup(
				jPanelEmptyTasksLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabelEmptyTasksImage, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabelEmptyTasksSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabelEmptyTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanelEmptyTasksLayoutLayout.setVerticalGroup(
				jPanelEmptyTasksLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelEmptyTasksLayoutLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabelEmptyTasksImage)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabelEmptyTasksTitle)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabelEmptyTasksSubTitle)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanelEmptyTasks.add(jPanelEmptyTasksLayout, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanelProjectsToolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jPanelTasksTollBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanelEmptyTasks, GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
						.addContainerGap()).addComponent(jPanelToolBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
				.addComponent(
						jPanelToolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanelProjectsToolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanelTasksTollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
						.addComponent(jPanelEmptyTasks, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
				.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jLabelTasksToolBarAddMouseClicked(java.awt.event.MouseEvent evt) {

		int indexSeletecProject = jListProjects.getSelectedIndex();
		if (indexSeletecProject != -1) {
			TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, true);

			Project project = (Project) projectsModel.get(jListProjects.getSelectedIndex());

			taskDialogScreen.setProject(project);
			taskDialogScreen.setVisible(true);

			taskDialogScreen.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent e) {
					int projectIndex = jListProjects.getSelectedIndex();
					Project project = (Project) projectsModel.get(projectIndex);
					loadTasks(project.getId());
				}
			});
		} else {
			JOptionPane.showMessageDialog(rootPane, "Você deve escolher um projeto para essa tarefa", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jLabelProjectsToolBarAddMouseClicked(java.awt.event.MouseEvent evt) {

		ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, true);
		projectDialogScreen.setVisible(true);

		projectDialogScreen.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				loadProjects();
			}
		});
	}

	private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {

		int projectIndex = jListProjects.getSelectedIndex();
		Project project = (Project) projectsModel.get(projectIndex);
		loadTasks(project.getId());
	}

	private void jLabelInfosMouseClicked(java.awt.event.MouseEvent evt) {

		JOptionPane.showMessageDialog(rootPane, "Develop by Juliana Bragato");
	}

	private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {

		int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
		int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());
		Task task = tasksModel.getTasks().get(rowIndex);
		TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, true);

		switch (columnIndex) {
		case 1:
			break;
		case 3:
			taskDAO.update(task);
			break;
		case 4:
			JOptionPane.showMessageDialog(rootPane, "Editar a tarefa");
			taskDialogScreen.setTask(task);
			taskDialogScreen.setVisible(true);
			break;
		case 5:
			taskDAO.removeById(task.getId());
			tasksModel.getTasks().remove(task);

			int projectIndex = jListProjects.getSelectedIndex();
			Project project = (Project) projectsModel.get(projectIndex);
			loadTasks(project.getId());
			break;
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
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainScreen().setVisible(true);
			}
		});
	}

	private javax.swing.JLabel jLabelEmptyTasksImage;
	private javax.swing.JLabel jLabelEmptyTasksSubTitle;
	private javax.swing.JLabel jLabelEmptyTasksTitle;
	private javax.swing.JLabel jLabelInfos;
	private javax.swing.JLabel jLabelProjectsToolBarAdd;
	private javax.swing.JLabel jLabelProjectsToolBarTitle;
	private javax.swing.JLabel jLabelTasksToolBarAdd;
	private javax.swing.JLabel jLabelTasksToolBarTitle;
	private javax.swing.JLabel jLabelToolBarSubTitle;
	private javax.swing.JLabel jLabelToolBarTitle;
	private javax.swing.JList<String> jListProjects;
	private javax.swing.JPanel jPanelEmptyTasks;
	private javax.swing.JPanel jPanelEmptyTasksLayout;
	private javax.swing.JPanel jPanelProjects;
	private javax.swing.JPanel jPanelProjectsToolBar;
	private javax.swing.JPanel jPanelTasksTollBar;
	private javax.swing.JPanel jPanelToolBar;
	private javax.swing.JScrollPane jScrollPaneProjects;
	private javax.swing.JScrollPane jScrollPaneTasks;
	private javax.swing.JTable jTableTasks;

	private void initDataAccessObjects() {
		projectDAO = new ProjectDAO();
		taskDAO = new TaskDAO();
	}

	@SuppressWarnings("unchecked")
	private void loadProjects() {
		List<Project> projects = projectDAO.getAll();

		projectsModel.clear();

		for (int i = 0; i < projects.size(); i++) {
			projectsModel.addElement(projects.get(i));
		}
		jListProjects.setModel(projectsModel);
	}

	private void loadTasks(int projectId) {
		List<Task> tasks = taskDAO.getByProjectId(projectId);

		tasksModel.setTasks(tasks);
		showJTableTasks(!tasks.isEmpty());
	}

	private void showJTableTasks(boolean isEmptyTable) {
		if (isEmptyTable) {
			if (jPanelEmptyTasksLayout.isVisible()) {
				jPanelEmptyTasksLayout.setVisible(false);
				jPanelEmptyTasks.remove(jPanelEmptyTasksLayout);
			}

			jPanelEmptyTasks.add(jScrollPaneTasks);
			jScrollPaneTasks.setVisible(true);
			jScrollPaneTasks.setSize(jPanelEmptyTasks.getWidth(), jPanelEmptyTasks.getHeight());

		} else {
			if (jScrollPaneTasks.isVisible()) {
				jScrollPaneTasks.setVisible(false);
				jPanelEmptyTasks.remove(jScrollPaneTasks);
			}

			jPanelEmptyTasks.add(jPanelEmptyTasksLayout);
			jPanelEmptyTasksLayout.setVisible(true);
			jPanelEmptyTasksLayout.setSize(jPanelEmptyTasks.getWidth(), jPanelEmptyTasks.getHeight());
		}
	}

	private void decorateJTableTasks() {

		jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		jTableTasks.getTableHeader().setOpaque(false);
		jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
		jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));

		jTableTasks.setAutoCreateRowSorter(true);

		jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
				int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

				if (columnIndex == 3) {
					Task task = tasksModel.getTasks().get(rowIndex);
					taskDAO.update(task);
				}
			}
		});
	}

	private void centralizeMainScreen() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@SuppressWarnings("rawtypes")
	private void initComponentsModel() {
		projectsModel = new DefaultListModel();
		loadProjects();

		tasksModel = new TaskTableModel();
		jTableTasks.setModel(tasksModel);
		jTableTasks.getColumnModel().getColumn(2).setCellRenderer(new StatusColumnCellRenderer());
		jTableTasks.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRederer("edit"));
		jTableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRederer("delete"));

		if (!projectsModel.isEmpty()) {
			jListProjects.setSelectedIndex(0);
			int projectIndex = jListProjects.getSelectedIndex();
			Project project = (Project) projectsModel.get(projectIndex);
			loadTasks(project.getId());
		}
	}

	@SuppressWarnings("unused")
	private void setApplicationIcon() {
		Image icon = Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\inspect1\\Desktop\\L�gica de programa��o III\\Workspace\\TodoApp\\bin\\resources\\tick\\tick.png");
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Projetos\\TodoApp\\src\\main\\resources\\icons8-dinossauro-kawaii-100d.png"));
	}
}
