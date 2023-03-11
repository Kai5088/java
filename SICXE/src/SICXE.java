import java.io.*;
import java.util.*;
 
class Data{
	String first="",second="",third="",str="",opcode="",format="";
	public Data(String first, String second, String third, String str,String opcode,String format) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.opcode=opcode;
		this.format=format;
		this.str = str;
	}
}
class Pair{
	String symbol = "";
	String location = "";
 
	public Pair(String symbol, String location) {
		this.symbol = symbol;
		this.location = location;
	}
}
public class SICXE {
 
	public static void main(String[] args) throws IOException {
		String op_TAB[][]={{"ADD","3","18"},{"ADDF","3","58"},{"ADDR","2","90"},{"AND","3","40"},{"CLEAR","2","B4"},{"COMPF","3","88"},{"COMPR","2","A0"},{"COMP","3","28"},{"DIVF","3","64"}
		,{"DIVR","2","9C"},{"DIV","3","24"},{"FIX","1","C4"},{"FLOAT","1","C0"},{"HIO","1","F4"},{"J","3","3C"},{"JEQ","3","30"},{"JGT","3","34"},{"JLT","3","38"},{"JSUB","3","48"}
		,{"LDA","3","00"},{"LDB","3","68"},{"LDCH","3","50"},{"LDF","3","70"},{"LDL","3","08"},{"LDS","3","6C"},{"LDT","3","74"},{"LDX","3","04"},{"LPS","3","E0"},{"UML","3","20"}
		,{"MULF","3","60"},{"MULR","2","98"},{"NORM","1","C8"},{"OR","3","44"},{"RD","3","D8"},{"RMO","2","AC"},{"RSUB","3","4C"},{"SHIFTL","2","A4"},{"SHIFTR","2","A8"},{"SIO","1","F0"}
		,{"SSK","3","EC"},{"STA","3","0C"},{"STB","3","78"},{"STCH","3","54"},{"STF","3","80"},{"STI","3","D4"},{"STL","3","14"},{"STSW","3","E8"},{"STS","3","7C"},{"STT","3","84"}
		,{"STX","3","10"},{"SUBF","3","5C"},{"SUBR","2","94"},{"SUB","3","1C"},{"SVC","2","B0"},{"TD","3","E0"},{"TIO","1","F8"},{"TIXR","2","B8"},{"TIX","3","2C"},{"WD","3","DC"}};
		
 
		ArrayList<Data> Data = new ArrayList<>();
		ArrayList<String> Length = new ArrayList<>();
		ArrayList<String> Location = new ArrayList<>();
		ArrayList<Pair> SYM_TAB = new ArrayList<>();
		ArrayList<String> Target = new ArrayList<>();
		FileReader fr = new FileReader("SICXE.txt");
		BufferedReader br = new BufferedReader(fr);
		Scanner scn =new Scanner(br);
		int n = 0, DecLoc = 0, j = 0, i = 0,k=0,len=0;
		String HexLoc="0",str1=" ",str2=" ",str3=" ",op=" ",format=" ",base=" ";
		boolean isOpCode = false,isLine=false;
		while(scn.hasNext()){
			String tempString = scn.next();
			
			if(tempString.equals("START")||tempString.equals("END")||tempString.equals("WORD")||tempString.equals("BYTE")||tempString.equals("RESB")||tempString.equals("RESW")||tempString.equals("BASE")){
				str2=tempString;
				isOpCode=true;
			}
			else{
				String s=tempString;
				if(tempString.contains("+")){
					s=tempString.substring(1, tempString.length());
					len=1;
				}
				for(i=0;i<op_TAB.length;i++){
					if(s.equals(op_TAB[i][0])){
						str2=tempString;//��Jsecond
						op=op_TAB[i][2];
						len=len+Integer.parseInt(op_TAB[i][1]);//��J����
						format=Integer.toString(len);
						isOpCode=true;
						break;
					}
				}
			}
			if(tempString.equals(".")){
				str1=".";
				isLine=true;
			}
			
			if(str2.equals("RSUB"))
				isLine=true;
			if(!isOpCode){
				str1=tempString;
			}
			else if(!str2.equals("RSUB")){
					str3=scn.next();
					isLine=true;
			}
			if(isLine){
			Data.add(new Data(str1,str2,str3,str1+str2+str3,op,format));
			Length.add(Integer.toString(len));
			str1=" ";str2=" ";str3=" ";len=0;op=" ";format=" ";
			isLine=false;
			isOpCode=false;
			}
		}
		fr.close();
		for(i=0;i<Data.size();i++){
			// �p���m//
						if (Data.get(i).str.contains(".")||Data.get(i).str.contains("BASE")) {
							if(Data.get(i).str.contains("BASE"))
								base=Data.get(i).third;//���x�sbase�Ȧs�����B�⤸����Q��SYM_TAB��X��m(Base Relative)
							Location.add("");
							HexLoc = (Integer.toHexString(DecLoc += Integer.parseInt(Length.get(i-1),16))).toUpperCase();
						} else {
							if (i >1) {
								HexLoc = (Integer.toHexString(DecLoc += Integer.parseInt(Length.get(i-1),16))).toUpperCase();
								if (i == Data.size() - 1)//END�L��m
									HexLoc = "";
							} else// �_�l��m�q1�}�l
								HexLoc = Integer.toString(0);
							Location.add(HexLoc);
						}
			//�p�����
			if(Data.get(i).second.equals("BYTE")){
				if (Data.get(i).third.contains("C")) {// ��C'EOF'�ɪ���3
					char c[] = Data.get(i).third
							.substring(Data.get(i).third.indexOf('\'') + 1, Data.get(i).third.length() - 1)
							.toCharArray();
					Length.remove(i);
					Length.add(i,Integer.toString(c.length));
				} else{
					Length.remove(i);
					Length.add(i,"1");// ��X'F1'�ɪ���1
				}
			} else if (Data.get(i).second.contains("RESW")) {// ��RESW�ɼƦr*3
				Length.remove(i);
				Length.add(i,Integer.toHexString(Integer.parseInt(Data.get(i).third) * 3)); 
			} else if (Data.get(i).second.contains("RESB")) {
				Length.remove(i);
				Length.add(i,Integer.toHexString(Integer.parseInt(Data.get(i).third)));
			} else if (Data.get(i).second.contains("WORD")){  // WORD 3
				Length.remove(i);
				Length.add(i,"3");
			}
			else if (Data.get(i).second.contains("CLEAR")){  // CLEAR 2
				Length.remove(i);
				Length.add(i,"2");
			}
			// �إ�SYM_TAB//
			if (!Data.get(i).first.contains(" ") && i != 0 && !Data.get(i).first.contains(".")) {
				if(Data.get(i).first.equals(base))
					base=HexLoc;
				SYM_TAB.add(new Pair(Data.get(i).first, HexLoc));
			}
		}
		/// pass2�إߥت��X///
		for (i = 0; i < Data.size(); i++){
			StringBuilder s=new StringBuilder("");
			//Format 2(opcode r1 r2)
			if(Data.get(i).format.equals("2")){
				s=s.append(Data.get(i).opcode);
				String arr[]=Data.get(i).third.split(",");
				for(k=0;k<arr.length;k++){
					if(arr[k].equals("B"))
						s=s.append("3");
					else if(arr[k].equals("S"))
						s=s.append("4");
					else if(arr[k].equals("T"))
						s=s.append("5");
					else if(arr[k].equals("F"))
						s=s.append("6");
					else if(arr[k].equals("A"))
						s=s.append("0");
					else if(arr[k].equals("X"))
						s=s.append("1");
				}
				if(k==1)//�Y�Lr2�h��0
					s=s.append("0");
			}
			//Format 4 (opcode nixbpe address)
			if(Data.get(i).format.equals("4")){
				String str="",nixbpe="";
				str=Integer.toBinaryString(Integer.parseInt(Data.get(i).opcode,16));
				if(str.equals("0"))str="000000";//LDA����0�]��opcode=0
				if(Data.get(i).third.contains("#"))
					nixbpe="010001";
				else if(Data.get(i).third.contains("@"))
					nixbpe="100001";
				else if(Data.get(i).third.contains(",X"))
					nixbpe="111001";
				else 
					nixbpe="110001";
				str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
				if(str.length()!=3){//�J�� LDA ��0							
					str=new StringBuilder(str).reverse().append("0").reverse().toString();
				}
				for(k=0;k<SYM_TAB.size();k++){
					if(Data.get(i).third.contains
							(SYM_TAB.get(k).symbol)){
						if(SYM_TAB.get(k).location.length()!=5){//SYM 5�줸��0 (20/4=5)
							for(int l=SYM_TAB.get(k).location.length();l<5;l++)
								str+="0";
						}
						str+=SYM_TAB.get(k).location;
						break;
					}
				}
				char c[]=Data.get(i).third.toCharArray();
				if((c[1]-'0'>=0&&c[1]-'0'<=9)){ //#4096�Q��Q��->1000 ��Jhex
					String hex=Integer.toHexString(Integer.parseInt(Data.get(i).third.substring(1, Data.get(i).third.length())));
					if(hex.length()!=5){//hex�n 5�줸�ø�0 (20/4=5)
						for(int l=hex.length();l<5;l++)
							str+="0";
					}
					str+=hex;
				}		
				s.append(str);
			}
			//Format 3 (opcode nicbpe disp)
			if(Data.get(i).format.equals("3")){
				String str="",nixbpe="";
				str=Integer.toBinaryString(Integer.parseInt(Data.get(i).opcode,16));//op16�i�����str
				if(str.equals("0"))str="000000";
				if(Data.get(i).third.equals(" ")||Data.get(i).equals("RSUB")){
					nixbpe="110000";
					str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
					str+="000";
				}
				else if(Data.get(i).third.contains(",X")){//,X�]�t
					String num="",num2=Location.get(i+1);
					int tot=0;
					for(k=0;k<SYM_TAB.size();k++){
						if(Data.get(i).third.contains
								(SYM_TAB.get(k).symbol)){
							num=SYM_TAB.get(k).location;
							break;
						}
					}
					tot=Integer.parseInt(num,16)-Integer.parseInt(num2,16);
					if(tot<2047&&tot>-2048){
						nixbpe="111010";
						str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
						if(str.length()!=3){//�J�� LDA ��0							
							str=new StringBuilder(str).reverse().append("0").reverse().toString();
						}
						if(Integer.toHexString(tot).length()!=3){
							for(int l=Integer.toHexString(tot).length();l<3;l++)
								str+="0";
						}
						str+=Integer.toHexString(tot).toUpperCase();						
					}else{
						nixbpe="111100";
						tot=Integer.parseInt(num,16)-Integer.parseInt(base,16);//����ϥ�Base�Ȧs
						str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
						if(str.length()!=3){//�J�� LDA ��0							
							str=new StringBuilder(str).reverse().append("0").reverse().toString();
						}
						if(Integer.toHexString(tot).length()!=3){
							for(int l=Integer.toHexString(tot).length();l<3;l++)
								str+="0";
						}
						str+=Integer.toHexString(tot).toUpperCase();
						
					}//�٦� op c,x  op m,x sic
				}else if(Data.get(i).third.contains("#")||Data.get(i).third.contains("@")){//# @
					char c[]=Data.get(i).third.toCharArray();
					if((c[1]-'0'>=0&&c[1]-'0'<=9)){//#3�� op #c
						String num=Data.get(i).third.substring(1, Data.get(i).third.length());
						num=Integer.toHexString(Integer.parseInt(num)).toUpperCase();
						if(Data.get(i).third.contains("#"))
							nixbpe="010000";
						else
							nixbpe="100000";
						str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
						if(str.length()!=3){//�J�� LDO ��0							
							str=new StringBuilder(str).reverse().append("0").reverse().toString();
						}
						if(num.length()!=3){
							for(int l=num.length();l<3;l++)
								str+="0";
						}
						str+=num;
					}else{
						String num="",num2=Location.get(i+1);
						int tot=0;
						for(k=0;k<SYM_TAB.size();k++){
							if(Data.get(i).third.contains
									(SYM_TAB.get(k).symbol)){
								num=SYM_TAB.get(k).location;
								break;
							}
						}
						if(num2.equals(""))//�J��BASE�bŪ�U�@�Ӧ�m
							num2=Location.get(i+2);
							tot=Integer.parseInt(num,16)-Integer.parseInt(num2,16);
						if(tot<2047&&tot>-2048){
							if(Data.get(i).third.contains("#"))
								nixbpe="010010";
							else
								nixbpe="100010";
							str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
							if(str.length()!=3){//�J�� LDA ��0							
								str=new StringBuilder(str).reverse().append("0").reverse().toString();
							}
							if(Integer.toHexString(tot).length()!=3){
								for(int l=Integer.toHexString(tot).length();l<3;l++)
									str+="0";
							}
							str+=Integer.toHexString(tot).toUpperCase();						
						}else{
							if(Data.get(i).third.contains("#"))
								nixbpe="010100";
							else
								nixbpe="100100";
							tot=Integer.parseInt(num,16)-Integer.parseInt(base,16);//����ϥ�Base�Ȧs
							str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
							if(str.length()!=3){//�J�� LDA ��0							
								str=new StringBuilder(str).reverse().append("0").reverse().toString();
							}
							if(Integer.toHexString(tot).length()!=3){
								for(int l=Integer.toHexString(tot).length();l<3;l++)
									str+="0";
							}
							str+=Integer.toHexString(tot).toUpperCase();
						}
					}
				}else{
					String num="",num2=Location.get(i+1);
					int tot=0;
					for(k=0;k<SYM_TAB.size();k++){
						if(Data.get(i).third.contains
								(SYM_TAB.get(k).symbol)){
							num=SYM_TAB.get(k).location;
							break;
						}
					}
					tot=Integer.parseInt(num,16)-Integer.parseInt(num2,16);
					if(tot<2047&&tot>-2048){
						nixbpe="110010";
						str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
						if(str.length()!=3){//�J�� LDA ��0							
							str=new StringBuilder(str).reverse().append("0").reverse().toString();
						}
						if(Integer.toHexString(tot).length()<3){
							for(int l=Integer.toHexString(tot).length();l<3;l++)
								str+="0";
						}
						if(Integer.toHexString(tot).length()>3){//��t�ƪ��פj��T����
							StringBuffer s1=new StringBuffer(Integer.toHexString(tot).toUpperCase());
							str+=new StringBuffer(s1.reverse().substring(0,3)).reverse();
						}
						else
							str+=Integer.toHexString(tot).toUpperCase();						
					}else{
						nixbpe="110100";
						tot=Integer.parseInt(num,16)-Integer.parseInt(base,16);//����ϥ�Base�Ȧs
						str=Integer.toHexString(Integer.parseInt((str.substring(0,str.length()-2)+nixbpe),2)).toUpperCase();
						if(str.length()!=3){//�J�� LDA ��0							
							str=new StringBuilder(str).reverse().append("0").reverse().toString();
						}
						if(Integer.toHexString(tot).length()!=3){
							for(int l=Integer.toHexString(tot).length();l<3;l++)
								str+="0";
						}
						if(Integer.toHexString(tot).length()>3){//��t�ƪ��פj��T����
							StringBuffer s1=new StringBuffer(Integer.toHexString(tot).toUpperCase());
							str+=new StringBuffer(s1.reverse().substring(0,3)).reverse();
						}
						else
							str+=Integer.toHexString(tot).toUpperCase();
					}
				}
				/*end*/
				s.append(str);
			}
			if (Data.get(i).second.equals("BYTE")) {
				String str="";
				char c[] = Data.get(i).third
						.substring(Data.get(i).third.indexOf('\'') + 1, Data.get(i).third.length() - 1)
						.toCharArray();
				for (k = 0; k < c.length; k++) {
					if (Data.get(i).third.contains("C"))
						str+=(Integer.toHexString(c[k]).toUpperCase());// ASCii��10->16�ت��X
					else
						str+=(c[k]);
				}
				s.append(str);
			}
			
			Target.add(s.toString());		
		}
	//// �g��
			PrintWriter Write = new PrintWriter("SICXE_Final.txt");
			System.out.printf("%s\t%-6s\t%-6s\t%-5s\t%s\t\r\n", "��m", " ", "��l�ԭz", " ", "�ت��X");
			Write.printf("%s\t%-6s\t%-6s\t%-5s\t%s\t\r\n", "��m", " ", "��l�ԭz", " ", "�ت��X");
			System.out.println("------------------------------------------------");
			Write.println("------------------------------------------------");
			for (j = 0; j < Data.size(); j++) {
				Write.printf("%s\t%-6s\t%-6s\t%-10s\t%s\t\r\n", Location.get(j), Data.get(j).first,
						Data.get(j).second, Data.get(j).third, Target.get(j));
				System.out.printf("%s\t%-6s\t%-6s\t%-10s\t%s\t\r\n", Location.get(j), Data.get(j).first,
						Data.get(j).second, Data.get(j).third, Target.get(j));
			}
			Write.close();
		/*for(i=0;i<Data.size();i++){
			System.out.println(Location.get(i)+"\t"+Data.get(i).first+"\t"+Data.get(i).second+"\t"+Data.get(i).third+"\t\t"+Target.get(i));
		}*/
	}
}