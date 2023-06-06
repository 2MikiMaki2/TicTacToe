import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Position implements Serializable{
    public int row;
    public int col;
        
    public Position(int r, int c){
        row = r;
        col = c;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void save(String fileName){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        }catch(IOException e)
        {
            System.out.println(e);
        }
    }

    public static Position load(String fileName){
        try{
            FileInputStream fis = new FileInputStream(fileName);
 
	         //Creating ObjectInputStream object.
	         ObjectInputStream ois = new ObjectInputStream(fis);
 
	         //write object.
	         Position b = (Position) ois.readObject();
 
	         //close streams.
	         ois.close();
	         fis.close();
            return b;
	      }catch(Exception e)
	      {
	          System.out.println(e);
	      }
          return null;
    }
}
