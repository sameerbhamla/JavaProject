public class Date212 {
	private int day;
	private int month;
	private int year;

	public Date212(String date){
		if(date.length() != 8)
			throw new IllegalDate212Exception("Valid dates should be 8 digits.");
		setYear(Integer.parseInt(date.substring(0 , 4)));
		setMonth(Integer.parseInt(date.substring(4 , 6)));
		setDay(Integer.parseInt(date.substring(6 , 8)));
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setDay(int d){
		if (d >= 1 && d <= daysInMonths(month)) 
            day = d;
		else
			throw new IllegalDate212Exception("Day should be between 1 and " + daysInMonths(month) + " for month " + month + ".");
        	
	}
	
	public void setMonth(int m){
		if(m >= 1 && m <= 12 )
			month = m;
		else
			throw new IllegalDate212Exception("Month should be between 1 and 12.");
	}
	
	public void setYear(int y){
		if(y >= 0)
			year = y;
		else
			throw new IllegalDate212Exception("Year should not be negative.");
	}
	
	public boolean equals(Date212 date){
		return this.day == date.day && this.month == date.month && this.year == date.year;
	}
	
	public int compareTo(Date212 date){
		int y = this.year - date.year; //to get the difference between the year of current object and input object
		int m = this.month - date.month; //to get the difference between the months
		int d = this.day - date.day; //to get the difference between the days
		if(y > 0)//if the current years are larger, return 1
			return 1;
		else if(y < 0)//if the current year are smaller, return -1
			return -1;
		else //if the years are the same, then compare the months
			if(m > 0 ) 
				return 1;
			else if(m < 0)
				return -1;
			else //if the months are the same, then compare the days
				if(d > 0) 
					return 1;
				else if(d < 0) 
					return -1;
				else 
					return 0; //if two object are the same, return 0
	}
	
	public int daysInMonths(int m){
		int[] monthWith31days = {1,3,5,7,8,10,12};
		int[] monthWith30days = {4,6,9,11};
		for(int i:monthWith31days){
			if(m == i)
				return 31;
		}
		for(int i:monthWith30days){
			if(m == i)
				return 30;
		}
		if(m == 2 && year % 4 == 0)
			return 29;
		else
			return 28;
	}
	
	public String toString(){
		String[] months = {"", "January", "February", "March", "April", "May", "June", 
						   "July", "August", "September", "October", "November", "December"}; //put name of the months in a list
		String date = months[month] + " " + day + ", " + year; //put the dates in format
		return date;
	}
}
