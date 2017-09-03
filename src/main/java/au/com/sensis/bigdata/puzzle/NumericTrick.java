package au.com.sensis.bigdata.puzzle;

public class NumericTrick {

    public static void main(String[] args) {

		for(int i=0;i<5;i++) {
			System.out.println((int) (Math.random() * 10));
		}

        Float f = new Float(3.1);
        Integer i=new Integer(1);
        long m =2;
        System.out.println(m+f+i);
        System.out.println(""+m+f+i);

    }
}
