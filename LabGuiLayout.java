package guiLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Allows the user to click a left or right arrow button that changes the block
 * in that direction to blue, while the rest of the blocks are yellow.
 * 
 * @author Brittany Pruneau
 *
 */
public class LabGuiLayout extends JFrame
{
	private JPanel contentPane;
	private int panelLocation = 2;

	/*
	 * Launch's the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LabGuiLayout frame = new LabGuiLayout();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Creates the frame.
	 */
	public LabGuiLayout()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = createTitleDemoLayout();
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_2 = createMainPanelNumbers();
		contentPane.add(panel_2, BorderLayout.CENTER);

		JPanel panel_1 = createControlPanelWest(panel_2);
		contentPane.add(panel_1, BorderLayout.WEST);
	}
	
	/*
	 * Provides the layout of the title Demo Layout at the top of the GUI. 
	 */
	private JPanel createTitleDemoLayout()
	{
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(14, 0, 14, 0));
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblDemoLayout = new JLabel("Demo Layout");
		lblDemoLayout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDemoLayout.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDemoLayout, BorderLayout.CENTER);
		return panel;
	}

	/*
	 * Creates the main panel where the colors are originally set to blue and yellow. 
	 */
	private JPanel createMainPanelNumbers()
	{
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(0, 4, 7, 8));

		JLabel lblOne = new JLabel("1");
		lblOne.setBackground(Color.ORANGE);
		lblOne.setOpaque(true);
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel_2.add(lblOne);

		JLabel lblTwo = new JLabel("2");
		lblTwo.setOpaque(true);
		lblTwo.setBackground(Color.ORANGE);
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel_2.add(lblTwo);

		JLabel lblThree = new JLabel("3");
		lblThree.setBackground(Color.BLUE);
		lblThree.setOpaque(true);
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThree.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel_2.add(lblThree);

		JLabel lblFour = new JLabel("4");
		lblFour.setOpaque(true);
		lblFour.setBackground(Color.ORANGE);
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblFour.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel_2.add(lblFour);
		return panel_2;
	}

	/*
	 * Keeps track of the current location, which tile, is of the color blue. 
	 * Changes the current tile location to the right of the current tile, by incrementing the panelLocation by 1. 
	 */
	private int moveTileRight()
	{
		int priorPanelLocation = this.panelLocation;
		if (panelLocation == 3)
		{
			panelLocation = -1;
		}
		this.panelLocation++;

		return priorPanelLocation;
	}

	/*
	 * Keeps track of the current location, which tile, is of the color blue. 
	 * Changes the current tile location to the left of the current tile, by decrementing the panelLocation by 1. 
	 */
	private int moveTileLeft()
	{
		int priorPanelLocation = this.panelLocation;
		if (panelLocation == 0)
		{
			panelLocation = 4;
		}
		this.panelLocation--;

		return priorPanelLocation;
	}

	/*
	 * Contains functionality for the buttons on the west side. 
	 * Changes the current tile to blue while the rest of the tiles are yellow. 
	 */
	private JPanel createControlPanelWest(JPanel panel_2)
	{
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 8, 0, 8));
		panel_1.setLayout(new GridLayout(5, 0, 0, 5));

		JButton btnLeftButton = new JButton("<--");
		btnLeftButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int priorPanelLocation = moveTileLeft();
				JLabel labelToBlue = (JLabel) panel_2.getComponent(panelLocation);
				JLabel labelToYellow = (JLabel) panel_2.getComponent(priorPanelLocation);
				labelToBlue.setBackground(Color.BLUE);
				labelToYellow.setBackground(Color.ORANGE);
			}
		});
		btnLeftButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(btnLeftButton);

		JButton btnRightButton = new JButton("-->");
		btnRightButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				int priorPanelLocation = moveTileRight();
				JLabel labelToBlue = (JLabel) panel_2.getComponent(panelLocation);
				JLabel labelToYellow = (JLabel) panel_2.getComponent(priorPanelLocation);
				labelToBlue.setBackground(Color.BLUE);
				labelToYellow.setBackground(Color.ORANGE);

			}
		});
		panel_1.add(btnRightButton);
		return panel_1;
	}
}
