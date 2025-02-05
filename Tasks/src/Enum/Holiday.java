package Enum;
import utils.Constants;
public class Holiday {
	public static void main(String[] args) {
		for(DaysOfWeek day:DaysOfWeek.values())
		{
			if(day==DaysOfWeek.SATURDAY || day ==DaysOfWeek.SUNDAY)
				System.out.println(Constants.HOLIDAY+" - "+day);
			else
				System.out.println(Constants.NOT_HOLIDAY+" - "+day);
				
		}
	}

}
