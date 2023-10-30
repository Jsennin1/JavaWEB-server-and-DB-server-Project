package kadai4;
import java.io.*;




public class FileBean {
private String fname = null;
private String data = null;
public FileBean(){ this("id_data.txt"); }
public FileBean(String s){
this.fname = s;
}


public Boolean loadData(String idAndPass){
FileReader reader = null;
BufferedReader breader = null;
try {
reader = new FileReader(this.fname);
breader = new BufferedReader(reader);
String tmp = "";
String result = "";
while((tmp = breader.readLine()) != null){
if(tmp.equals(idAndPass))
	return true;
}
this.data = result;
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
breader.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return false;
}
}