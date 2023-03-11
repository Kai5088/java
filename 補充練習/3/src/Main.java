import java.util.Scanner;
public class Main {
	static class DayException extends Exception{
		public DayException() {
			super();
		}
		public DayException(String message) {
			super(message);
		}
	}
	
	static class MonthException extends Exception{
		public MonthException() {
			super();
		}
		public MonthException(String message) {
			super(message);
		}
	}

	static class YearException extends Exception{
		public YearException() {
			super();
		}
		public YearException(String message) {
			super(message);
		}
	}
	
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str3 ,st,st2,st3;
		
		boolean flag1=true;
        int a,b,c;
		while(flag1) {
			str3=sc.next();

			st=str3.substring(0,2);
			st2=str3.substring(3,5);
			st3=str3.substring(6,10);
			
			try {
				a = java.lang.Integer.parseInt(st);
				if(a<1||a>12) {throw new MonthException();}
			    b = java.lang.Integer.parseInt(st2);
			    if(b<1||b>31) {throw new DayException();}
			    c = java.lang.Integer.parseInt(st3);
			    if(c>3000||c<1000) {throw new YearException();}
			    
			    if(a==1) {
			    	System.out.print("January ");
			    }
			    else if(a==2) {
			    	System.out.print("February ");
			    }
			    else if(a==3) {
			    	System.out.print("March ");
			    }
			    else if(a==4) {
			    	System.out.print("April ");
			    }
			    else if(a==5) {
			    	System.out.print("May ");
			    }
			    else if(a==6) {
			    	System.out.print("June ");
			    }
			    else if(a==7) {
			    	System.out.print("July ");
			    }
			    else if(a==8) {
			    	System.out.print("August ");
			    }
			    else if(a==9) {
			    	System.out.print("September ");
			    }
			    else if(a==10) {
			    	System.out.print("October ");
			    }
			    else if(a==11) {
			    	System.out.print("November ");
			    }
			    else if(a==12) {
			    	System.out.print("December ");
			    }
			    System.out.printf("%d%d",b/10,b%10);
			    System.out.printf(", %d",c);
			    flag1=false;
			}
			catch(MonthException e){
				System.out.println("Wrong Month");
			} catch (DayException E) {
				System.out.println("Wrong Day");
			} catch (YearException E) {
				System.out.println("Wrong Year");
			}
			
		}
	
		

	}
}
