import java.io.*;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.*;//this package is appplied for border of ja pane
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class attendance
{
	public static void main(String[] args) throws Exception 
	{
		JFrame mainframe=new JFrame("ATTENDANCE RECORDER");

		//Logo
		JLabel ico = new JLabel(new ImageIcon("img/giet.png"));
		mainframe.add(ico);
		ico.setBounds(10,10,100,100);

		//Headings
		JLabel heading1 = new JLabel("ATTENDANCE");
		heading1.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		mainframe.add(heading1);
		heading1.setBounds(180,25,300,30);
		JLabel heading2 = new JLabel("MANAGEMENT");
		heading2.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		mainframe.add(heading2);
		heading2.setBounds(170,55,300,30);
		JLabel heading3 = new JLabel("SYSTEM");
		heading3.setFont(new Font("Cooper Black", Font.PLAIN, 30));
		mainframe.add(heading3);
		heading3.setBounds(220,85,300,30);

		//button1
		JLabel btn1label = new JLabel("TO ENTER  ATTENDANCE : ");
		btn1label.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		mainframe.add(btn1label);
		btn1label.setBounds(30,140,300,30);
		JButton btn1=new JButton("<html><color=white><b>Enter</b></font></html>");
		btn1.setBackground(new Color(0, 0, 102));
		btn1.setBounds(270,140,90,30);
		mainframe.add(btn1);

		btn1.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					recordAttendance();
				}
			}
		);

		//button2
		JLabel btn2label = new JLabel("TO SEE ATTENDANCE : ");
		btn2label.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		mainframe.add(btn2label);
		btn2label.setBounds(30,190,300,30);

		//Label class name
		JLabel clsnm = new JLabel("Class : ");
		clsnm.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		mainframe.add(clsnm);
		clsnm.setBounds(40,230,90,30);
		//input class name
		JTextField clsnmin=new JTextField();
		clsnmin.setToolTipText("Ex. CSE_sem_iii_A");
    mainframe.add(clsnmin);
    clsnmin.setBounds(130,230,120,30);

    //Label class name
		JLabel subnm = new JLabel("Subject : ");
		subnm.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		mainframe.add(subnm);
		subnm.setBounds(40,270,90,30);
    //input subname name
		JTextField subin=new JTextField();
		subin.setToolTipText("Ex. CSE_sem_iii_A");
    mainframe.add(subin);
    subin.setBounds(130,270,120,30);

		JButton btn2=new JButton("<html><color=white><b>SEE</b></color></html>");
		btn2.setBackground(new Color(0, 0, 102));
		btn2.setBounds(80,320,90,30);
		mainframe.add(btn2);
		btn2.addActionListener(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e){
					try
					{
						seeAttendance(clsnmin,subin);
						clsnmin.setText("");
						subin.setText("");
					}
					catch(Exception fr)
					{
						fr.printStackTrace();
					}
				}
			}
		);

		JLabel credit = new JLabel("Project By: Mayank Mohak, Purushotam Satpathy and Sandeep Jena");
		credit.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		mainframe.add(credit);
		credit.setBounds(35,430,500,30);

		mainframe.setSize(500,500);
		mainframe.setLayout(null);
		mainframe.setVisible(true);
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static void recordAttendance()
	{
		JFrame recordframe=new JFrame("ATTENDANCE RECORDER");

		//Heading
		JLabel heading = new JLabel("ATTENDANCE RECORDER");
		heading.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		recordframe.add(heading);
		heading.setBounds(100,30,305,30);

		//Label class name
		JLabel classname = new JLabel("Class : ");
		recordframe.add(classname);
		classname.setBounds(20,70,45,30);
		//input class name
		JTextField classnamein=new JTextField();
		classnamein.setToolTipText("Ex. CSE_sem_iii_A");
    recordframe.add(classnamein);
    classnamein.setBounds(65,70,110,30);

    //Label subject name
		JLabel subjectname = new JLabel("Subject : ");
		recordframe.add(subjectname);
		subjectname.setBounds(180,70,90,30);
		//input subject name
		JTextField subjectnamein=new JTextField();
		subjectnamein.setToolTipText("Ex. math");
    recordframe.add(subjectnamein);
    subjectnamein.setBounds(235,70,110,30);

		//Lable Date
		JLabel date=new JLabel("Date : ");
		recordframe.add(date);
		date.setBounds(350,70,90,30);
		//input Date
		JTextField datein=new JTextField();
		datein.setToolTipText("Ex. DD/MM/YYYY");
    recordframe.add(datein);
    datein.setBounds(390,70,80,30);

    //label Attendance
    JLabel atnlabel = new JLabel("Attendance : ");
		recordframe.add(atnlabel);
		atnlabel.setBounds(50,110,90,30);
		//input Attendance
		//code for text box start
    	JPanel middlePanel = new JPanel ();
	    JTextArea atn = new JTextArea ("  Paste your Attendance here...", 15, 20);
	    atn.setEditable ( true ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( atn );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    middlePanel.add ( scroll );
	    recordframe.add(middlePanel);
	    recordframe.pack();
	    recordframe.setLocationRelativeTo ( null );
	    recordframe.setVisible ( true );
	    middlePanel.setLocation(120,115);
		//code for text box ends

		//button
		JButton btn=new JButton("Save");
		btn.setBounds(200,400,95,30);
		recordframe.add(btn);
		//Action Listener
		btn.addActionListener(
			new ActionListener()
			{  
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(recordframe, "Attendance Recorded");
          // date.setText("Welcome to Javatpoint.");
	        try
	        {
					  writeToFile();
					}
					catch(Exception fw)
					{
					  fw.printStackTrace();
					}
        } 
        void writeToFile() throws Exception
        {
					try
					{
						int i;
						String filename= classnamein.getText()+""+subjectnamein.getText()+".txt";
						FileWriter fw = new FileWriter(filename,true);
						fw.write("\n------------------------------------------------------\n ");
						fw.write("Class : ");
						classnamein.write(fw);
						fw.write("      Subject : ");
						subjectnamein.write(fw);
						fw.write("      Date : ");
						datein.write(fw);
						fw.write("\n");
						arrangetext();
						atn.write(fw);
						fw.close();
						setblank();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
				void setblank()
				{
					classnamein.setText("");
					datein.setText("");
					atn.setText("");
					subjectnamein.setText("");
				}
				void arrangetext()
				{
					String entrdvalue=atn.getText();
					atn.setText("");
					// System.out.println(entrdvalue);
					String temp;
					char [] attendclear=entrdvalue.toCharArray();
					for(int i=0;i<entrdvalue.length();i++)
					{
						if(	 attendclear[i]=='1'
							&& attendclear[i+1]=='9'
							&& attendclear[i+2]=='c'
							&& attendclear[i+3]=='s'
							&& attendclear[i+4]=='e'){
							// String roll=attendclear[i+5]+attendclear[i+6]+attendclear[i+7];
							// i=i+7;
							temp =attendclear[i]+
								 ""+attendclear[i+1]+
								 ""+attendclear[i+2]+
								 ""+attendclear[i+3]+
								 ""+attendclear[i+4]+
								 ""+attendclear[i+5]+
								 ""+attendclear[i+6]+
								 ""+attendclear[i+7];
							i+=7;
							// System.out.println(temp);
	        		atn.setText(atn.getText()+"\n"+temp);
						}
					}
					// System.out.println(entrdvalue.length());
				}
    	}
    );
    recordframe.setSize(500,500);
		recordframe.setLayout(null);
		recordframe.setVisible(true);
		recordframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	private static void seeAttendance(JTextField clsnmin,JTextField subin) throws Exception{
    JFrame seeframe=new JFrame("SEE ATTENDANCE");
    boolean found = true;

		int ch;
    // check if File exists or not 
    FileReader fr=null;
    try
    {
    	String filename= clsnmin.getText()+""+subin.getText()+".txt";
      fr = new FileReader(filename); 
    } 
    catch (FileNotFoundException fe) 
    { 
    	found=false;
    	JLabel error=new JLabel("File Not Found !!");
    	error.setFont(new Font("Verdana", Font.PLAIN, 50));
			
			error.setBounds(19,180,900,70);
			seeframe.add(error);
      System.out.println("File not found"); 
    } 

	  if(found)
	  {
			JPanel pan = new JPanel ();
	    JTextArea viewatnpage = new JTextArea ( 20 , 42);
	    viewatnpage.setEditable ( false ); // set textArea non-editable
	    JScrollPane scrolr = new JScrollPane ( viewatnpage );
	    scrolr.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	    pan.add ( scrolr );
	    seeframe.add(pan);
	    seeframe.pack();
	    // seeframe.setLocationRelativeTo ( null );
	    seeframe.setVisible ( true );
	    // pan.setLocation(0,0);
      // read from FileReader till the end of file 
      while ((ch=fr.read())!=-1)
      {
      	// String str =Integer.toString(ch); 
      	// l.setText(str);
      	viewatnpage.setText(viewatnpage.getText()+(char)ch);
      }
      // showtext(viewatnpage);
      // System.out.print((char)ch);
      //Lable Roll
			JLabel roll=new JLabel("Roll : ");
			seeframe.add(roll);
			roll.setBounds(20,340,90,30);
			//input Roll
			JTextField rollin=new JTextField();
			rollin.setToolTipText("Ex. 19cse174");
	  	seeframe.add(rollin);
	  	rollin.setBounds(90,340,110,30);

	  	// attendance find
			JLabel showatn=new JLabel("ATTENDANCE OF STUDENT :");
			seeframe.add(showatn);
			showatn.setBounds(220,340,500,30);

	  	//button
			JButton btn=new JButton("Find");
			btn.setBounds(50,380,95,30);
			seeframe.add(btn);

			//attend got
			JLabel atngot=new JLabel();
			seeframe.add(atngot);
			atngot.setBounds(230,360,500,30);

			//Action Listener
			btn.addActionListener(
				new ActionListener()
				{  
					public void actionPerformed(ActionEvent e)
					{
						
						int rollcount = 0,datecount=0;
						String rolllist=viewatnpage.getText();
						char [] rolllistnew=rolllist.toCharArray();
						String queryroll=rollin.getText();
						char [] query=queryroll.toCharArray();
						if(queryroll.length() == 0)
							atngot.setText("Enter Roll to see");
						else{
							System.out.println(queryroll);
							for(int i=0;i<rolllist.length()-7;i++)
							{
								if(	 rolllistnew[i]==query[0]
									&& rolllistnew[i+1]==query[1]
									&& rolllistnew[i+2]==query[2]
									&& rolllistnew[i+3]==query[3]
									&& rolllistnew[i+4]==query[4]
									&& rolllistnew[i+5]==query[5]
									&& rolllistnew[i+6]==query[6]
									&& rolllistnew[i+7]==query[7]){
									// System.out.println("check");
									rollcount++;
								}
								if(	rolllistnew[i]== 'D'
									&& rolllistnew[i+1]=='a'
									&& rolllistnew[i+2]=='t'
									&& rolllistnew[i+3]=='e')
									datecount++;
							}
							if(	query[0]=='1'
								&& query[1]=='9'
								&& query[2]=='c'
								&& query[3]=='s'
								&& query[4]=='e'){
								String print;
								print=queryroll+" has attended ";
								print=print+Integer.toString(rollcount)+" out of "+Integer.toString(datecount)+" Classes.";
								atngot.setText(print);
							}else{
								atngot.setText("INVALID ROLL !!");
							}
						}
						
						// System.out.println(datecount+" "+rollcount);
					}
				});

			// Notice
			JLabel notice=new JLabel("N.B.:  Enter Students Roll Number to find his Attendance.");
			seeframe.add(notice);
			notice.setBounds(50,420,500,30);

      // close the file
      fr.close();
    }
    seeframe.setSize(500,500);
		seeframe.setLayout(null);
  	seeframe.setVisible(true);
		seeframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public static void showtext(JTextArea viewatnpage)
	{
		String str = viewatnpage.getText();
		System.out.println(str);
	}
	public static void setblank(JTextField name)
	{
		name.setText("");
	}
}

