package Challenge_01;

import java.text.DecimalFormat;

/*
 * Assuming that an "Event" is just a blurb of text and a time, no date
 */
public class HourEvent implements Comparable
{
	public static DecimalFormat formatter= new DecimalFormat("00");
	private String blurb;
	private int hour;
	private int minute;
	
	public HourEvent(String b, int h, int m)
	{
		setBlurb(b);
		setHour(h);
		setMinute(m);
	}
	public void setBlurb(String b)
	{
		blurb=b;
	}
	public void setHour(int h)
	{
		if(h>=0 && h<=24)
			hour=h;
		else
			throw new IllegalArgumentException("Hour must be between 0 and 24");
	}
	public void setMinute(int m)
	{
		if(m>=0 && m<=60)
			minute=m;
		else
			throw new IllegalArgumentException("Minute must be between 0 and 60");
	}
	@Override
	public int compareTo(Object obj)
	{
		HourEvent other = (HourEvent) obj;
		if(this.hour> other.hour)
			return 1;
		else if(other.hour>this.hour)
			return -1;
		else
		{
			if(this.minute>other.minute)
				return 1;
			else if(other.minute>this.minute)
				return -1;
			else
				return 0;
		}
	}
	@Override
	public String toString()
	{
		return this.blurb+" "+this.hour+":"+formatter.format(this.minute);
	}
}
