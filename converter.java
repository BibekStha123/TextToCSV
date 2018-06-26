package TextConvert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class converter {

	private ArrayList<People> people = new ArrayList<People>();
	
	public void reader() throws FileNotFoundException
	{
		FileReader fr = new FileReader("C:\\Users\\Bibek Shrestha\\oxygenworkspace\\CoreJava\\src\\TextConvert\\name.txt");
		BufferedReader br = new BufferedReader(fr);
		
		try {
			
			String st = null;
			
			while((st=br.readLine())!=null)
			{
				String sp [] = st.split(" ");
				People p = new People();
				p.setRoll(Integer.parseInt(sp[0]));
				p.setNmae(sp[1]);
				p.setProfession(sp[2]);
				p.setAddress(sp[3]);
				
				
				people.add(p);
				
				for(String s : sp)
				{
					System.out.println(s);
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void writer()
	{
		
		File f = new File("namecsv.txt");
		
		try {
		if(!f.exists())
		{
			
				f.createNewFile();
				
		}	
		
		PrintWriter p = new PrintWriter(f);
		
				for(int i=0;i<people.size();i++)
				{
					
					People pe= people.get(i);
					String st = pe.getRoll()+", "+pe.getName()+", "+pe.getProfession()+", "+pe.getAddress();
				
//					if(i!=people.size())
//					{
//						st+=", ";
//					}
					
					System.out.println(st);
				    p.println(st);
				    p.flush();
				    	 
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
}
