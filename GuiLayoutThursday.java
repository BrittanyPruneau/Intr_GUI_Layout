package guiLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class GuiLayoutThursday extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GuiLayoutThursday frame = new GuiLayoutThursday();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiLayoutThursday()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTitle = createLblTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel panel = creatControlPanel();
		contentPane.add(panel, BorderLayout.EAST);
		
		JPanel mainPanel = createMainLabel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

	private JPanel createMainLabel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(8, 0, 5, 0));
		mainPanel.setBackground(SystemColor.textHighlight);
		mainPanel.setLayout(new GridLayout(0, 5, 8, 0));
		
		JLabel lblNewLabel = new JLabel("H");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E");
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("L");
		mainPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("LO");
		mainPanel.add(lblNewLabel_2);
		return mainPanel;
	}

	private JPanel creatControlPanel()
	{
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(5, 5, 0, 10));
		controlPanel.setLayout(new GridLayout(5, 0, 0, 5));
		
		JButton btnNewButton = new JButton("Button A");
		controlPanel.add(btnNewButton);
		
		JButton btnB = new JButton("Button B");
		controlPanel.add(btnB);
		
		JButton btnButtonC = new JButton("Button C");
		controlPanel.add(btnButtonC);
		return controlPanel;
	}

	private JLabel createLblTitle()
	{
		JLabel lblTitle = new JLabel("Demo Layout");
		lblTitle.setOpaque(true);
		lblTitle.setBackground(SystemColor.info);
		lblTitle.setBorder(new EmptyBorder(6, 0, 6, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		return lblTitle;
	}

}
