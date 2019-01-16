import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ShapesGUI implements MouseListener, ActionListener{

	private JFrame frame;
	JPanel shapePanel = new JPanel();
	JScrollPane scrollShape = new JScrollPane(shapePanel);
	ArrayList<JLabel> shapeLabelArray = new ArrayList<JLabel>();
	private final JPanel CirclePanel = new JPanel();
	ShapesReader shapesrdr = new ShapesReader();
	ArrayList<Shape> sh = shapesrdr.getShapes();	
	private final JPanel SquarePanel = new JPanel();
	private final JPanel rectPanel = new JPanel();
	private final JPanel triPanel = new JPanel();
	JLabel CirclePic = new JLabel("");
	JLabel SquarePic = new JLabel("");
	JLabel triPic = new JLabel("");
	JTextArea CircleTextArea = new JTextArea();
	private final JTextArea SquareTextArea = new JTextArea();
	JLayeredPane Lp = new JLayeredPane();
	private final JTextArea TriTextArea = new JTextArea();
	JTextArea RectTextArea = new JTextArea();
	private final JPanel panel = new JPanel();
	private final JLabel lblSelectAShape = new JLabel("Select A Shape:");
	private final JTextField searchTField = new JTextField();
	JPanel SearchPanel = new JPanel();
	JButton SearchBttn = new JButton("Search ID");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapesGUI window = new ShapesGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShapesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Shapes");
		frame.getContentPane().setLayout(null);
		
		shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.PAGE_AXIS));
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// scrollPane setup
		scrollShape.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollShape.setBounds(0,0,175,431);
		frame.getContentPane().add(scrollShape);
		scrollShape.setColumnHeaderView(panel);
		lblSelectAShape.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblSelectAShape);
		
		Lp.setBounds(160, 48, 610, 383);
		frame.getContentPane().add(Lp);
		Lp.setLayout(new CardLayout(0, 0));
		Lp.add(CirclePanel, "name_169769108089100");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///Circle Panel and contents
		
		CirclePanel.setLayout(null);
		CirclePic.setHorizontalAlignment(SwingConstants.CENTER);
		CirclePic.setBounds(10, 11, 363, 409);
		try {
			URL circle = new URL("https://i.ebayimg.com/images/g/i7gAAOxyakdRFIn-/s-l300.jpg");
			Image circleImage = ImageIO.read(circle);
			CirclePic.setIcon(new ImageIcon(circleImage));

		} catch (IOException e) {
			System.out.printf("oops");
		}
		CircleTextArea.setBounds(354, 0, 256, 431);
		CircleTextArea.setEditable(false);
		CirclePanel.add(CircleTextArea);
		CirclePanel.add(CirclePic);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Square Panel setup
		
		Lp.add(SquarePanel, "name_169780545911700");
		SquarePanel.setLayout(null);
		SquarePic.setHorizontalAlignment(SwingConstants.CENTER);
		SquarePic.setBounds(10, 11, 363, 409);
		try {
			URL square = new URL("https://res.cloudinary.com/marketplaceevents/image/fetch/w_366,h_366,c_limit/https://marketplaceevents.azureedge.net/sitefinity/images/default-source/flower-show/green-square.jpg");
			Image squareImage = ImageIO.read(square);
			SquarePic.setIcon(new ImageIcon(squareImage));

		} catch (IOException e) {
			System.out.printf("oops" + e.getMessage());
		}
		
		SquarePanel.add(SquarePic);		
		SquareTextArea.setBounds(354,0,256,431);
		SquareTextArea.setEditable(false);
		SquarePanel.add(SquareTextArea);

		/////////////////////////////////////////////////////////////////////////////////////
		//Triangle set up
		Lp.add(triPanel, "name_184414090939800");
		triPanel.setLayout(null);
		
		triPic.setHorizontalAlignment(SwingConstants.CENTER);
		triPic.setBounds(10, 11, 363, 409);
		try {
			URL tri = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Purple_triangle.svg/220px-Purple_triangle.svg.png");
			Image triImage = ImageIO.read(tri);
			triPic.setIcon(new ImageIcon(triImage));

		} catch (IOException e) {
			System.out.printf("oops" + e.getMessage());
		}
		triPanel.add(triPic);
		TriTextArea.setBounds(354, 0, 256, 431);
		TriTextArea.setEditable(false);
		triPanel.add(TriTextArea);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// Rectangle set up
		Lp.add(rectPanel, "name_184398997202200");
		rectPanel.setLayout(null);
		
		JLabel rPic = new JLabel("");
		rPic.setHorizontalAlignment(SwingConstants.CENTER);
		rPic.setBounds(10, 11, 363, 409);
		try {
			URL rect = new URL("http://i.imgur.com/Eiw8qTZ.png");
			Image rectImage = ImageIO.read(rect);
			rPic.setIcon(new ImageIcon(rectImage));

		} catch (IOException e) {
			System.out.printf("oops" + e.getMessage());
		}
		rectPanel.add(rPic);
		RectTextArea.setBounds(354,0, 256, 431);
		RectTextArea.setEditable(false);
		rectPanel.add(RectTextArea);
		searchTField.setBounds(20, 11, 100, 20);
		searchTField.setColumns(10);
		SearchPanel.setBounds(188, 0, 314, 50);
		frame.getContentPane().add(SearchPanel);
		SearchPanel.setLayout(null);
		
		SearchPanel.add(searchTField);
		

		SearchBttn.setBounds(153, 10, 123, 23);
		SearchBttn.addActionListener(this);
		SearchPanel.add(SearchBttn);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		/// grab the items from 
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			SAXParser saxParser = spf.newSAXParser();
			XMLReader xmlrdr = saxParser.getXMLReader();
			xmlrdr.setContentHandler(shapesrdr);
			xmlrdr.parse("file:/C:/Users/csweet20/Desktop/Java/MidTerm/src/shapes.xml"); ///NOTE: this is my desktop directory

			////for loop to list all the Shapes names and ID #s in scroll pane
			for(Shape s: sh) {
					JLabel shl = new JLabel(s.getKind() + " (" + String.valueOf(s.getID()) + ")");
					shl.addMouseListener(this);
					shapeLabelArray.add(shl);
					shapePanel.add(shl);
				}
			} catch (Exception ex) {System.out.printf("something is terribly wrong: " + ex.getMessage());}
		}

	@Override ////clicking on the labels in the scroll Panes will change the panels to the correct ones with the right info
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < shapeLabelArray.size(); i ++)
			shapeLabelArray.get(i).setForeground(Color.BLACK);
		for (int i = 0; i < shapeLabelArray.size(); i ++) {
				if (e.getSource() == shapeLabelArray.get(i)) {
					shapeLabelArray.get(i).setForeground(Color.BLUE);
					if(sh.get(i).getKind().compareTo("Circle") == 0) {
							CircleTextArea.setText(sh.get(i).getDetailString());
							Lp.removeAll();
							Lp.add(CirclePanel);
							Lp.repaint();
							Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Square") == 0) {
							SquareTextArea.setText(sh.get(i).getDetailString());
							Lp.removeAll();
							Lp.add(SquarePanel);
							Lp.repaint();
							Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Triangle") == 0) {
							TriTextArea.setText(sh.get(i).getDetailString());
							Lp.removeAll();
							Lp.add(triPanel);
							Lp.repaint();
							Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Rectangle") == 0) {
							RectTextArea.setText(sh.get(i).getDetailString());
							Lp.removeAll();
							Lp.add(rectPanel);
							Lp.repaint();
							Lp.revalidate();
					}
				}
		}
	}

	////////////////////////////////////////////////////////////////
	/// these were not needed
	@Override
	public void mouseEntered(MouseEvent arg0) {	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	/////////////////////////////////////////////////////////////////////////////////////
	@Override //// function so that Search button opens up correct panel
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == SearchBttn) {
			for(int i = 0; i < sh.size(); i++) {
				if (searchTField.getText().compareTo(String.valueOf(sh.get(i).getID())) == 0) {
					if(sh.get(i).getKind().compareTo("Circle") == 0) {
						CircleTextArea.setText(sh.get(i).getDetailString());
						Lp.removeAll();
						Lp.add(CirclePanel);
						Lp.repaint();
						Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Square") == 0) {
						SquareTextArea.setText(sh.get(i).getDetailString());
						Lp.removeAll();
						Lp.add(SquarePanel);
						Lp.repaint();
						Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Triangle") == 0) {
						TriTextArea.setText(sh.get(i).getDetailString());
						Lp.removeAll();
						Lp.add(triPanel);
						Lp.repaint();
						Lp.revalidate();
					}
					else if(sh.get(i).getKind().compareTo("Rectangle") == 0) {
						RectTextArea.setText(sh.get(i).getDetailString());
						Lp.removeAll();
						Lp.add(rectPanel);
						Lp.repaint();
						Lp.revalidate();
					}
				}
			}
		}
		
	}
}

