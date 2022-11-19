import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
	JFrame jframe;
	static String fileName;
	
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	}

	public void actionPerformed(ActionEvent event){
		String  menuName;
		menuName = event.getActionCommand();
	   
		if (menuName.equals("Open")){
			try{
				openFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (menuName.equals("Quit"))
			System.exit(0);
	} 

	private void openFile( ) throws IOException {
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser( );
		status = chooser.showOpenDialog(null);
       
		if (status == JFileChooser.APPROVE_OPTION) 
		{
			fileName = chooser.getSelectedFile().getName();
			readSource(fileName);
		}
		else 
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    }
  

    private void readSource(String fileName) throws IOException {
    	Date212TreeMap dtm = getDatesIntoTreeMap();
        TextArea unsortedDate212 = new TextArea();
		TextArea sortedDate212 = new TextArea();
		
		sortedDate212.append(dtm.toString());
		unsortedDate212.append(getTextFromFile(fileName));
       
        Container cPane = jframe.getContentPane();
        cPane.add(unsortedDate212, BorderLayout.WEST);
        cPane.add(sortedDate212, BorderLayout.EAST);
        
        jframe.pack();
        jframe.setVisible(true);  
    }
    

    private static String getTextFromFile(String fileName) throws IOException {
    	Scanner scanner = new Scanner(Paths.get("./" + fileName));
        String s = "";
        
        while (scanner.hasNextLine()) {
        	String line = scanner.nextLine();
            StringTokenizer myDateInput = new StringTokenizer(line,",");
            
            while(myDateInput.hasMoreTokens()) {
                s += (myDateInput.nextToken() + "\n");
            }
        }
        return s;
    }
    
 
    private static Date212TreeMap getDatesIntoTreeMap() throws IOException{
		String text = getTextFromFile(fileName);
		Date212TreeMap dtm = new Date212TreeMap();
        StringTokenizer myDateInput = new StringTokenizer(text, "\n");
        
        while(myDateInput.hasMoreTokens()) {
        	dtm.add(new Date212(myDateInput.nextToken()));
        }
        
        return dtm;
    }
}