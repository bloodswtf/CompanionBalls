

public class testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//HEADING
		int degree=0;
		double a=0;
		int pitch =0;
		int roll = 60;
		a = Math.atan2(pitch,-roll);
		//System.out.println(a);
		if (a<0){
			a = Math.PI+a;
			//System.out.println(a);
			a = a+Math.PI;
		}
		degree= (int) (57.2957794*a);
		System.out.println(degree);
		
		
		//SPEED
		double speed = (Math.abs(roll)+Math.abs(pitch)) /400f;
		
		System.out.println(speed);
	}

}
